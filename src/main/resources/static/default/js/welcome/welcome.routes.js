/**
 * @ngdoc Welcome Routes
 * @name welcome.routes
 * @desc # Define all routes for welcome app
 */
(function() {
	'use strict';

	angular
		.module('welcome')
		.config(WelcomeRoutes);

	WelcomeRoutes.$inject = ['$stateProvider', '$urlRouterProvider'];

	function WelcomeRoutes($stateProvider, $urlRouterProvider) {
		$stateProvider
			.state('app', {
				abstract: true,
				views: {
					'header': {
						templateUrl : '/welcome/partials/header.html',
						controller: 'HeaderController',
						controllerAs: 'hvm'
					}
				}
			})
			.state('app.home', {
				url : '/inicio',
				views: {
					'content@': {
						templateUrl : '/welcome/partials/home.html'
					}
				}
			})
			.state('app.aboutUs', {
				url : '/conocenos',
				views: {
					'content@': {
						templateUrl : '/welcome/partials/about-us.html'
					}
				}
			})
			.state('app.services', {
				url : '/servicios',
				views: {
					'content@': {
						templateUrl : '/welcome/partials/services.html',
						controller: 'ServicesController',
						controllerAs: 'svm'
					}
				}
			})
			.state('app.login', {
				url : '/login?error?logout',
				views: {
					'content@': {
						templateUrl : '/welcome/partials/login.html',
						controller: 'LoginController',
						controllerAs: 'lvm'
					}
				}
			});

		$urlRouterProvider.otherwise('inicio');
	}
})();
