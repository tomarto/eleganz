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
			.state('login', {
				url : '/login?error?logout',
				templateUrl : '/welcome/login.html',
				controller: 'LoginController',
				controllerAs: 'lvm'
			});

		$urlRouterProvider.otherwise('login');
	}
})();
