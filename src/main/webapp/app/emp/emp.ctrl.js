'use strict';
angular.module('app.emp').controller('EmpCtrl', EmpCtrl);
EmpCtrl.$inject = [ '$scope', 'SweetAlert', 'Flash', '$ngBootbox', 'EmpService' ];

function EmpCtrl($scope, SweetAlert, Flash, $ngBootbox, EmpService) {
	var vm = this;

	/** tab * */

	vm.tabs = [ {
		title : 'ค้นหาข้อมูลพนักงาน',
		tabIdx : 0,
		selected : true
	}, {
		title : 'เพิ่มแก้ไข ข้อมูลพนักงาน',
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

	$scope.displayedEmp = [].concat(vm.empList);
	$scope.displayedPages = 5;

	/** Declare Func * */

	vm.resetPage = resetPage;
	vm.search = search;
	vm.formControl = formControl;
	vm.create = create;
	vm.update = update;
	vm.remove = remove;
	vm.resetDefault = resetDefault ;
	vm.resetForm = resetForm;

	/** Function * */

	function resetDefault() {
		vm.emp = angular.copy(vm.substitute) ;
	}
	
	function remove(id) {
		EmpService.remove(id).then(function(data) {
			Flash.create('success', 'Deleted', 'custom-class');
			for (var i = 0; i < vm.empList.length; i++) {
				if (vm.empList[i].id == id) {
					vm.empList.splice(i, 1);
					break;
				}
			}
		}, function(errRs) {
			Flash.create('danger', errRs.errMessage, 'custom-class');
		})
	}

	function formControl() {
		if (vm.emp.id != null) {
			EmpService.update(vm.emp).then(
					function(data) {
						for (var i = 0; i < vm.empList.length; i++) {
							if (vm.empList[i].id == data.id) {
								$scope.displayedEmp[i] = data;
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
		EmpService.create(vm.emp).then(function(data) {
			vm.empList.push(data);
			Flash.create('success', 'Created', 'custom-class');
			vm.resetForm();
		}, function(errRs) {
			Flash.create('danger', errRs.errMessage, 'custom-class');
		})
	}

	function update(emp) {
		vm.emp = angular.copy(emp);
		vm.substitute = angular.copy(emp);
		vm.tabs[1].selected = true;
	}

	function search() {
		EmpService.search(vm.emp).then(
				function(data) {
					vm.empList = data;
					Flash
							.create('success', "Found " + data.length
									+ " reccord", 'custom-class');
				}, function(errRs) {
					Flash.create('danger', errRs.errMessage, 'custom-class');
				})
	}

	function resetPage() {
		vm.empList = [];
		vm.emp = {
			id : null,
			empCode : null,
			empName : null
		};
		vm.empForm.$setPristine();
	}

	function resetForm() {
		vm.emp = {
			id : null,
			empCode : null,
			empName : null
		};
		vm.empForm.$setPristine();
	}
};