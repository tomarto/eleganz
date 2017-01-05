/**
 * @ngdoc Contact Controller
 * @name ContactController
 * @desc # Define the ViewModel that will be used along the contact view
 */
(function() {
	'use strict';

	angular
		.module('login')
		.controller('ContactController', ContactController);

	ContactController.$inject = ['formValidation', 'contactService'];

	function ContactController(formValidation, contactService) {
		var vm = this;

		vm.emailRequest = {};
		vm.alphanumericRegex = /^[A-z0-9_. -]*$/;
		vm.emailRegex = /^[A-z_]+[A-z0-9._-]*[A-z0-9_]+@[A-z]+\.[A-z.]{2,5}$/;
		vm.phoneRegex = /^[0-9. -]*$/;
		vm.name = {
			minlength: 3,
			maxlength: 60
		};
		vm.email = {
			minlength: 9,
			maxlength: 120
		};
		vm.phone = {
			minlength: 7,
			maxlength: 18
		};
		vm.subject = {
			minlength: 3,
			maxlength: 100
		};
		vm.message = {
			minlength: 3,
			maxlength: 5000
		};

		vm.showFieldMessages = formValidation.showFieldMessages;
		vm.fieldHasWarning = formValidation.fieldHasWarning;
		vm.fieldHasError = formValidation.fieldHasError;

		vm.sendMessage = sendMessage;

		function sendMessage(isFormValid) {
			if(isFormValid) {
				console.log(vm.emailRequest);
				contactService.sendEmail(vm.emailRequest)
					.then(function(data) {
						console.log(data);
					});
			}
		}
	}
})();
