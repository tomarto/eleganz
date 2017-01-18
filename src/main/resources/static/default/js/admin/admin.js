/**
 * @ngdoc Admin Module
 * @name admin
 * @desc # Define all dependencies for admin app
 */
(function() {
	'use strict';

	angular
		.module('admin', [
			'ui.router',
			'ngMessages',
			'ngAnimate',
			'ngTouch',
			'ngSanitize',
			'ui.bootstrap',
			'core',
			'header',
			'users'
		]);
})();
