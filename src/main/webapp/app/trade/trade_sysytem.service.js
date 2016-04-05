'use strict';

var urlBase = 'http://localhost:8080/project';

angular.module('app.tradeSystem').service('TradeSystemService', TradeSystemService);
TradeSystemService.$inject = [ '$http', '$q' ];

function TradeSystemService($http, $q) {
	var service = {
		create : create,
		update : update,
		remove : remove,
		search : search
	};

	return service;

	function create(tradeSystem) {
		var deferred = $q.defer();
		$http.post(urlBase + '/tradeSystem/create', tradeSystem).success(
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

	function update(tradeSystem) {
		console.log(tradeSystem);
		var deferred = $q.defer();
		$http.put(urlBase + '/tradeSystem/update', tradeSystem).success(
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

	function remove(id) {
		var deferred = $q.defer();
		$http['delete'](urlBase + '/tradeSystem/delete/' + id).success(
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

	function search(tradeSystem) {
		var deferred = $q.defer();
		$http.post(urlBase + '/tradeSystem/search/', tradeSystem).success(
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