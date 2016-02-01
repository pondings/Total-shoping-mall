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

	/** Declare Func * */
	vm.resetPage = resetPage;
	vm.search = search;

	/** smart-table * */
	$scope.displayedEmp = [].concat(vm.empList);
	$scope.displayedPages = 5;

	/** Function * */

	function search() {
		EmpService.findAll().then(function(data) {
			vm.empList = data;
		}, function(errRs) {
			alert(errRs.errMessage);
		})
	}

	function resetPage() {
		vm.empList = [];
	}

};