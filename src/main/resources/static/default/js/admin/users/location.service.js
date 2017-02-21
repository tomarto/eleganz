/**
 * @ngdoc Location Factory
 * @name locationService
 * @desc # Define the request made for user module.
 */
(function() {
	'use strict';

	angular
		.module('users')
		.factory('locationService', locationService);

	locationService.$inject = ['$http', '$q', '$cacheFactory', 'pendingRequest'];

	function locationService($http, $q, $cacheFactory, pendingRequest) {
		var locationCache = $cacheFactory('location'),
			factory = {
				getLocations: getLocations
			};

		return factory;

		function getLocations() {
			var cachedLocations = locationCache.get('locations');

			if(cachedLocations) {
				var deferred = $q.defer();
				deferred.resolve(cachedLocations);
				return deferred.promise;
			}

			var request = pendingRequest.register();

			return $http.get('api/location')
				.then(getLocationsComplete)
				.catch(getLocationsFailed);

			function getLocationsComplete(response) {
				locationCache.put('locations', response.data.result);
				pendingRequest.complete(request);
				return response.data.result;
			}

			function getLocationsFailed(error) {
				pendingRequest.complete(request);
				return $q.reject(error.data);
			}
		}
	}
})();
