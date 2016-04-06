/**
 * 
 */
angular.module('app').config(navbarConfig);

navbarConfig.$inject = ['$stateProvider','$urlRouterProvider'];

function navbarConfig($stateProvider, $urlRouterProvider){
	var product = {
			name: 'product',
			url:'/product',
			templateUrl :'product',
			controller: 'ProdCtrl'
	};
	
	var employee = {
			name:'employee',
			url:'/employee',
			templateUrl :'employee',
			controller : 'EmpCtrl'
	};
	
	var customer = {
			name:'customer',
			url:'/customer',
			templateUrl :'customer',
			controller : 'UserCtrl'
	};
	
	var prodType = {
			name:'prodType',
			url:'/product_type',
			templateUrl :'product_type',
			controller : 'ProdTypeCtrl'
	};
	
	var user = {
			name:'user',
			url:'/user',
			templateUrl :'user',
			controller : 'UserCtrl'
	};
	
	var Home = {
			name:'home',
			url:'/',
			templateUrl :'',
			controller : 'NavbarCtrl'
	};
	
	var Login = {
			name:'login',
			url:'/login',
			templateUrl :'logins',
	};
	
	var Trade = {
			name:'trade',
			url:'/trade',
			templateUrl:'trade',
			controller : 'TradeSystemCtrl'
			
	};
	
	$urlRouterProvider.otherwise("/trade");
	$stateProvider.state(product).state(employee).state(customer).state(user).state(prodType).state(Home).state(Login).state(Trade);
}