'use strict';
angular.module('app.store').controller('StoreCtrl', StoreCtrl);
StoreCtrl.$inject = [ '$scope', 'StoreService', 'SweetAlert', 'Flash',
		'$ngBootbox' ];

function StoreCtrl($scope, StoreService, SweetAlert, Flash, $ngBootbox) {
	var vm = this;

	vm.prodList = [];
	vm.custList = [];
	vm.shipping = [ {
		id : 0,
		type : 'กรุณาเลือก',
		value : null
	}, {
		id : 1,
		type : 'EMS',
		value : 'EMS'
	}, {
		id : 2,
		type : 'Register',
		value : 'Register'
	}, {
		id : 3,
		type : 'Postal',
		value : 'Postal'
	} ];

	/* Tab */
	vm.tabs = [ {
		tabIdx : 0,
		selected : true
	}, {
		tabIdx : 0,
		selected : false
	}, {
		tabIdx : 0,
		selected : false
	} ];

	/* pagination */
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
	vm.prodNumPerPage = vm.numPerPages[0];

	/* Calendar */
	vm.seDate = {
		startDate : undefined,
		endDate : undefined
	};
	vm.startDate = {
		opened : false
	};
	vm.endDate = {
		opened : false
	};
	vm.start = function($event) {
		vm.startDate.opened = true;
	};
	vm.end = function($event) {
		vm.endDate.opened = true;
	}

	/* Dropdown initial */

	vm.selectedOrderShipping = vm.shipping[0];

	/* Event group */
	vm.initPage = initPage;
	vm.findAllProd = findAllProd;
	vm.findAllCust = findAllCust;
	vm.saveOrder = saveOrder;
	vm.selectProd = selectProd;
	vm.selectCust = selectCust;
	vm.invalidCust = invalidCust;
	vm.orderSearch = orderSearch;
	vm.custSearch = custSearch;
	vm.failOrder = failOrder;
	vm.removeOrder = removeOrder;

	/* Smart table safe src */
	$scope.displayedOrder = [].concat(vm.orderList);
	$scope.displayedCust = [].concat(vm.custList);

	/* Function */

	function removeOrder(order) {
		StoreService.removeOrder(order).then(function(data) {
			for (var i = 0; i < vm.orderList.length; i++) {
				if (vm.orderList[i].id == order.id) {
					vm.orderList.splice(i, 1);
					break;
				}
			}
			SweetAlert.swal({
				title : 'ลบเรียบร้อย',
				text : 'ทำการเก็บไว้ใน Fail order table เรียบร้อย',
				timer : 1500,
				showConfirmButton : false,
				type : 'success'
			});ป
		}, function(err) {
			Flash.create('success', "เกิดการขัดข้องทางระบบ", 'custom-class');
		})
	}

	function failOrder(order) {
		SweetAlert.swal({
			title : 'ยืนยันการลบ',
			text : 'ต้องการเก็บข้อมูล ของคุณ ' + '"' + order.customer.cusName
					+ '" ไว้ใน Fail order' + '?',
			type : 'warning',
			showCancelButton : true,
			confirmButtonColor : '#DD6B55',
			confirmButtonText : 'Continue',
			closeOnConfirm : false,
		}, function(isConfirm) {
			if (isConfirm) {
				vm.removeOrder(order);
			} else {
			}
		});
	}

	function custSearch() {
		StoreService.custSearch(vm.customers).then(
				function(data) {
					vm.custList = data;
					Flash.create('success', "พบ " + data.length + " แถว",
							'custom-class');
				},
				function(err) {
					Flash.create('success', "เกิดการขัดข้องทางระบบ",
							'custom-class');
				})
	}

	function orderSearch() {
		vm.orderSearchs.cusName = vm.customers.cusName
		vm.orderSearchs.orderShipping = vm.selectedOrderShipping.value;
		vm.orderSearchs.startDate = vm.seDate.startDate;
		vm.orderSearchs.endDate = vm.seDate.endDate;
		StoreService.orderSearch(vm.orderSearchs).then(
				function(data) {
					vm.orderList = data;
					Flash.create('success', "พบ " + data.length + " แถว",
							'custom-class');
				},
				function(err) {
					Flash.create('success', "เกิดการขัดข้องทางระบบ",
							'custom-class');
				})
	}

	function saveOrder() {
		if (!vm.prodSelected.prodCode) {
			Flash.create('danger', "กรุณาระบบสินค้าที่ถูกต้อง", 'custom-class');
		} else {
			StoreService.saveOrder(vm.customers, vm.products, vm.orders,
					vm.selectedOrderShipping.type).then(
					function(data) {
						Flash.create('success', "ทำการบันทึกเรียบร้อย",
								'custom-class');
						vm.initPage();
						$scope.vm.showProd = false;
					},
					function(err) {
						Flash.create('success', "เกิดการขัดข้องทางระบบ",
								'custom-class');
					})
		}

	}

	function findAllProd() {
		StoreService.findAllProd().then(function(data) {
			vm.prodList = data;
		}, function(err) {
			alert("ไม่สามารถ เรียกดูรายการสินค้าได้")
		})
	}

	function findAllCust() {
		StoreService.findAllCust().then(function(data) {
			vm.custList = data;
		}, function(err) {
			alert("ไม่สามารถเรียกดูรายการลูกค้าได้")
		})
	}

	function initPage() {
		vm.customers = {
			id : null,
			cusName : null,
			cusAddress : null,
			cusTel : null
		}
		vm.orders = {
			id : null,
			orderRemark : null,
			orderShipping : null,
			orderTracking : null,
			orderLot : null,
			product : null,
			customer : null,
			orderQuantity : null,
			orderLot : null
		}
		vm.products = {
			id : null,
			prodCode : null,
			prodDesc : null
		}
		vm.orderSearchs = {
			orderTracking : null,
			orderLot : null,
			orderShipping : null,
			cusName : null,
			prodCode : null,
			startDate : undefined,
			endDate : undefined
		}
		vm.prodList = [];
		vm.orderList = [];
		vm.custList = [];
		vm.seDate = {
			startDate : undefined,
			endDate : undefined
		};
		vm.selectedOrderShipping = vm.shipping[0];
		vm.prodSelected = null;
		vm.custSelected = null;
		vm.orderForm.$setPristine();
		$scope.vm.showProd = false;
	}

	function selectCust(cust) {
		vm.customers = cust;
	}

	function selectProd(prod) {
		vm.products = prod;
		$scope.vm.showProd = true;
	}

	function invalidCust() {
		if (vm.custSelected.length == 5) {
			vm.customers = null;
		}
	}

};