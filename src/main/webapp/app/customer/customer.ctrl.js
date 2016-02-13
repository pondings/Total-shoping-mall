/**
 * 
 */
'use strict';
angular.module('app.customer').controller('CustomerCtrl',CustomerCtrl);
CustomerCtrl.$inject = ['$scope','SweetAlert','Flash','$ngBootbox'];

function CustomerCtrl($scope,SweetAlert,Flash,$ngBootbox){
	var vm = this
	/** tab**/
	vm.tabs = [{
		tabIdx : 0,
		selected : true
	},{
		tabIdx : 0,
		selected : false
	}];
	
//	/** calendar **/
//	vm.calendar = {
//			opened : false
//	}
//	vm.calDate = function($event){
//		vm.calendar.opened = true;
//	}
//	
//	/** pagination **/
//	vm.numPerPage = 5;
//	vm.numPerPage = [{number : 5},{
//		number : 10
//	},{
//		number : 15
//	},{
//		number : 20
//	},{
//		number : 25
//	},{
//		number : 30
//	}];
//	vm.selectedNumPerPage = vm.numPerPages[0];
//	
//	/** smart-table**/
//	$scope.desplayedCus = [].concat(vm.empList);
//	$scope.displayedPages = 5;
//	
//	/** Declare Function **/
//	vm.resetPage = resetPage;
//	vm.search = search;
//	vm.formControl = formControl;
//	vm.create = create;
//	vm.update = update;
//	vm.remove = remove;
//	vm.resetdefault = resetdefault;
//	vm.resetForm = resetForm;
//	
//	/** Function **/
//	function resetDefault(){
//		vm.customer = angular.copy(vm.substitute);
//	}
//	
	
	
}