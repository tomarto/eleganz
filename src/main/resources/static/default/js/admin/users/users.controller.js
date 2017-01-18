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

	UsersController.$inject = ['users'];

	function UsersController(users) {
		var vm = this;

		vm.users = users;
		console.log(users);
	}
})();
