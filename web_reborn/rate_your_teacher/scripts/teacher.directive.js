angular.module('rateApp')
.directive('rTeacher', function() {

	var html = '<div class="teacher"><div class="ava"><img height="150px" ng-src="img/teachers/{{teacher.ava}}"></div><p>{{teacher.name}}</p></div>'

	return {
		restrict: 'E',
		scope: {
			teacher: '=teacher'
		},
		template: html,
		controller: function($scope){

		}
	};
});
