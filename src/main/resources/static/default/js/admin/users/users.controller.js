/**
 * @ngdoc Users Controller
 * @name UsersController
 * @desc # Define the ViewModel that will be used along the users view
 */
(function() {
	'use strict';

	angular
		.module('users')
		.controller('UsersController', UsersController);

	UsersController.$inject = ['$uibModal', 'users'];

	function UsersController($uibModal, users) {
		var vm = this;

		vm.users = users;

		vm.editUser = editUser;

		function editUser(user) {
			var modalInsance = $uibModal.open({
				templateUrl: '/admin/partials/edit-user-modal.html',
				controller: 'EditUserController',
				controllerAs: 'euc',
				resolve: {
					user: function() {
						return user;
					}
				}
			});

			modalInsance.result.then(function(updatedUser) {
				_.findWhere(vm.users, {id: updatedUser.id}).email = updatedUser.email;
			});
		}
	}
})();
