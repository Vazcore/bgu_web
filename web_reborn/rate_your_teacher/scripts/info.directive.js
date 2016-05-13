angular.module('rateApp')
.directive('rInfo', function() {
	
	var html = '<div class="{{factor}}"><div class="about-us-col"><div class="col-icon-wrapper"><img width="70px" ng-src="img/{{info.logo}}" alt="website template image"></div><h3 class="col-title">{{info.title}}</h3><div class="col-details"><p>{{info.text}}</p></div><a href="{{info.more}}" class="btn btn-primary"> Read more </a></div></div>';

	return {
		template: html,
		scope: {
			factor: '@factor',
			info: '=info'
		},
		controller: function($scope){
			
		}
	};
});