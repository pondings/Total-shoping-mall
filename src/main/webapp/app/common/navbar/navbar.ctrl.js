/**
 * 
 */
'use strict';
angular.module('app.navbar').controller('NavbarCtrl',NavbarCtrl);

NavbarCtrl.$inject = ['$scope','$location'];

function NavbarCtrl($scope,$location){
	
	$scope.navs = [{
		label:'Login',
		name:'login',
		url:'/login'
	},{
		label:'Home',
		name:'home',
		url:'/'
	},{
		label:'Customer',
		name:'customer',
		url:'/customer'
	},{
		label : 'Employee',
		name: 'employee',
		url:'/employee'
	},{
		label :'Product',
		name: 'product',
		url:'/product'
	},{
		label :'ProductType',
		name:'prodType',
		url:'/product_type'
	},{
		label:'User',
		name:'user',
		url:'/user'
	}];
	
	$scope.isActive = isActive;
	
	function isActive(viewLocation){
		return viewLocation === $location.path();
	};
};