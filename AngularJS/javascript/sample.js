var app = angular.module("myApp" , []);
app.controller("myCtrl" , function($scope) {
	$scope.test = "lightgreen";
	$scope.myStyle = {
		"color" :	"red",
		"font-family" :	"verdana",
		"font-size" :	"34px"
	}
});