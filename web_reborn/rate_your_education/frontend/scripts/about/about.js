angular.module('ratingApp.aboutModule', ['ngRoute'])
.config(function($routeProvider) {
    $routeProvider.when('/about', {
        templateUrl: '/views/about/about.html',
        controller: 'AboutController',
        controllerAs: 'ctrl'
    });
})
.controller('AboutController', function(PageService, $route, $rootScope) {
    var self = this;
    PageService.getPage($rootScope.path).then(function(page) {
        self.page = page;
    });
});
