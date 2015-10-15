#!/bin/sh

# A POSIX variable
OPTIND=1         # Reset in case getopts has been used previously in the shell.

# Initialize our own variables:
compile=1
shows=1
actors=1
reviews=1
ui=1
verbose=0

while getopts "h?vc:a:s:u:r:" opt; do
    case "$opt" in
    h|\?)
        show_help
        exit 0
        ;;
    v)  verbose=1
        ;;
    c)  compile=$OPTARG
        ;;
    s)  shows=$OPTARG
        ;;
    a)  actors=$OPTARG
        ;;
    r)  reviews=$OPTARG
        ;;
    u)  ui=$OPTARG
        ;;
    esac
done

shift $((OPTIND-1))

[ "$1" = "--" ] && shift

if [ ! -d logs ]
then
    mkdir logs
else
    rm -rf logs/*
fi

if [ $compile == "1" -o $compile == "true" ] ; then
    echo "Building services"
    ./gradlew build -x test > logs/build.out 2>&1
    if [ $? != 0 ]; then
        cat logs/build.out
        exit
    fi
fi

JVM_OPTS="-Xmx256m -Xms64m"

echo "Starting RabbitMQ"
docker rm -f tvshow-rabbitmq 2&> /dev/null
docker run -d --name tvshow-rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management > /dev/null

echo "Starting supervisor"
java ${JVM_OPTS} -jar supervisor/build/libs/supervisor-*.jar > logs/supervisor.out 2>&1 &
sleep 5

echo "Starting gateway"
java ${JVM_OPTS} -jar gateway/build/libs/gateway-*.jar > logs/gateway.out 2>&1 &
sleep 5

echo "Starting $shows shows service"
java ${JVM_OPTS} -Dserver.port=8011  -jar shows/build/libs/shows-*.jar > logs/shows.out 2>&1 &
if [ $shows -gt 1 ]; then
    for i in $(seq 2 ${shows}); do
        java ${JVM_OPTS} -Dserver.port=801$i -jar shows/build/libs/shows-*.jar > logs/shows-$i.out 2>&1 &
    done
fi
sleep 5

echo "Starting $actors actors service"
java ${JVM_OPTS} -Dserver.port=8021  -jar actors/build/libs/actors-*.jar > logs/actors.out 2>&1 &
if [ $actors -gt 1 ]; then
    for i in $(seq 2 ${actors}); do
        java ${JVM_OPTS} -Dserver.port=802$i -jar actors/build/libs/actors-*.jar > logs/actors-$i.out 2>&1 &
    done
fi
sleep 5

echo "Starting $reviews reviews service"
java ${JVM_OPTS} -Dserver.port=8031  -jar reviews/build/libs/reviews-*.jar > logs/reviews.out 2>&1 &
if [ $reviews -gt 1 ]; then
    for i in $(seq 2 ${reviews}); do
        java ${JVM_OPTS} -Dserver.port=803$i -jar reviews/build/libs/reviews-*.jar > logs/reviews-$i.out 2>&1 &
    done
fi
sleep 5

echo "Starting $ui UI"
java ${JVM_OPTS} -jar ui/build/libs/ui-*.jar > logs/ui.out 2>&1 &
if [ $ui -gt 1 ]; then
    for i in $(seq 2 ${ui}); do
        java ${JVM_OPTS} -Dserver.port=808$[$i-1] -jar ui/build/libs/ui-*.jar > logs/ui-$i.out 2>&1 &
    done
fi
sleep 5

echo "TVShowDB started"
