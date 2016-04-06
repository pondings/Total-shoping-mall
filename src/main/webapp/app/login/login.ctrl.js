/**
 * 
 */
'use strict';
angular.module('app.login').controller('loginCtrl', loginCtrl);
loginCtrl.$inject = [ '$scope',  'Flash', '$ngBootbox', 'loginService'];

function loginCtrl($scope,  Flash, $ngBootbox, loginService) {
	var vm = this;

	/** Declare Function * */
	vm.login = login;
	vm.resetForm = resetForm;

	/** Function * */

	function login(user) {
		console.log(user);
		console.log(user);
		loginService.login(user).then(function(data) {
	if(data.username){
		$rootScope.authenticated = true;
	} else{
		 $rootScope.authenticated = false;
	}
		}, function(errRs) {
			Flash.create('danger', errRs.errMessage, 'custom-class');
		})
	}

	function resetForm() {
		alert("commonnnn");
		vm.user = {
			username : null,
			password : null,
		};
	}
};