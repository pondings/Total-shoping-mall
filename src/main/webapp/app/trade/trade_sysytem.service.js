'use strict';

var urlBase = 'http://localhost:8080/project';

angular.module('app.tradeSystem').service('TradeSystemService',
		TradeSystemService);
TradeSystemService.$inject = [ '$http', '$q' ];

function TradeSystemService($http, $q) {
	var service = {
		create : create,
		getCust : getCust,
		getProd : getProd
	};

	return service;

	function getProd(prodCode) {
		var deferred = $q.defer();
		var prod = {
			prodCode : prodCode
		}
		$http.post(urlBase + '/prod/searchCode', prod).success(function(dataArr) {
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

	function create(order) {
		var deferred = $q.defer();
		$http.post(urlBase + '/order/create', order).success(function(dataArr) {
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