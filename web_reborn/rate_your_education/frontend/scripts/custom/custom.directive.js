angular.module('ratingApp.custom_directives', [])
.directive('appNavigation', function() {
    return {
        restrict: 'A',
        scope: true,
        templateUrl: '/views/custom/navigation.html'
    };
})
.directive('appPage', function() {
    return {
        restrict: 'A',
        scope: true,
        templateUrl: '/views/custom/page.html'
    };
});
