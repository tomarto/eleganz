/**
 * @ngdoc Login Controller
 * @name LoginController
 * @desc # Define the ViewModel that will be used along the login view
 */
(function() {
	'use strict';

	angular
		.module('login')
		.controller('LoginController', LoginController);

	LoginController.$inject = ['$stateParams', 'formValidation'];

	function LoginController($stateParams, formValidation) {
		var vm = this;

		vm.hasLoginError = angular.isDefined($stateParams.error);
		vm.hasLoggedOut = angular.isDefined($stateParams.logout);
		vm.alphanumericRegex = /^[A-z0-9_.-]*$/;
		vm.username = {
			minlength: 5,
			maxlength: 50
		};
		vm.password = {
			minlength: 6,
			maxlength: 50
		};

		vm.showFieldMessages = formValidation.showFieldMessages;
		vm.fieldHasWarning = formValidation.fieldHasWarning;
		vm.fieldHasError = formValidation.fieldHasError;
	}
})();
