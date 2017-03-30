angular.module('customerApp',[]).controller('Controller',function($scope,$http) {

	$http.get("http://172.24.18.77:8080/aayl/service/SPdetails").then(function(response){
	    $scope.spdata = response.data;
});
	$http.get("http://172.24.18.77:8080/aayl/service/AdminDetails").then(function(response){
	    $scope.admindata = response.data;
	});
	$scope.showTypes=false;
	$scope.showDetails=false;
	$scope.showAppt=true;
	$scope.showSearch=function(){
		$scope.showTypes=!$scope.showTypes;};
		$scope.showSpDet=function(){
			$scope.showDetails=!$scope.showDetails;
		};
		$scope.custChoice=function(){
			$scope.index=this.$index;
			$scope.id=$scope.spdata[$scope.index].service_provider_id;
		};
		$scope.showAppt=function(){
			$scope.showAppt=!$scope.showAppt;
			
		}
		
		
			

		//$scope.getSpDetails=function($scope,$http){
			//$http.get("172.24.18.77:8080/service/SPdetails").then(function(response){
			  //  $scope.spdata = response.data;
		
		/*$scope.reqAppointmentDetails=function($scope,$http){
	    $http.get("172.24.18.77:8080/service/Appointmentdetails").then(function(response){
		    $scope.appointmentdata = response.data;
	});};*/
		    });