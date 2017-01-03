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
			'ui.bootstrap',
			'header',
			'user'
		]);
})();
