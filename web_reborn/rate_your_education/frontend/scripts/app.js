angular.module('ratingApp', [
    'ngRoute',
    'ratingApp.custom_directives',
    'ratingApp.aboutModule',
    'ratingApp.homeModule',
    'ratingApp.proposeModule',
    'ratingApp.univsModule',
    'ratingApp.contactsModule'
])
.constant('_', window._)
.run(function($rootScope, $location, $routeParams) {
    $rootScope._ = window._;
    $rootScope.$on('$routeChangeSuccess', function(e, current, pre) {
        $rootScope.path = (current.$$route) ? current.$$route.originalPath.replace('\/', '') : '';
        $rootScope.$broadcast('routeChanged', {path: $rootScope.path});
    });
})
.config(function($locationProvider, $routeProvider) {
    $locationProvider.hashPrefix('!');
    $routeProvider.otherwise({redirectTo: '/home'});
});
