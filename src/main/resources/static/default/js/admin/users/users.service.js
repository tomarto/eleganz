/**
 * @ngdoc User Factory
 * @name userService
 * @desc # Define the request made for user module.
 */
(function() {
	'use strict';

	angular
		.module('users')
		.factory('usersService', usersService);

	usersService.$inject = ['$http', '$q', '$cacheFactory', 'pendingRequest'];

	function usersService($http, $q, $cacheFactory, pendingRequest) {
		var userCache = $cacheFactory('user'),
			factory = {
				getUsers: getUsers
			};

		return factory;

		function getUsers() {
			var cachedUsers = userCache.get('users');

			if(cachedUsers) {
				var deferred = $q.defer();
				deferred.resolve(cachedUsers);
				return deferred.promise;
			}

			var request = pendingRequest.register();

			return $http.get('api/user')
				.then(getUsersComplete)
				.catch(getUsersFailed);

			function getUsersComplete(response) {
				userCache.put('users', response.data.result);
				pendingRequest.complete(request);
				return response.data.result;
			}

			function getUsersFailed(error) {
				pendingRequest.complete(request);
				return $q.reject(error.data);
			}
		}
	}
})();
