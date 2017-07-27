angular.module("MainModule", []).controller("MainController", function ($scope,$http) {


    $scope.filmData = [];

    $http.get('http://192.168.8.101:8280/films/get').then(result=>{
        $scope.filmData=result.data;
    });



    $scope.rates = [
        {
            "Category": "ODC",
            "Type": "Full",
            "Price": "700.00"

        },
        {
            "Category": "ODC",
            "Type": "Half",
            "Price": "550.00"

        },
        {
            "Category": "BALCONY",
            "Type": "Full",
            "Price": "900.00"

        },
        {
            "Category": "BALCONY",
            "Type": "Half",
            "Price": "750.00"

        },
        {
            "Category": "BOX",
            "Type": "Full",
            "Price": "1900.00"

        }

    ];


    $scope.recordData=function (filmData) {
        if(filmData!=null){
            $http.post('http://192.168.8.101:8280/users/recordData',filmData).then(res=>{
                location.replace('./snackSelection.html');
            });
        }
    }






});