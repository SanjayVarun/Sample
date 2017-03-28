angular.module('customerApp',[]).controller('customerCtrl',function($scope) {
	$scope.showTypes=false;
	$scope.search=function(){
		$scope.showTypes=!$scope.showTypes;};
	$scope.searchfunc=function($scope,$http){
		$http.get("172.24.18.77:8080/service/services").then(function(response){
		    $scope.serviceproviderdata = response.data;
	})};
});