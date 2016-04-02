/**
 * 
 */
'use strict';
angular.module('app.navbar').controller('NavbarCtrl',NavbarCtrl);

NavbarCtrl.$inject = ['$scope','$location'];

function NavbarCtrl($scope,$location){
	
	$scope.navs = [{
		label : 'CustomerS',
		name : 'customer',
		url:'/customer'
	},{
		label : 'Employee',
		name: 'employee',
		url:'/employee'
	}];
	
	$scope.isActive = isActive;
	
	function isActive(viewLocation){
		return viewLocation === $location.path();
	};
};