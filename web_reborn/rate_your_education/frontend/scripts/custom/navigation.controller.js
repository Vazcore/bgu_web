angular.module('ratingApp')
.controller('NavigationController', function($scope, NavigationService, $window) {

    NavigationService.getLinks().then(function(links) {
        $scope.navLinks = links;
    });

    $scope.$on('routeChanged', function(e, params) {
        if ($scope.selectedLink) $scope.selectedLink.active = false;
        $scope.selectedLink = $window._.find($scope.navLinks, {href:'#!/'+params.path}, {});
        if ($scope.selectedLink) $scope.selectedLink.active = true;
    });
});
