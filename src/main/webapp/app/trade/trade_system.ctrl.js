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
	vm.create = create;
	vm.resetForm = resetForm;

	/** Function * */

	function calNet(total) {
		vm.calculate.net = vm.calculate.net + total ;
	}

	function getProd() {
		TradeSystemService.getProd(vm.prodCode).then(
				function(data) {
					console.log(data, vm.orderList.length)
					if (data.prodCode != null) {
						if (1 == 1) {
							data.quantity = vm.calculate.count;
							data.total = data.prodPrice * vm.calculate.count;
							vm.orderList.push(data);
							vm.calculate.count = 1;
							vm.calNet(data.total) ;
						}

					} else {
						Flash.create('danger', "กรอกรหัสสินค้าไม่ถูกต้อง",
								'custom-class');
					}
				}, function(errRs) {
					Flash.create('danger', errRs.errMessage, 'custom-class');
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
		TradeSystemService.create(vm.order).then(function(data) {
			Flash.create('success', 'Created', 'custom-class');
			vm.resetForm();
		}, function(errRs) {
			Flash.create('danger', errRs.errMessage, 'custom-class');
		})
	}

	function resetPage() {
		vm.push = false;
		vm.orderList = [];
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

	function resetForm() {
		vm.push = false;
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