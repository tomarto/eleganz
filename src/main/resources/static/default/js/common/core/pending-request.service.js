/**
 * @ngdoc Pending Request Factory
 * @name pendingRequest
 * @desc # Define the pendingRequest service to know when to displays the loading overlay.
 */
(function() {
	'use strict';

	angular
		.module('core')
		.factory('pendingRequest', pendingRequest);

	pendingRequest.$inject = ['$rootScope', '$q', 'notifier'];

	function pendingRequest($rootScope, $q, notifier) {
		var pendingRequests = {},
			routeChangeListener = null,
			factory = {
				cancelAll: cancelAll,
				complete: complete,
				handlePendingRequests: handlePendingRequests,
				register: register,
				requestsPending: requestsPending
			};

		init();

		return factory;

		function init() {
			// Cancel any pending xhr when the root scope shuts down
			$rootScope.$on('$destroy', function() {
				factory.cancelAll();
			});
		}

		function cancelAll() {
			angular.forEach(pendingRequests, function(request) {
				// This cancels the Ajax request by calling xhr.abort() method in $httpBackend
				request.timeoutDeferred.resolve();
				delete pendingRequests[request.id];
			});
			handlePendingRequests();
		}

		function complete(pendingRequest) {
			delete pendingRequests[pendingRequest.id];
			handlePendingRequests();
		}

		function handlePendingRequests() {
			if (requestsPending()) {
				notifier.notify('loading', true);
				if (!routeChangeListener) {
					routeChangeListener = $rootScope.$on('$stateChangeStart', function() {
						notifier.notify('loading', false);
						cancelAll();
					});
				}
			} else {
				notifier.notify('loading', false);
				if (routeChangeListener) {
					// deregister route change listener
					routeChangeListener();
					routeChangeListener = null;
				}
			}
		}

		function register(message) {
			var deferred = $q.defer(),
				pendingRequest = {
					id: Math.random().toString(),
					timeoutPromise: deferred.promise,
					timeoutDeferred: deferred
				};

			pendingRequests[pendingRequest.id] = pendingRequest;
			handlePendingRequests();
			return pendingRequest;
		}

		function requestsPending(message) {
			return !angular.equals({}, pendingRequests);
		}
	}
})();
