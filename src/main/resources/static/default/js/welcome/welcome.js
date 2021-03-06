/**
 * @ngdoc Welcome Module
 * @name welcome
 * @desc # Define all dependencies for welcome app
 */
(function() {
	'use strict';

	angular
		.module('welcome', [
			'ui.router',
			'ngMessages',
			'ngAnimate',
			'ngTouch',
			'ui.bootstrap',
			'core',
			'header',
			'services',
			'contact',
			'login'
		]);
})();
