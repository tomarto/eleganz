/**
 * @ngdoc Invite Factory
 * @name inviteService
 * @desc # Define the request made for home module.
 */
(function() {
	'use strict';

	angular
		.module('home')
		.factory('inviteService', inviteService);

	inviteService.$inject = ['$http', '$q', 'pendingRequest'];

	function inviteService($http, $q, pendingRequest) {
		var factory = {
			sendEmail: sendEmail
		};

		return factory;

		function sendEmail(inviteRequest) {
			var request = pendingRequest.register();

			return $http.post('api/email/invite', inviteRequest)
				.then(sendEmailComplete)
				.catch(sendEmailFailed);

			function sendEmailComplete(response) {
				pendingRequest.complete(request);
				return response.data.result;
			}

			function sendEmailFailed(error) {
				pendingRequest.complete(request);
				return $q.reject(error.data);
			}
		}
	}
})();
