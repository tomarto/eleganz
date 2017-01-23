/**
 * @ngdoc Authentication Factory
 * @name authenticationService
 * @desc # Define the request made for authentication.
 */
(function() {
	'use strict';

	angular
		.module('core')
		.factory('authenticationService', authenticationService);

	authenticationService.$inject = ['$http', '$q', '$cacheFactory', 'pendingRequest'];

	function authenticationService($http, $q, $cacheFactory, pendingRequest) {
		var authenticationCache = $cacheFactory('authentication'),
			factory = {
				getUser: getUser
			};

		return factory;

		function getUser() {
			var cachedUser = authenticationCache.get('user');

			if(cachedUser) {
				var deferred = $q.defer();
				deferred.resolve(cachedUser);
				return deferred.promise;
			}

			var request = pendingRequest.register();

			return $http.get('api/authentication')
				.then(getUserComplete)
				.catch(getUserFailed);

			function getUserComplete(response) {
				authenticationCache.put('user', response.data.result);
				pendingRequest.complete(request);
				return response.data.result;
			}

			function getUserFailed(error) {
				pendingRequest.complete(request);
				return $q.reject(error.data);
			}
		}
	}
})();
