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

	UsersController.$inject = ['$uibModal', 'currentUser', 'users'];

	function UsersController($uibModal, currentUser, users) {
		var vm = this;

		vm.currentUser = currentUser;
		vm.users = users;

		vm.editUser = editUser;
		vm.deleteUser = deleteUser;

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

		function deleteUser(user) {
			var modalInsance = $uibModal.open({
				templateUrl: '/admin/partials/delete-user-modal.html',
				controller: 'DeleteUserController',
				controllerAs: 'duc',
				resolve: {
					user: function() {
						return user;
					}
				}
			});

			modalInsance.result.then(function(deletedUser) {
				var removedIndex = _.findIndex(vm.users, {id: deletedUser.id});
				vm.users.splice(removedIndex, 1);
			});
		}
	}
})();
