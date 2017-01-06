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

	contactService.$inject = ['$http', '$q'];

	function contactService($http, $q) {
		var factory = {
			sendEmail: sendEmail
		};

		return factory;

		function sendEmail(emailRequest) {
			return $http.post('api/email', emailRequest)
				.then(sendEmailComplete)
				.catch(sendEmailFailed);

			function sendEmailComplete(response) {
				return response.data.result;
			}

			function sendEmailFailed(error) {
				return $q.reject(error.data);
			}
		}
	}
})();
