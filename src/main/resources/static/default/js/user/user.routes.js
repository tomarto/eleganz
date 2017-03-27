/**
 * @ngdoc User Routes
 * @name user.routes
 * @desc # Define all routes for user app
 */
(function() {
	'use strict';

	angular
		.module('user')
		.config(UserRoutes);

	UserRoutes.$inject = ['$stateProvider', '$urlRouterProvider'];

	function UserRoutes($stateProvider, $urlRouterProvider) {
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
						templateUrl : '/user/partials/header.html',
						controller: 'HeaderController',
						controllerAs: 'hvm'
					}
				}
			})
			.state('app.home', {
				url : '/inicio',
				views: {
					'content@': {
						templateUrl : '/user/partials/home.html',
						controller: 'HomeController',
						controllerAs: 'hvm'
					}
				}
			});

		$urlRouterProvider.otherwise('inicio');
	}
})();
