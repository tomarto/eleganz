/**
 * @ngdoc Create User Controller
 * @name CreateUserController
 * @desc # Define the ViewModel that will be used along the create user modal view
 */
(function() {
	'use strict';

	angular
		.module('users')
		.controller('CreateUserController', CreateUserController);

	CreateUserController.$inject = ['locations', 'usersService', 'formValidation', 'toasterService'];

	function CreateUserController(locations, usersService, formValidation, toasterService) {
		var vm = this;

		vm.locations = locations;
		vm.userTypes = [
			{
				name: 'Administrador',
				value: 'ROLE_ADMIN'
			},
			{
				name: 'Usuario',
				value: 'ROLE_USER'
			}
		];
		vm.eventTypes = [
			{
				name: 'Boda',
				value: 'WEDDING'
			}
		];
		vm.locationEventTypes = [
			{
				name: 'Iglesía',
				value: 'CHURCH'
			},
			{
				name: 'Boda',
				value: 'WEDDING'
			}
		];
		vm.weddingPersonTypes = [
			{
				name: 'Novia',
				value: 'BRIDE'
			},
			{
				name: 'Novio',
				value: 'GROOM'
			}];
		vm.newUser = {
			type: vm.userTypes[1].value,
			detail: {
				type: vm.eventTypes[0].value,
				events: []
			}
		};
		vm.validation = {
			email: {
				minlength: 3,
				maxlength: 50,
				regex: /^[A-z_]+[A-z0-9._-]*[A-z0-9_]+@[A-z]+\.[A-z.]{2,5}$/
			},
			person: {
				minlength: 3,
				maxlength: 50,
				regex: /^[A-z -]*$/
			}
		};

		vm.showFieldMessages = formValidation.showFieldMessages;
		vm.fieldHasWarning = formValidation.fieldHasWarning;
		vm.fieldHasError = formValidation.fieldHasError;
		vm.changeEventType = changeEventType;
		vm.addEvent = addEvent;
		vm.createUser = createUser;

		init();

		function init() {
			changeEventType();
		}

		function changeEventType() {
			angular.forEach(vm.eventTypes, function(eventType) {
				if('Boda' === eventType.name) {
					vm.newUser.detail.people = [];
					vm.newUser.detail.people.push({type: vm.weddingPersonTypes[0].value});
					vm.newUser.detail.people.push({type: vm.weddingPersonTypes[1].value});
				}
			});
		}

		function addEvent() {
			vm.newUser.detail.events.push({type: vm.locationEventTypes[0].value});
		}

		function createUser() {
			usersService.createUser(vm.newUser)
				.then(function(response) {
					toasterService.success(response);
				})
				.catch(function(error) {
					toasterService.error(error.errorMessage);
				});
		}
	}
})();
