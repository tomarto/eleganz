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

	contactService.$inject = ['$http'];

	function contactService($http) {
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
				console.log(error);
			}
		}
	}
})();
