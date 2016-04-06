/**
 * 
 */
'use strict';
var urlBase = 'http://localhost:8080/project';

angular.module('app.login').service('loginService', loginService);
loginService.$inject = [ '$http', '$q' ];

function loginService($http, $q) {
	var service = {
		login : login,
		search : search
	};

	return service;

	function login(user) {
		var deferred = $q.defer();
		$http.post(urlBase + '/logins/login', user).success(function(dataArr) {
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