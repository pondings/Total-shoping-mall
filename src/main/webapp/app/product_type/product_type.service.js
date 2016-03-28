'use strict';

var urlBase = 'http://localhost:8080/project';

angular.module('app.prodType').service('ProdTypeService', ProdTypeService);
ProdTypeService.$inject = [ '$http', '$q' ];

function ProdTypeService($http, $q) {
	var service = {
		create : create,
		update : update,
		remove : remove,
		search : search
	};

	return service;

	function create(prodType) {
		var deferred = $q.defer();
		$http.post(urlBase + '/prodType/create', prodType).success(function(dataArr) {
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

	function update(prodType) {
		var deferred = $q.defer();
		$http.put(urlBase + '/prodType/update', prodType).success(function(dataArr) {
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
		$http['delete'](urlBase + '/prodType/delete/' + id).success(
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

	function search(prodType) {
		var deferred = $q.defer();
		$http.post(urlBase + '/prodType/search/', prodType).success(function(dataArr) {
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