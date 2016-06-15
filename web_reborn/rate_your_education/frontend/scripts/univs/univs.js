angular.module('ratingApp.univsModule', ['ngRoute'])
.config(function($routeProvider) {
    $routeProvider.when('/univs', {
        templateUrl: '/views/univs/univs.html',
        controller: 'UnivsController',
        controllerAs: 'ctrl'
    });
})
.controller('UnivsController', function(PageService, $route, $rootScope) {
    var self = this;
    PageService.getPage($rootScope.path).then(function(page) {
        self.page = page;
    });
});
