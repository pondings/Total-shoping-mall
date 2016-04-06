/**
 * 
 */
'use strict';
angular.module('app.login').controller('loginCtrl', loginCtrl);
loginCtrl.$inject = [ '$scope', 'SweetAlert', 'Flash', '$ngBootbox', 'loginService' ];

function loginCtrl($scope, SweetAlert, Flash, $ngBootbox, loginService) {
	var vm = this;

	/** Declare Function * */
	vm.login = login;
	vm.resetForm = resetForm;

	/** Function * */

	function login(user) {
		loginService.login(user).then(function(data) {
	
		}, function(errRs) {
			Flash.create('danger', errRs.errMessage, 'custom-class');
		})
	}

	function resetForm() {
		vm.user = {
			username : null,
			password : null,
		};
	}
};