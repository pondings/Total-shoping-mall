'use strict';
angular.module('app.customer').controller('CustomerCtrl', CustomerCtrl);
CustomerCtrl.$inject = [ '$scope', 'SweetAlert', 'Flash', '$ngBootbox', 'CustomerService' ];

function CustomerCtrl($scope, SweetAlert, Flash, $ngBootbox, CustomerService) {
	var vm = this;

	/** tab * */

	vm.tabs = [ {
		title : 'ค้นหาข้อมูลลูกค้า',
		tabIdx : 0,
		selected : true
	}, {
		title : 'เพิ่มแก้ไข ข้อมูลลูกค้า',
		tabIdx : 0,
		selected : false
	} ];

//	/** calendar * */
//
//	vm.calendar = {
//		opened : false
//	}
//	vm.calDate = function($event) {
//		vm.calendar.opened = true;
//	}

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

	$scope.displayedCustomer = [].concat(vm.cusList);
	$scope.displayedPages = 5;
	
	/** Declare Func **/
	vm.resetPage = resetPage;
	vm.resetDefault = resetDefault;
	vm.resetForm = resetForm;
	vm.submit = submit;
	vm.create = create;
	vm.search = search;
	vm.remove = remove;
	vm.edit = edit;
	
	
	function submit() {
		if (vm.cus.id != null) {
			CustomerService.update(vm.cus).then(
					function(data) {
						for (var i = 0; i < vm.cusList.length; i++) {
							if (vm.cusList[i].id == data.id) {
								$scope.displayedCustomer[i] = data;
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
		CustomerService.create(vm.cus).then(function(data) {
			vm.cusList.push(data);
			Flash.create('success', 'Created', 'custom-class');
			vm.resetForm();
		}, function(errRs) {
			Flash.create('danger', errRs.errMessage, 'custom-class');
		})
		
	}
	
	function edit(cus) {
		vm.cus = angular.copy(cus);
		vm.cusbak = angular.copy(cus);
		vm.tabs[1].selected = true;
	}
	
	function search() {
		CustomerService.search(vm.cus).then(
				function(data) {
					vm.cusList = data;
					Flash
							.create('success', "Found " + data.length
									+ " reccord", 'custom-class');
				}, function(errRs) {
					Flash.create('danger', errRs.errMessage, 'custom-class');
				})
	}
	
	function remove(id) {
		CustomerService.remove(id).then(function(data) {
			Flash.create('success', 'Deleted', 'custom-class');
			for (var i = 0; i < vm.cusList.length; i++) {
				if (vm.cusList[i].id == id) {
					vm.cusList.splice(i, 1);
					break;
				}
			}
		}, function(errRs) {
			Flash.create('danger', errRs.errMessage, 'custom-class');
		})
	}
	
	function resetDefault() {
		vm.cus = angular.copy(vm.cusbak);
	}
	
	function resetPage() {
		vm.cusList = [];
		vm.resetForm();
	}

	function resetForm() {
		vm.cus = {
			id : null,
			custCode : null,
			custName : null,
		};
		vm.cusForm.$setPristine();
	}
	
};