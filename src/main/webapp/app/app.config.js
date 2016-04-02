/**
 * 
 */
angular.module('app').config(navbarConfig);

navbarConfig.$inject = ['$stateProvider','$urlRouterProvider'];

function navbarConfig($stateProvider, $urlRouterProvider){
	var customer = {
			name: 'customer',
			url:'/customer',
			templateUrl :'customer',
			controller: 'CustomerCtrl'
	};
	
	var employee = {
			name:'employee',
			url:'/employee',
			templateUrl :'employee',
			controller : 'EmpCtrl'
	};
	
	$urlRouterProvider.otherwise("/employee");
	$stateProvider.state(customer).state(employee);
}