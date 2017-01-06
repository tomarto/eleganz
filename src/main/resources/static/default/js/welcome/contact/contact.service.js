/**
 * @ngdoc Contact Factory
 * @name contactService
 * @desc # Define the request made for contact module.
 */
(function() {
	'use strict';

	angular
		.module('contact')
		.factory('contactService', contactService);

	contactService.$inject = ['$http', '$q', 'pendingRequest'];

	function contactService($http, $q, pendingRequest) {
		var factory = {
			sendEmail: sendEmail
		};

		return factory;

		function sendEmail(emailRequest) {
			var request = pendingRequest.register();

			return $http.post('api/email', emailRequest)
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
