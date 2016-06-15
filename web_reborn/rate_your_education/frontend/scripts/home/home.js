angular.module('ratingApp.homeModule', ['ngRoute'])
.config(function($routeProvider) {
    $routeProvider.when('/home', {
        templateUrl: '/views/home/home.html',
        controller: 'HomeController',
        controllerAs: 'ctrl'
    });
})
.controller('HomeController', function(PageService, $route, $rootScope) {
    var self = this;
    PageService.getPage($rootScope.path).then(function(page) {
        self.page = page;        
    });
});
