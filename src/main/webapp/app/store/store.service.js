'use strict';

var urlBase = 'http://localhost:8080/coop';

angular.module('app.store').service('StoreService', StoreService);
StoreService.$inject = [ '$http', '$q' ];

function StoreService($http, $q) {
	var service = {
		findAllProd : findAllProd,
		findAllCust : findAllCust,
		saveOrder : saveOrder,
		orderSearch : orderSearch,
		custSearch : custSearch,
		removeOrder : removeOrder
	};

	return service;

	function removeOrder(order) {
		var deferred = $q.defer();
		$http.post(urlBase + '/order/delete/', order).success(
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

	function custSearch(cust) {
		var deferred = $q.defer();
		$http.post(urlBase + '/customer/search/', cust).success(
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

	function orderSearch(order) {
		var deferred = $q.defer();
		$http.post(urlBase + '/order/search/', order).success(
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

	function saveOrder(cust, prod, order, shipping) {
		var deferred = $q.defer();
		order.orderShipping = shipping;
		order.product = prod;
		order.customer = cust;
		order.orderLot = 2;
		$http.post(urlBase + '/order/save', order).success(function(dataArr) {
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

	function findAllProd() {
		var deferred = $q.defer();
		$http.get(urlBase + '/product/findAll/').success(function(dataArr) {
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

	function findAllCust() {
		var deferred = $q.defer();
		$http.get(urlBase + '/customer/findAll/').success(function(dataArr) {
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