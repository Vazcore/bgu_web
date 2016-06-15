angular.module('ratingApp.proposeModule', ['ngRoute'])
.config(function($routeProvider) {
    $routeProvider.when('/propose', {
        templateUrl: '/views/propose/propose.html',
        controller: 'ProposeController',
        controllerAs: 'ctrl'
    });
})
.controller('ProposeController', function(PageService, $route, $rootScope) {
    var self = this;
    PageService.getPage($rootScope.path).then(function(page) {
        self.page = page;
    });
});
