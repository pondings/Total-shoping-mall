'use strict';

var urlBase = 'http://localhost:8080/project';

angular.module('app.report').service('ReportService', ReportService);
ReportService.$inject = [ '$http', '$q' ];

function ReportService($http, $q) {
	var service = {
		orderSearch : orderSearch,
		getEmp : getEmp,
		getCust : getCust,
		getSubOrder : getSubOrder,
		report : report
	};

	return service;

	function report(startDate, endDate) {
		var deferred = $q.defer();
		var dateInput = {
			startDate : startDate,
			endDate : endDate
		};
		$http.post(urlBase + '/subOrder/report', dateInput).success(
				function(dataArr) {
					deferred.resolve(dataArr);
				}).error(function(errMs, errCode) {
			var err = {
				errMessage : errMs,
				errCode : errCode
			}
			deferred.reject(err);
		});
		return deferred.promise;
	}

	function getSubOrder(order) {
		var deferred = $q.defer();
		$http.post(urlBase + '/subOrder/searchSubOrderByOrder', order).success(
				function(dataArr) {
					deferred.resolve(dataArr);
				}).error(function(errMs, errCode) {
			var err = {
				errMessage : errMs,
				errCode : errCode
			}
			deferred.reject(err);
		});
		return deferred.promise;
	}

	function getCust() {
		var deferred = $q.defer();
		var cust = {
			custCode : null
		};
		$http.post(urlBase + '/cus/search', cust).success(function(dataArr) {
			deferred.resolve(dataArr);
		}).error(function(errMs, errCode) {
			var err = {
				errMessage : errMs,
				errCode : errCode
			}
			deferred.reject(err);
		});
		return deferred.promise;
	}

	function getEmp() {
		var deferred = $q.defer();
		var emp = {
			empCode : null
		};
		$http.post(urlBase + '/emp/search', emp).success(function(dataArr) {
			deferred.resolve(dataArr);
		}).error(function(errMs, errCode) {
			var err = {
				errMessage : errMs,
				errCode : errCode
			}
			deferred.reject(err);
		});
		return deferred.promise;

	}

	function orderSearch(order) {
		var deferred = $q.defer();
		var obj = {
			orderCode : order.orderCode,
			empCode : order.empInfo.empCode,
			custCode : order.customer.custCode,
			startDate : order.startDate,
			endDate : order.endDate
		};
		$http.post(urlBase + '/order/orderSearch/', obj).success(
				function(dataArr) {
					deferred.resolve(dataArr);
				}).error(function(errMs, errCode) {
			var err = {
				errMessage : errMs,
				errCode : errCode
			}
			deferred.reject(err);
		});
		return deferred.promise;
	}

}