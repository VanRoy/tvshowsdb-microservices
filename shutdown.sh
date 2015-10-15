#!/bin/sh

echo "Shutting down RabbitMQ"
docker rm -f tvshow-rabbitmq 2&> /dev/null

ports=`cat logs/*.out | grep started | grep "http" | sed "s/.*:\ \([0-9]*\).*/\1/g"`
for port in $ports; do
    echo "Shuting down for port " $port
    curl -s -o /dev/null -X POST http://localhost:$port/shutdown
done;

pkill -9 -f SNAPSHOT\.jar