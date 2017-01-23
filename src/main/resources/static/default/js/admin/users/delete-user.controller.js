/**
 * @ngdoc Delete User Controller
 * @name DeleteUserController
 * @desc # Define the ViewModel that will be used along the delete user modal view
 */
(function() {
	'use strict';

	angular
		.module('users')
		.controller('DeleteUserController', DeleteUserController);

	DeleteUserController.$inject = ['$uibModalInstance', 'user', 'usersService', 'toasterService'];

	function DeleteUserController($uibModalInstance, user, usersService, toasterService) {
		var vm = this;

		vm.user = user;

		vm.ok = ok;
		vm.cancel = cancel;

		function ok() {
			usersService.deleteUser(user.id)
				.then(function(response) {
					toasterService.success(response);
					$uibModalInstance.close(user);
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
