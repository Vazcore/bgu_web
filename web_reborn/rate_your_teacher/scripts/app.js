var name = prompt('Type your name', 'Uknown');
alert('Hola, ' + name);

function getCookie(type) {
	if (document.cookie === undefined) return false;
	if (document.cookie.indexOf(type+'=') === -1) return false;
	var val = document.cookie.split(type+'=')[1];	
	if(val.indexOf(';')) {
		val = val.split(';')[0];
	}
	return val;
}

function setCookie(name, value, exp, path) {
	document.cookie = name + '=' + value + ';' + exp + '; path='+path;	
}

function changeDes(des) {
	document.querySelector('#des_ind').className = des;
}

window.onload = function(){
	var des = getCookie('design');	
	if (!des) {
		des = 'design_1';
		setCookie('design', des, '20 May 2016 20:59:01 UTC', '/');
	}
	changeDes(des);	
	var cur_des = document.querySelector('#cur_des');
	cur_des.innerHTML = des;

	document.querySelector('#des_1').onclick = function(){
		des = 'design_1';
		setCookie('design', des, '20 May 2016 20:59:01 UTC', '/');
		changeDes(des);	
	};

	document.querySelector('#des_2').onclick = function(){
		des = 'design_2';		
		setCookie('design', des, '20 May 2016 20:59:01 UTC', '/');	
		changeDes(des);	
	};
	
	//setCookie('name2', 'd2', '20 May 2016 20:55:01 UTC', '/');

	var clic_to_open = document.querySelector("#open_win");
	var my_win;
	var win_params = 'width=800px,height=400px;menu_bar=no';
	clic_to_open.onclick = function(){		
		my_win = window.open("file:///D:/15po15/Gabrusev/bgu_web/web_reborn/rate_your_teacher/index2.html", "New Win", win_params);
	};
	setTimeout(function() {
		my_win.close();
	}, 15000);
};


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
