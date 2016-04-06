'use strict';
angular.module('app.tradeSystem')
		.controller('TradeSystemCtrl', TradeSystemCtrl);
TradeSystemCtrl.$inject = [ '$scope', 'SweetAlert', 'Flash', '$ngBootbox',
		'TradeSystemService' ];

function TradeSystemCtrl($scope, SweetAlert, Flash, $ngBootbox,
		TradeSystemService) {
	var vm = this;

	/** tab * */
	vm.tabs = [ {
		title : 'Trade System',
		tabIdx : 0,
		selected : true
	} ];

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
	vm.selectedNumPerPagDialog = vm.numPerPages[0];

	/** smart-table * */

	$scope.displayedOrder = [].concat(vm.orderList);

	/** Declare Func * */

	vm.getCust = getCust;
	vm.getProd = getProd;
	vm.calNet = calNet;
	vm.resetPage = resetPage;
	vm.remove = remove;
	vm.create = create;
	vm.resetSubProduct = resetSubProduct;

	/** Function * */

	function remove(id) {
		for (var i = 0; i < vm.orderList.length; i++) {
			if (vm.orderList[i].id == id) {
				vm.calculate.net = vm.calculate.net - vm.orderList[i].total;
				vm.orderList.splice(i, 1);
			}
		}
	}

	function calNet(total) {
		vm.calculate.net = vm.calculate.net + total;
	}

	function getProd() {
		TradeSystemService
				.getProd(vm.prodCode)
				.then(
						function(data) {
							if (data.prodCode != null) {
								for (var i = 0; i < vm.orderList.length; i++) {
									if (vm.orderList[i].id == data.id) {
										vm.orderList[i].quantity = vm.orderList[i].quantity
												+ vm.calculate.count;
										vm.orderList[i].total = vm.orderList[i].total
												+ (data.prodPrice * vm.calculate.count);
										vm.calculate.net = vm.calculate.net
												+ data.prodPrice
												* vm.calculate.count;
										vm.calculate.count = 1;
										vm.push = false;
										vm.prodCode = null;
										break;
									} else {
										vm.push = true;
									}
								}
								if (vm.push == true) {
									vm.subProduct.id = data.id;
									vm.subProduct.prodCode = data.prodCode;
									vm.subProduct.prodName = data.prodName;
									vm.product.push(vm.subProduct);
									data.quantity = vm.calculate.count;
									data.total = data.prodPrice
											* vm.calculate.count;
									vm.orderList.push(data);
									vm.calculate.count = 1;
									vm.calNet(data.total);
									vm.prodCode = null;
									vm.resetSubProduct();
								}
								if (vm.orderList < 1) {
									vm.subProduct.id = data.id;
									vm.subProduct.prodCode = data.prodCode;
									vm.subProduct.prodName = data.prodName;
									vm.product.push(vm.subProduct);
									data.quantity = vm.calculate.count;
									data.total = data.prodPrice
											* vm.calculate.count;
									vm.orderList.push(data);
									vm.calculate.count = 1;
									vm.calNet(data.total);
									vm.prodCode = null;
									vm.resetSubProduct();
								}
							} else {
								Flash.create('danger',
										"กรอกรหัสสินค้าไม่ถูกต้อง",
										'custom-class');
							}
						},
						function(errRs) {
							Flash.create('danger', errRs.errMessage,
									'custom-class');
						})
	}

	function getCust() {
		TradeSystemService.getCust().then(function(data) {
			$scope.custList = data;
		}, function(errRs) {
			Flash.create('danger', errRs.errMessage, 'custom-class');
		})
	}

	function create() {
		for (var i = 0; i < vm.orderList.length; i++) {
			vm.sub.product = vm.product[i];
			vm.sub.subTotal = vm.orderList[i].total;
			vm.sub.subQuantity = vm.orderList[i].quantity;
			vm.subOrder.push(vm.sub);
			vm.resetSubProduct();
		}
		if (vm.order.customer.custName == null) {
			vm.order.customer = ' ';
		}
		vm.order.orderNet = vm.calculate.net;
		vm.order.status = true;
		vm.order.listOfSubOrder = vm.subOrder;
		console.log(vm.order, vm.product);
		TradeSystemService.create(vm.order).then(function(data) {
			Flash.create('success', 'Created', 'custom-class');
			vm.resetPage();
		}, function(errRs) {
			Flash.create('danger', errRs.errMessage, 'custom-class');
		})
	}

	function resetSubProduct() {
		vm.subProduct = {
			id : null,
			prodCode : null,
			prodName : null
		};
		vm.sub = {
			id : null,
			product : null,
			subTotal : null,
		};
	}

	function resetPage() {
		vm.sub = {
			id : null,
			product : null,
			subTotal : null,
		};
		vm.subProduct = {
			id : null,
			prodCode : null,
			prodName : null
		}
		vm.push = false;
		vm.product = [];
		vm.orderList = [];
		vm.subOrder = [];
		vm.calculate = {
			count : 1,
			total : null,
			net : 0
		};
		vm.order = {
			id : null,
			orderNet : null,
			orderRemark : null,
			status : true,
			orderCode : null,
			orderDate : undefined,
			empInfo : null,
			customer : {
				custName : null,
				custPhone : null,
				custTitle : null,
				custDesc : null
			},
			listOfSubOrder : null
		};
		$scope.getCust = false;
	}

	$scope.setCustClickedRow = function(cust) {
		vm.order.customer = cust;
		$scope.getCust = true;
		console.log(cust);
		$ngBootbox.hideAll();
	}

	/* Modal */

	vm.viewDialogButton = {
		main : {
			label : "Close",
			className : "btn-primary",
			callback : function() {
			}
		}
	};

	vm.viewCustModal = {
		scope : $scope,
		title : 'Customer List',
		onEscape : function() {
		},
		show : true,
		backdrop : true,
		closeButton : true,
		animate : true,
		buttons : vm.viewDialogButton,
		size : 'large',
		className : 'info-class',
		message : 'info'
	};

};