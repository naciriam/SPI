'use strict';

angular.module('app')
  .service('supprimerSvc', ['$http','$routeParams', function ($http,$routeParams) {
   this.fetchPopular = function(callback) {
   		var url = "http://localhost:8090/formation/delete/" + $routeParams.codeFormation;
   		$http.delete(url).then(function(response){
   			callback(response.data);
   		});
   };
  }]);


angular.module('app')
	  	.controller('DeleteFormationCtrl', ['$scope','$routeParams','supprimerSvc','$window',function ($scope,$routeParams,supprimerSvc,$window) {
    	supprimerSvc.fetchPopular(function(){
                console.log('Supprimer avec succes');
                $window.location = '#/formation';
                
    	})
 	  }]);
/*
'use strict';


angular.module('app')
	  	.service('DeleteFormationCtrl', ['$scope','$http','$location','formationSvc',function ($http,$routeParams) {
	    
	  		
	  		/*$scope.deleteFormation = function(){
	  			$scope.codeFormation["Content-Type"] = "application/json";

	  			var clientUrl = '/formation/delete';
	  			var request = $http({
	  				method: "POST",
	  				url: clientUrl,
	  				data: $scope.codeFormation
	  			});
	  			request.success(
	  				function(response) {
	  					$location.path('/formation');
	  				}
	  			);
	  		}
	  		
	  		$scope.deleteFormation = function(object) {
	  			alert("DeleteController");
	  			var request = $http({
	  		        url: '/formation/delete/'+$scope.codeFormation,
	  		        method: 'DELETE',
	  		        headers: {
	  		            "Content-Type": "application/json;charset=utf-8"
	  		        }
	  		    }).then(function(res) {
	  		        console.log(res.data);
	  		    }, function(error) {
	  		        console.log(error);
	  		    });
	  		  request.success(
		  				function(response) {
		  					$location.path('/formation');
		  				}
		  			);
	  		};
  }])
  
*/