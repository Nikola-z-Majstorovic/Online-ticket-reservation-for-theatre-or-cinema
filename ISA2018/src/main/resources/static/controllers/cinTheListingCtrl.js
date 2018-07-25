myModule.controller('cinTheListingCtrl', ['$rootScope', '$scope', '$timeout', '$window', 'dataService','$http', 'appService', function ($rootScope, $scope, $timeout, $window, dataService,$http, appService) {
    //-----------------------------------------------------------------------------------------------------------
    console.log('we are in cinTheListing ctrl');
    $scope.selectedEntities = [];
    $scope.loadEntities = function(entityType){
    	if(entityType == 1){
    		$scope.entityType = 'Cinema';  
    		    		
    		$scope.selectedEntities = angular.copy(appService.lodashFilterBy($rootScope.cinemasAndTheaters, 'isCinema', entityType));
    		//Load cinemas using data service
    	}else{
    		$scope.entityType = 'Theater';
    		
    		$scope.selectedEntities = angular.copy(appService.lodashFilterBy($rootScope.cinemasAndTheaters, 'isCinema', entityType));
    		//Load theaters using data service
    	}
    };
    
    $scope.deleteEntity = function(entityId){
    	//call data service to delete entity for given id
    	
    	//refresh entity data
    	if($scope.entityType == 'Cinema'){
    		//Load cinemas using data service
    		
    	}else{
    		//Load theaters using data service
    		
    	}
    }
}]);
