/**
 * @ngdoc Edit User Controller
 * @name EditUserController
 * @desc # Define the ViewModel that will be used along the edit user modal view
 */
(function() {
	'use strict';

	angular
		.module('users')
		.controller('EditUserController', EditUserController);

	EditUserController.$inject = [
		'$uibModalInstance', 'user', 'usersService', 'formValidation', 'toasterService'
	];

	function EditUserController($uibModalInstance, user, usersService, formValidation,
			toasterService) {
		var vm = this;

		vm.updatedUser = {};
		vm.user = user;
		vm.validation = {
			email: {
				minlength: 6,
				maxlength: 254,
				regex: /^[A-z_]+[A-z0-9._-]*[A-z0-9_]+@[A-z]+\.[A-z.]{2,5}$/
			}
		};

		vm.showFieldMessages = showFieldMessages;
		vm.fieldHasWarning = formValidation.fieldHasWarning;
		vm.fieldHasError = fieldHasError;
		vm.modelHasBeenEdited = modelHasBeenEdited;
		vm.ok = ok;
		vm.cancel = cancel;

		function showFieldMessages(formField) {
			return formField.$invalid;
		}

		function fieldHasError(formField) {
			return formField.$error.pattern;
		}

		function modelHasBeenEdited(model) {
			var hasBeenEdited = false;
			angular.forEach(model, function(value) {
				if(typeof value === 'object') {
					hasBeenEdited = modelHasBeenEdited(value);
				} else if(!hasBeenEdited) {
					hasBeenEdited = !!value
				}
			});

			return hasBeenEdited;
		}

		function buildUpdatedModel() {
			var updatedModel = angular.copy(user);
			// If needs to update more fields remove:
			delete updatedModel.userDetail;
			delete updatedModel.type;
			updatedModel.email = vm.updatedUser.email;

			return updatedModel;
		}

		function ok() {
			var updatedModel = buildUpdatedModel();
			usersService.updateUser(updatedModel)
				.then(function(response) {
					toasterService.success(response);
					$uibModalInstance.close(updatedModel);
				})
				.catch(function(error) {
					toasterService.error(error.errorMessage);
					$uibModalInstance.dismiss('cancel');
				});
		}

		function cancel() {
			$uibModalInstance.dismiss('cancel');
		}
	}
})();
