'use strict';

var urlBase = 'http://localhost:8080/project';

angular.module('app.prod').service('ProdService', ProdService);
ProdService.$inject = [ '$http', '$q' ];

function ProdService($http, $q) {
	var service = {
		create : create,
		update : update,
		remove : remove,
		search : search
	};

	return service;

	function create(prod) {
		var deferred = $q.defer();
		$http.post(urlBase + '/prod/create', prod).success(function(dataArr) {
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

	function update(prod) {
		var deferred = $q.defer();
		$http.put(urlBase + '/prod/update', prod).success(function(dataArr) {
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
		$http['delete'](urlBase + '/prod/delete/' + id).success(
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

	function search(prod) {
		var deferred = $q.defer();
		$http.post(urlBase + '/prod/search/', prod).success(function(dataArr) {
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