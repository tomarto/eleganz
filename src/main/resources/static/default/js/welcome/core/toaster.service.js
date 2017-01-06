/**
 * @ngdoc Toaster Factory
 * @name toasterService
 * @desc # Define the different ways to display messages.
 */
(function() {
	'use strict';

	angular
		.module('core')
		.factory('toasterService', toasterService);

	toasterService.$inject = ['toaster'];

	function toasterService(toaster) {
		var factory = {
			success: success,
			error: error,
			warning: warning,
			clear: clear
		};

		return factory;

		function success(body) {
			toaster.pop({type: 'success', body: body, showCloseButton: false});
		}

		function error(body) {
			toaster.pop({type: 'error', body: body, showCloseButton: true, timeout: 0});
		}

		function warning(body) {
			toaster.pop({type: 'warning', body: body, showCloseButton: true, timeout: 0});
		}

		function clear() {
			toaster.clear();
		}
	}
})();
