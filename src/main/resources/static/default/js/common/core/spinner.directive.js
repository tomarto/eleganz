/**
 * @ngdoc Spinner Directive
 * @name spinner
 * @desc # Define the spinner to show when a loading is happening.
 */
(function() {
	'use strict';

	angular
		.module('core')
		.directive('spinner', spinner);

	spinner.$inject = ['notifier'];

	function spinner(notifier) {
		return {
			restrict: 'A',
			template: '<div class="loading-overlay"><i class="fa fa-spinner fa-spin"></i></div>',
			link: link
		};

		function link($scope, $elm, $attrs) {
			$elm.hide();
			notifier.subscribe($scope, 'loading', callback);

			function callback(event, param) {
				if(param) {
					$elm.show(200);
				} else {
					$elm.hide(200);
				}
			}
		}
	}
})();
