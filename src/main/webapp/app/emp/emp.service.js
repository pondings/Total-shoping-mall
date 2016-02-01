'use strict';

var urlBase = 'http://localhost:8080/project';

angular.module('app.emp').service('EmpService', EmpService);
EmpService.$inject = [ '$http', '$q' ];

function EmpService($http, $q) {
	var service = {
		create : create,
		update : update,
		remove : remove,
		search : search
	};

	return service;

	function create(emp) {
		var deferred = $q.defer();
		$http.post(urlBase + '/emp/create', emp).success(function(dataArr) {
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

	function update(emp) {
		var deferred = $q.defer();
		$http.put(urlBase + '/emp/update', emp).success(function(dataArr) {
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
		$http['delete'](urlBase + '/emp/delete/' + id).success(
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

	function search(emp) {
		var deferred = $q.defer();
		$http.post(urlBase + '/emp/search/', emp).success(function(dataArr) {
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