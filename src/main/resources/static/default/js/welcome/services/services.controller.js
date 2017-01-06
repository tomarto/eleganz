/**
 * @ngdoc Services Controller
 * @name ServicesController
 * @desc # Define the ViewModel that will be used along the services view
 */
(function() {
	'use strict';

	angular
		.module('login')
		.controller('ServicesController', ServicesController);

	ServicesController.$inject = [];

	function ServicesController() {
		var vm = this;

		vm.rows = [
			{
				services: [
					{
						name: 'Sombreros',
						imageUrl: '/welcome/images/servicios/sombreros.png',
						description: 'Has que tu evento sea colorido con nuestros diferentes tipos de sombreros y ' +
								'diviértanse como nunca.'
					},
					{
						name: 'Robot LED',
						imageUrl: '/welcome/images/servicios/robot-led.png',
						description: 'Ilumina el escenario y la pista de baile con nuestro robot LED.'
					}
				]
			},
			{
				services: [
					{
						name: 'Accesorios',
						imageUrl: '/welcome/images/servicios/accesorios.png',
						description: 'Diviértete con los accesorios referentes al tipo de música.'
					},
					{
						name: 'Letras de boda',
						imageUrl: '/welcome/images/servicios/letras-boda.png',
						description: 'Decora el recibidor o el salón con las letras de boda gigante.'
					}
				]
			},
			{
				services: [
					{
						name: 'Arlequin de Carnaval',
						imageUrl: '/welcome/images/servicios/arlequin-carnaval.png',
						description: 'Deja salir el espíritu de fiesta con nuestros arlequines de carnaval.'
					}
				]
			}
		];
	}
})();
