angular.module("MainModule", []).controller("snackController", function ($scope,$http) {

   
    $scope.snackData = [];
    $scope.Snacks = [];
    $scope.SnackObj = {};

    $http.get('http://192.168.8.101:8280/sancks/get').then(res=>{
        $scope.snackData=res.data;
    });


    $scope.addFood = function (snack) {
        if(snack.shop!=null && snack.type!=null ){
            $scope.SnackObj={
                "shop":snack.shop,
                "name":snack.type,
                "quantity":snack.quantity,
                "price":(snack.quantity*50)
            };

            $scope.Snacks.push($scope.SnackObj);
        }

    };

    $scope.deleteFood = function (snack) {
        $scope.Snacks.splice($scope.Snacks.indexOf(snack),1);
    }



    $scope.GoToPayments = function (snack) {

        if(snack!=null){
            $http.post('http://192.168.8.101:8280/users/recordData',snack).then(res=>{
                console.log(res);
            });
        }

        location.replace('payment.html');

    }





});