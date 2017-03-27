var app = angular.module('homeApp', []);
app.controller('homeCtrl', function ($scope) {
    $scope.opacity = {
        "opacity": "1"
    }
    $scope.fadeOut = function () {
        $scope.opacity = {
            "opacity": "0.2"
        }
    }
    $scope.fadeIn = function () {
        $scope.opacity = {
            "opacity": "1"
        }
    }
    $scope.show = false;
    $scope.signupDirect=function(){
    	 window.location = "Signup.jsp";
    }
});
