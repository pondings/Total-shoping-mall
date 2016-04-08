'use strict';
angular.module('app.prodType').controller('ProdTypeCtrl', ProdTypeCtrl);
ProdTypeCtrl.$inject = [ '$scope', 'SweetAlert', 'Flash', '$ngBootbox',
		'ProdTypeService' ];

function ProdTypeCtrl($scope, SweetAlert, Flash, $ngBootbox, ProdTypeService) {
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

	$scope.displayedProdType = [].concat(vm.prodTypeList);
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
		vm.prodType = angular.copy(vm.substitute);
	}

	function remove(id) {
		SweetAlert.swal({
			title : 'ยืนยันการลบ',
			text : 'ต้องการลบข้อมูล  ' + '"' + prodType.typeCode + ' '
					+ prodType.type.Name + '"' + '?',
			type : 'warning',
			showCancelButton : true,
			confirmButtonColor : '#DD6B55',
			confirmButtonText : 'Continue',
			closeOnConfirm : false,
		}, function(isConfirm) {
			if (isConfirm) {
		ProdTypeService.remove(id).then(function(data) {
			Flash.create('success', 'Deleted', 'custom-class');
			for (var i = 0; i < vm.prodTypeList.length; i++) {
				if (vm.prodTypeList[i].id == id) {
					vm.prodTypeList.splice(i, 1);
					break;
				}
			}
			SweetAlert.swal({
				title : 'ลบเรียบร้อย',
				text : 'ทำการลบ  ' + '"' + prodType.typeCode + ' '
						+ prodType.type.Name + ' ' + ' เรียบร้อย',
				timer : 1500,
				showConfirmButton : false,
				type : 'success'
			});
		}, function(errRs) {
			Flash.create('danger', errRs.errMessage, 'custom-class');
		})
	}else {
			}
		});
	}

	function formControl() {
		if (vm.prodType.id != null) {
			ProdTypeService.update(vm.prodType).then(
					function(data) {
						for (var i = 0; i < vm.prodTypeList.length; i++) {
							if (vm.prodTypeList[i].id == data.id) {
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
		ProdTypeService.create(vm.prodType).then(function(data) {
			vm.prodTypeList.push(data);
			Flash.create('success', 'Created', 'custom-class');
			vm.resetForm();
		}, function(errRs) {
			Flash.create('danger', errRs.errMessage, 'custom-class');
		})
	}

	function update(prod) {
		vm.prodType = angular.copy(prod);
		vm.substitute = angular.copy(prod);
		vm.tabs[1].selected = true;
	}

	function search() {
		ProdTypeService.search(vm.prodType).then(
				function(data) {
					vm.prodTypeList = data;
					Flash
							.create('success', "Found " + data.length
									+ " reccord", 'custom-class');
				}, function(errRs) {
					Flash.create('danger', errRs.errMessage, 'custom-class');
				})
	}

	function resetPage() {
		vm.prodTypeList = [];
		vm.prodType = {
			id : null,
			typeCode : null,
			typeName : null,
			typeDesc : null
		};
		vm.prodTypeForm.$setPristine();
	}

	function resetForm() {
		vm.prodType = {
			id : null,
			typeCode : null,
			typeName : null,
			typeDesc : null
		};
		vm.prodTypeForm.$setPristine();
	}
};