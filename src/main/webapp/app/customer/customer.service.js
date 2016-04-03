'use strict';

var urlBase = 'http://localhost:8080/project';

angular.module('app.user').service('UserService', UserService);
UserService.$inject = [ '$http', '$q' ];

function UserService($http, $q) {
	var service = {
		create : create,
		update : update,
		remove : remove,
		search : search,
		getRole : getRole
	};

	return service;

	function getRole() {
		var deferred = $q.defer();
		$http.get(urlBase + '/user/getRole').success(function(dataArr) {
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

	function create(user) {
		var deferred = $q.defer();
		$http.post(urlBase + '/user/create', user).success(function(dataArr) {
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

	function update(user) {
		console.log(user);
		var deferred = $q.defer();
		$http.put(urlBase + '/user/update', user).success(function(dataArr) {
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
		$http['delete'](urlBase + '/user/delete/' + id).success(
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

	function search(user) {
		var deferred = $q.defer();
		$http.post(urlBase + '/user/search/', user).success(function(dataArr) {
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