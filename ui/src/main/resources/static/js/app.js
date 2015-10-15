var tvShowDbApp = angular.module('tvShowDbApp', ['ngResource', 'ngRoute']);

tvShowDbApp.constant('gatewayURL', 'http://localhost:8002');

tvShowDbApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when('/', {
            templateUrl: 'show-list.html',
            controller: 'ShowListCtrl'
        }).
        when('/show/:id', {
            templateUrl: 'show.html',
            controller: 'ShowCtrl'
        }).
        otherwise({
            redirectTo: '/'
        });
}]);

tvShowDbApp.factory('Shows', ['$resource', 'gatewayURL', function($resource, gatewayURL) {
    return $resource(gatewayURL+'/shows/shows/:id',
        {id:'@id'},
        {'query': {method: 'GET', isArray: false }}
    );
}]);

tvShowDbApp.factory('Reviews', ['$resource', 'gatewayURL', function($resource, gatewayURL) {
    return $resource(gatewayURL+'/reviews/reviews/:id',
        {id:'@id'},
        {'search': {method: 'GET', url:gatewayURL+'/reviews/reviews/search/by-show', isArray: false }}
    );
}]);

tvShowDbApp.controller('ShowListCtrl', function ($scope, $resource, Shows) {

    Shows.query().$promise.then(function(results) {
        $scope.shows = results._embedded.shows;
    });

});

tvShowDbApp.controller("ShowCtrl", function($scope, $routeParams, Shows, Reviews) {

    $scope.show = Shows.get({id: $routeParams.id});
    Reviews.search({showId: $routeParams.id}).$promise.then(function(results) {
        $scope.reviews = results._embedded.reviews;
    });

});