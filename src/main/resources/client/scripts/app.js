(function() {
	'use strict';
	var app = angular.module(
			'app',
			[ 'ngRoute', 'ngAnimate', 'ui.bootstrap', 'easypiechart',
					'mgo-angular-wizard', 'textAngular', 'ui.tree',
					'ngTagsInput', 'ap.lateralSlideMenu' ]).config(
			[ '$routeProvider', function($routeProvider, $urlRouterProvider) {
				$routeProvider.when('/', {
					templateUrl : 'views/login.html',
					controller : 'LoginController',
					controllerAs : 'LoginController'
				}).when('/', {
					templateUrl : 'views/login.html',
					controller : 'LoginController',
					notLoggedNeeded : true
				}).when('/addFormation', {
					templateUrl : 'views/AddFormation.html',
					controller : 'AddFormationCtrl',
					controllerAs : 'FormationController'
				})

				.when('/delete/:codeFormation', {
					templateUrl : 'views/deleteFormation.html',
					controller : 'DeleteFormationCtrl',
					controllerAs : 'DeleteFormationCtrl'
				})

				.when('/update/:codeFormation', {
					templateUrl : 'views/updateFormation.html',
					controller : 'UpdateFormationCtrl',
					controllerAs : 'UpdateFormationCtrl'
				})

				.when('/formation', {
					templateUrl : 'views/formationList.html',
					controller : 'FormationCtrl',
					controllerAs : 'FormationController'
				}).otherwise({
					redirectTo : '/login'
				})
			} ]).run(function($rootScope, $route, $location, LoginService) {
		$rootScope.$on("$routeChangeStart", function(e, to) {
			if (to.notLoggedNeeded) {
				return;
			}
			LoginService.getUser().success(function(data) {
				if (data) {
					e.preventDefault();
				} else {
					$location.path("/");
				}
			}).error(function(data) {
				$location.path("/");
			});
		});
	});
}).call(this);
