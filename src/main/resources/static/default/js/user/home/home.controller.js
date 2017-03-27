/**
 * @ngdoc Home Controller
 * @name HomeController
 * @desc # Define the ViewModel that will be used along the home view
 */
(function() {
	'use strict';

	angular
		.module('home')
		.controller('HomeController', HomeController);

	HomeController.$inject = ['currentUser', 'inviteService'];

	function HomeController(currentUser, inviteService) {
		var vm = this;

		vm.invites = [{}];
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

		vm.addInvite = addInvite;
		vm.sendInvites = sendInvites;

		function init() {
			vm.title = getTitle();
			vm.time = getTime();
		}

		function getTitle() {
			var title = [];
			angular.forEach(currentUser.userDetail.people, function(person) {
				title.push(person.firstName);
			});

			return title.join(' y ');
		}

		function getTime() {
			var result;
			angular.forEach(currentUser.userDetail.events, function(event) {
				if(event.date) {
					var date = event.date.split('-');
					result = new Date(date[0], date[1] - 1, date[2]);
				}
			});

			return result;
		}

		function addInvite() {
			vm.invites.push({});
		}

		function sendInvites(isFormValid) {
			if(isFormValid) {
				inviteService.sendEmail(vm.invites)
					.then(function(data) {
						toasterService.success(data);
					})
					.catch(function(error) {
						toasterService.error(error.errorMessage);
					});
			}
		}

		init();
	}
})();
