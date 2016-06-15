angular.module('ratingApp.contactsModule', ['ngRoute'])
.config(function($routeProvider) {
    $routeProvider.when('/contacts', {
        templateUrl: '/views/contacts/contacts.html',
        controller: 'ContactsController',
        controllerAs: 'ctrl'
    });
})
.controller('ContactsController', function(PageService, $route, $rootScope) {
    var self = this;
    PageService.getPage($rootScope.path).then(function(page) {
        self.page = page;
    });
});
