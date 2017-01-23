/**
 * @ngdoc Admin Routes
 * @name admin.routes
 * @desc # Define all routes for admin app
 */
(function() {
	'use strict';

	angular
		.module('admin')
		.config(AdminRoutes);

	AdminRoutes.$inject = ['$stateProvider', '$urlRouterProvider'];

	function AdminRoutes($stateProvider, $urlRouterProvider) {
		$stateProvider
			.state('app', {
				abstract: true,
				resolve: {
					currentUser: ['authenticationService', function(authenticationService) {
						return authenticationService.getUser();
					}]
				},
				views: {
					'header': {
						templateUrl : '/admin/partials/header.html',
						controller: 'HeaderController',
						controllerAs: 'hvm'
					}
				}
			})
			.state('app.users', {
				url : '/usuarios',
				resolve: {
					users: ['usersService', function(usersService) {
						return usersService.getUsers();
					}]
				},
				views: {
					'content@': {
						templateUrl : '/admin/partials/users.html',
						controller: 'UsersController',
						controllerAs: 'uvm'
					}
				}
			});

		$urlRouterProvider.otherwise('usuarios');
	}
})();
