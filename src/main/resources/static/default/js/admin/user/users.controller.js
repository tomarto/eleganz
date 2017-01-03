/**
 * @ngdoc Users Controller
 * @name UsersController
 * @desc # Define the ViewModel that will be used along the users view
 */
(function() {
	'use strict';

	angular
		.module('user')
		.controller('UsersController', UsersController);

	UsersController.$inject = [];

	function UsersController() {
		var vm = this;
	}
})();
