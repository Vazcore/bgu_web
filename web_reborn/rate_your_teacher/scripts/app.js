angular.module('rateApp', [])
.controller('HomeController', function($scope) {

	var mockTeachers = [
		{name: 'Ivanchenko', rating:10, subject: 'Java', ava:'t1.jpg'},
		{name: 'Borodulya', rating:0, subject: 'Network', ava:'t1.jpg'}
	];

	var teacher = _.max(mockTeachers, _.property('rating'));

	$scope.topTeachers = mockTeachers;

	this.info = {title: 'What is a point?', text:'Lorem Ipsum is simply dummy text of the printing  Lorem Ipsum is simply dummy text of the printing  Lorem Ipsum is simply dummy text of the printing ', logo:'info1.png'};

});