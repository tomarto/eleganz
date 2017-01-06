/**
 * @ngdoc Notifier Factory
 * @name notifier
 * @desc # Define the notifier service for subscribe and notify events.
 */
(function() {
	'use strict';

	angular
		.module('core')
		.factory('notifier', notifier);

	notifier.$inject = ['$rootScope'];

	function notifier($rootScope) {
		var factory = {
			subscribe: subscribe,
			notify: notify
		};

		return factory;

		function subscribe(scope, eventName, callback) {
			var handler = $rootScope.$on(eventName, callback);
			scope.$on('$destroy', handler);
		}

		function notify(eventName, value) {
			$rootScope.$emit(eventName, value);
		}
	}
})();
