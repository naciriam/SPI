'use strict';
angular.module('app')
.factory('LoginService',['$http',function($http){
	return{
		authentification : function(request){
			var config = {
				url : '/login',
				method : "POST",
				data : request
			};
			return $http(config);
		},
		getUser : function(){
			var config = {
				url : '/user',
				method : 'GET'
			};
			return $http(config);
		},
		deconnexion : function(){
			var config = {
				url : '/logout',
				method : "GET"
			};
			return $http(config);
		}
	}
}]);

angular.module('app').controller(
		'LoginController',
		[
				'$scope',
				'LoginService',
				'$location',
				function($scope, LoginService, $location) {

					$scope.signin = function() {
						var request = LoginService.authentification($scope.user);

						request.success(function(response) {
							$location.path('/formation');
						});
						request.error(function(response, status, headers,
								config) {
						});
					}

				} ]);

