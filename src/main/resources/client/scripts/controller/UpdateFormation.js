'use strict';
angular.module('app')
	.service('formationUpdateSvc', ['$http', function ($http) {
		this.getFormationByCodeFormation = function (codeFormation,callback) {
			var url = "http://localhost:8090/formation/"+codeFormation;
			$http.get(url).then(function (response) {
				callback(response.data);
			});
		};

	}]);

angular.module('app') .controller('UpdateFormationCtrl', ['$http','$location','$scope','$routeParams','$window','formationUpdateSvc',function ($http,$location,$scope,$routeParams,$window,formationUpdateSvc) {
	formationUpdateSvc.getFormationByCodeFormation( $routeParams.codeFormation,function(data){ 
		$scope.formation = data;
	});
	
	 
	$scope.updateFormation = function(){
	  			$scope.formation["Content-Type"] = "application/json";
	  			
	  			var clientUrl = "/formation/update";
	  			var request = $http({
	  				method: "PUT",
	  				url: clientUrl,
	  				data: $scope.formation
	  			});
	  			request.success(
	  				function(response) {
	  					$location.path('/formation');
	  				}
	  			);
	  		}
  }])