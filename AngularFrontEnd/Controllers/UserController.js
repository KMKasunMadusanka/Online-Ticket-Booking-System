angular.module("User", []).controller("UserController", function ($scope,$http) {

    $scope.clear = function () {
        $scope.user={};
    }

    $scope.registerUser = function (user) {

        if(user!=null){
            $scope.TemporaryObj = {};

            if(user.password==user.Cpassword){

                $scope.TemporaryObj={

                    "Name":user.name,
                    "Telephone":user.Tel,
                    "NIC":user.nic,
                    "Email":user.email,
                    "Address":user.address,
                    "Password":user.password

                }

                $http.post('http://192.168.8.101:8280/users/post',$scope.TemporaryObj).then(result=>{

                    alert('User Successfully Registered');
                    location.replace("LogIn.html");

                });



            }
            else{
                alert('Enter Matching Password');
            }

        }else {
            alert('Enter Data');
        }

    }

});
