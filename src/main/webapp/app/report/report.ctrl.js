'use strict';
angular.module('app.report').controller('ReportCtrl', ReportCtrl);
ReportCtrl.$inject = [ '$scope', 'SweetAlert', 'Flash', '$ngBootbox',
		'ReportService' ];

function ReportCtrl($scope, SweetAlert, Flash, $ngBootbox, ReportService) {
	var vm = this;

	/** Declare Values * */
	vm.selectMethod = [ {
		title : 'กรุณาเลือก',
		method : 0
	}, {
		title : 'รายการขาย',
		method : 1
	}, {
		title : 'แสดงกราฟ',
		method : 2
	} ];

	/* calendar */
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
	vm.strendDateList = {
		startDate : undefined,
		endDate : undefined
	}

	vm.selectedMethod = vm.selectMethod[0];

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
	vm.selectedNumPerPageDialog = vm.numPerPages[0] ;

	/** smart-table * */

	$scope.displayedEmp = [].concat($scope.empList);
	$scope.displayedOrder = [].concat(vm.orderList);
	$scope.displayedSubOrderList = [].concat(vm.subOrderList);
	$scope.displayedPages = 5;

	/** Declare Func * */

	vm.resetPage = resetPage;
	vm.switchMethod = switchMethod;
	vm.orderSearch = orderSearch;
	vm.getCust = getCust;
	vm.getEmp = getEmp;
	vm.orderViewInfo = orderViewInfo;
	vm.exportExel = exportExel;

	/** Function * */

	function orderViewInfo(order) {
		vm.orderView = angular.copy(order);
		ReportService.getSubOrder(order).then(function(data) {
			vm.subOrderList = data;
			console.log(vm.subOrderList);
		}, function(errRs) {
			Flash.create('danger', errRs.errMessage, 'custom-class');
		})
	}

	function getCust() {
		ReportService.getCust().then(function(data) {
			$scope.custList = data;
		}, function(errRs) {
			Flash.create('danger', errRs.errMessage, 'custom-class');
		})
	}

	function getEmp() {
		ReportService.getEmp().then(function(data) {
			$scope.empList = data;
			console.log($scope.empList);
		}, function(errRs) {
			Flash.create('danger', errRs.errMessage, 'custom-class');
		})
	}

	function orderSearch() {
		vm.net = 0 ;
		vm.getDate = {
			startDate : vm.order.startDate,
			endDate : vm.order.endDate
		};
		ReportService.orderSearch(vm.order).then(
				function(data) {
					console.log(data);
					vm.orderList = data;
					for (var i = 0; i < vm.orderList.length; i++) {
						vm.net = vm.net + vm.orderList[i].orderNet;
					}
					Flash
							.create('success', "Found " + data.length
									+ " reccord", 'custom-class');
				}, function(errRs) {
					Flash.create('danger', errRs.errMessage, 'custom-class');
				})
	}

	function switchMethod() {
		if (vm.selectedMethod.method == 0) {
			$scope.unSelect = true;
			$scope.byDate = false;
			$scope.chart = false;
		} else if (vm.selectedMethod.method == 1) {
			$scope.unSelect = false;
			$scope.byDate = true;
			$scope.chart = false;
		} else if (vm.selectedMethod.method == 2) {
			$scope.unSelect = false;
			$scope.byDate = false;
			$scope.chart = true;
		}
	}

	function resetPage() {
		vm.net = 0;
		vm.orderList = [];
		vm.subOrderList = [];
		vm.order = {
			orderCode : null,
			customer : {
				custCode : null,
				custName : null
			},
			empInfo : {
				empCode : null,
				empName : null
			},
			startDate : undefined,
			endDate : undefined
		};
	}

	$scope.setCustClickedRow = function(cust) {
		vm.order.customer = cust;
		console.log(cust);
		$ngBootbox.hideAll();
	}

	$scope.setClickedEmpRow = function(emp) {
		vm.order.empInfo = emp;
		$ngBootbox.hideAll();
	}

	/* Export */

	function exportExel() {
		var blob = new Blob(
				[ document.getElementById('exportable').innerHTML ],
				{
					type : "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8"
				});
		saveAs(blob, "order.xls");

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

	vm.viewOrderInfoModal = {
		scope : $scope,
		title : 'มุมมอง',
		onEscape : function() {
		},
		show : true,
		backdrop : true,
		closeButton : true,
		animate : true,
		size : 'large',
		buttons : vm.viewDialogButton,
		className : 'info-class',
		message : 'info'
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

	vm.viewEmpModal = {
		scope : $scope,
		title : 'Select Employee',
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