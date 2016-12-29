/**
 * @ngdoc Header Controller
 * @name HeaderController
 * @desc # Define the ViewModel that will be used along the header view
 */
(function() {
	'use strict';

	angular
		.module('header')
		.controller('HeaderController', HeaderController);

	HeaderController.$inject = ['$scope', '$window'];

	function HeaderController($scope, $window) {
		var vm = this;

		angular.element($window).bind('resize', function(){
			$scope.$apply();
		});

		$scope.$watch(function() {
			return $window.innerWidth;
		}, function(newValue) {
			vm.isDesktop = newValue > 767;
			vm.isMobile = !vm.isDesktop;
		}, true);
	}
})();
