'use strict';
angular.module('app.user').controller('UserCtrl', UserCtrl);
UserCtrl.$inject = [ '$scope', 'SweetAlert', 'Flash', '$ngBootbox',
		'UserService' ];

function UserCtrl($scope, SweetAlert, Flash, $ngBootbox, UserService) {
	var vm = this;

	/** tab * */
	vm.tabs = [ {
		title : 'ค้นหาประเภทสินค้า',
		tabIdx : 0,
		selected : true
	}, {
		title : 'เพิ่มแก้ไข ประเภทสินค้า',
		tabIdx : 0,
		selected : false
	} ];

	/** calendar * */

	vm.calendar = {
		opened : false
	}
	vm.calDate = function($event) {
		vm.calendar.opened = true;
	}

	/** pagination * */

	vm.numPerPage = 5;
	vm.numPerPages = [ {
		number : 5
	}, {
		number : 10
	}, {
		number : 15
	}, {
		number : 20
	}, {
		number : 25
	}, {
		number : 30
	} ];
	vm.selectedNumPerPage = vm.numPerPages[0];

	/** smart-table * */

	$scope.displayedUser = [].concat(vm.userList);
	$scope.displayedUserRole = [].concat($scope.displayedUserRole);
	$scope.displayedPages = 5;

	/** Declare Value * */
	vm.userStatus = [ {
		title : 'เปิดใช้งาน',
		value : true
	}, {
		title : 'ปิดใช้งาน',
		value : false
	} ];

	vm.selectedStatus = vm.userStatus[0];

	/** Declare Func * */

	vm.resetPage = resetPage;
	vm.search = search;
	vm.formControl = formControl;
	vm.create = create;
	vm.update = update;
	vm.remove = remove;
	vm.resetDefault = resetDefault;
	vm.resetForm = resetForm;
	vm.getRole = getRole;

	/** Function * */

	$scope.setClickedRow = function(role) {
		vm.userRole.role = role;
		$ngBootbox.hideAll();
	}

	function getRole() {
		UserService.getRole().then(function(data) {
			$scope.userRoleList = data;
			console.log(vm.userRoleList);
		}, function(errRs) {
			Flash.create('danger', errRs.errMessage, 'custom-class');
		})
	}

	function resetDefault() {
		vm.userRole = angular.copy(vm.substitute);
	}

	function remove(id) {
		UserService.remove(id).then(function(data) {
			Flash.create('success', 'Deleted', 'custom-class');
			for (var i = 0; i < vm.userList.length; i++) {
				if (vm.userList[i].id == id) {
					vm.userList.splice(i, 1);
					break;
				}
			}
		}, function(errRs) {
			Flash.create('danger', errRs.errMessage, 'custom-class');
		})
	}

	function formControl() {
		if (vm.userRole.id != null) {
			UserService.update(vm.userRole).then(
					function(data) {
						for (var i = 0; i < vm.userList.length; i++) {
							if (vm.userList[i].id == data.id) {
								$scope.displayedUser[i] = data;
								break;
							}
						}
						Flash.create('success', 'Updated', 'custom-class')
						vm.resetForm();
					},
					function(errRs) {
						Flash.create('danger', 'Please contact maintenance',
								'custom-class');
					})
		} else {
			vm.create();
		}
	}

	function create() {
		UserService.create(vm.userRole).then(function(data) {
			vm.userList.push(data);
			Flash.create('success', 'Created', 'custom-class');
			vm.resetForm();
		}, function(errRs) {
			Flash.create('danger', errRs.errMessage, 'custom-class');
		})
	}

	function update(userRole) {
		vm.userRole = angular.copy(userRole);
		vm.substitute = angular.copy(userRole);
		vm.tabs[1].selected = true;
	}

	function search() {
		UserService.search(vm.userRole).then(
				function(data) {
					vm.userList = data;
					Flash
							.create('success', "Found " + data.length
									+ " reccord", 'custom-class');
				}, function(errRs) {
					Flash.create('danger', errRs.errMessage, 'custom-class');
				})
	}

	function resetPage() {
		vm.userRoleList = [];
		vm.userList = [];
		vm.userRole = {
			id : null,
			role : null,
			user : {
				username : null,
				enabled : true,
				password : null,
				listOfUserRole : null
			}
		};
		vm.userForm.$setPristine();
	}

	function resetForm() {
		vm.userRole = {
			id : null,
			role : null,
			user : {
				username : null,
				enabled : null,
				password : null,
				listOfUserRole : null
			}
		};
		vm.userForm.$setPristine();
	}

	/** Modal * */
	vm.viewDialogButton = {
		main : {
			label : "Close",
			className : "btn-primary",
			callback : function() {
			}
		}
	};

	vm.viewRoleModal = {
		scope : $scope,
		title : 'Select Role',
		onEscape : function() {
		},
		show : true,
		backdrop : true,
		closeButton : true,
		animate : true,
		buttons : vm.viewDialogButton,
		className : 'info-class',
		message : 'info'
	};

};