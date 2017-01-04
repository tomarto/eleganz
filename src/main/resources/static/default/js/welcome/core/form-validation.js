/**
 * @ngdoc Form Validation Factory
 * @name formValidation
 * @desc # Define the validations used for forms.
 */
(function() {
	'use strict';

	angular
		.module('core')
		.factory('formValidation', formValidation);

	formValidation.$inject = [];

	function formValidation() {
		var factory = {
			showFieldMessages: showFieldMessages,
			fieldHasWarning: fieldHasWarning,
			fieldHasError: fieldHasError
		};

		return factory;

		function showFieldMessages(formField) {
			return formField.$dirty && formField.$invalid;
		}

		function fieldHasWarning(formField) {
			return formField.$error.minlength || formField.$error.maxlength;
		}

		function fieldHasError(formField) {
			return (formField.$dirty && formField.$error.required) || formField.$error.pattern;
		}
	}
})();
