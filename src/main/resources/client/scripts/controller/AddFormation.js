'use strict';


angular.module('app')
	  	.controller('AddFormationCtrl', ['$scope','$http','$location','formationSvc',function ($scope,$http,$location,formationSvc) {
	    
	  		$scope.formation = {
	  				codeFormation : "",
	  				nomFormation : "",
	  				diplome : "",
	  				doubleDiplome : "",
	  				nombreDAnnee : "",
	  				debutAccreditation : "",
	  				finAccreditation : ""
	  		}

	  		$scope.addFormation = function(){
	  			$scope.formation["Content-Type"] = "application/json";

	  			var clientUrl = '/formation/add';
	  			var request = $http({
	  				method: "POST",
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