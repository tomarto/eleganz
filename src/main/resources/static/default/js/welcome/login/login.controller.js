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

	LoginController.$inject = ['$stateParams'];

	function LoginController($stateParams) {
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

		vm.showFieldMessages = showFieldMessages;
		vm.fieldHasWarning = fieldHasWarning;
		vm.fieldHasError = fieldHasError;

		function showFieldMessages(formField) {
			return formField.$dirty && formField.$invalid;
		}

		function fieldHasWarning(formField) {
			return formField.$error.minlength || formField.$error.maxlength;
		}

		function fieldHasError(formField) {
			return (formField.$dirty && formField.$error.required) || formField.$error.pattern;
		}
	}
})();
