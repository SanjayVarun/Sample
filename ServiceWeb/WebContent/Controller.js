angular.module('customerApp',[]).controller('customerCtrl',function($scope) {
	$scope.showTypes=false;
	$scope.search=function(){
		$scope.showTypes=!$scope.showTypes;}
});