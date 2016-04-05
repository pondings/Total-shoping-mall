'use strict';

var urlBase = 'http://localhost:8080/project';

angular.module('app.customer').service('CustomerService', CustomerService);
CustomerService.$inject = [ '$http', '$q' ];

function CustomerService($http, $q) {
	var service = {
		create : create,
		update : update,
		remove : remove,
		search : search
	};

	return service;

	function create(cus) {
		var deferred = $q.defer();
		$http.post(urlBase + '/cus/create', cus).success(function(dataArr) {
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

	function update(cus) {
		var deferred = $q.defer();
		$http.put(urlBase + '/cus/update', cus).success(function(dataArr) {
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
		$http['delete'](urlBase + '/cus/delete/' + id).success(
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

	function search(cus) {
		var deferred = $q.defer();
		console.log(cus);
		$http.post(urlBase + '/cus/search/',cus).success(function(dataArr) {
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