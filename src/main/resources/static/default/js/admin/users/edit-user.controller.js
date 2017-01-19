/**
 * @ngdoc Edit Controller
 * @name EditUserController
 * @desc # Define the ViewModel that will be used along the edit user modal view
 */
(function() {
	'use strict';

	angular
		.module('users')
		.controller('EditUserController', EditUserController);

	EditUserController.$inject = ['$uibModalInstance', 'user', 'formValidation'];

	function EditUserController($uibModalInstance, user, formValidation) {
		var vm = this;

		vm.updatedUser = {};
		vm.user = user;
		vm.alphanumericRegex = /^[A-z0-9_.-]*$/;
		vm.username = {
			minlength: 5,
			maxlength: 50
		};

		vm.showFieldMessages = showFieldMessages;
		vm.fieldHasWarning = formValidation.fieldHasWarning;
		vm.fieldHasError = fieldHasError;
		vm.ok = ok;
		vm.cancel = cancel;

		function showFieldMessages(formField) {
			return formField.$invalid;
		}

		function fieldHasError(formField) {
			return formField.$error.pattern;
		}

		function ok() {
			$uibModalInstance.close(vm.updatedUser);
		}

		function cancel() {
			$uibModalInstance.dismiss('cancel');
		}
	}
})();
