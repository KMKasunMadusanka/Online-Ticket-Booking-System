angular.module("LogIn", []).controller("LogInController", function ($scope,$http) {


    $scope.Obj={};

    //log in function
    $scope.login=function (login) {

        $scope.Obj={
            "username":log.username,
            "password":log.password
        }

        $http.post('http://192.168.8.101:8280/users/authenticate',$scope.tempObj).then(result=>{

            if(result.data){
                alert('Welcome to Online Film Tickets Reservation System');
                location.replace("MovieInterface.html");
            }

        });

    }

    //clear data using function
    $scope.clear =function () {
        $scope.login={};
    }

    //move to registration
    $scope.gotoRegister=function () {
        location.replace("UserRegistration.html");
    }




});
