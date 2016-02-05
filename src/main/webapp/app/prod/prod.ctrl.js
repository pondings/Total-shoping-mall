'use strict';
angular.module('app.emp').controller('ProdCtrl', ProdCtrl);
ProdCtrl.$inject = [ '$scope', 'SweetAlert', 'Flash', '$ngBootbox',
		'ProdService' ];

function ProdCtrl($scope, SweetAlert, Flash, $ngBootbox, ProdService) {
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

	$scope.displayedProd = [].concat(vm.prodList);
	$scope.displayedPages = 5;

	/** Declare Func * */

	vm.resetPage = resetPage;
	vm.search = search;
	vm.formControl = formControl;
	vm.create = create;
	vm.update = update;
	vm.remove = remove;
	vm.resetDefault = resetDefault;
	vm.resetForm = resetForm;

	/** Function * */

	function resetDefault() {
		vm.prod = angular.copy(vm.substitute);
		vm.prod.prodDateAttended = new Date(vm.substitute.prodDateAttended);
	}

	function remove(id) {
		ProdService.remove(id).then(function(data) {
			Flash.create('success', 'Deleted', 'custom-class');
			for (var i = 0; i < vm.prodList.length; i++) {
				if (vm.prodList[i].id == id) {
					vm.prodList.splice(i, 1);
					break;
				}
			}
		}, function(errRs) {
			Flash.create('danger', errRs.errMessage, 'custom-class');
		})
	}

	function formControl() {
		if (vm.prod.id != null) {
			ProdService.update(vm.prod).then(
					function(data) {
						for (var i = 0; i < vm.prodList.length; i++) {
							if (vm.prodList[i].id == data.id) {
								$scope.displayedProd[i] = data;
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
		ProdService.create(vm.prod).then(function(data) {
			vm.prodList.push(data);
			Flash.create('success', 'Created', 'custom-class');
			vm.resetForm();
		}, function(errRs) {
			Flash.create('danger', errRs.errMessage, 'custom-class');
		})
	}

	function update(prod) {
		vm.prod = angular.copy(prod);
		vm.substitute = angular.copy(prod);
		vm.prod.prodDateAttended = new Date(prod.prodDateAttended);
		vm.tabs[1].selected = true;
	}

	function search() {
		ProdService.search(vm.prod).then(
				function(data) {
					vm.prodList = data;
					Flash
							.create('success', "Found " + data.length
									+ " reccord", 'custom-class');
				}, function(errRs) {
					Flash.create('danger', errRs.errMessage, 'custom-class');
				})
	}

	function resetPage() {
		vm.prodList = [];
		vm.prod = {
			id : null,
			prodCode : null,
			prodName : null,
			prodDateAttended : undefined
		};
		vm.prodForm.$setPristine();
	}

	function resetForm() {
		vm.prod = {
			id : null,
			prodCode : null,
			prodName : null,
			prodDateAttended : undefined
		};
		vm.prodForm.$setPristine();
	}
};