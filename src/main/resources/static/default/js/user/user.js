/**
 * @ngdoc User Module
 * @name user
 * @desc # Define all dependencies for user app
 */
(function() {
	'use strict';

	angular
		.module('user', [
			'ui.router',
			'ngMessages',
			'ngAnimate',
			'ngTouch',
			'ngSanitize',
			'ui.bootstrap',
			'timer',
			'core',
			'header',
			'home'
		]);
})();
