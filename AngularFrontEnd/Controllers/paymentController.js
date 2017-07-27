angular.module("payment", []).controller("paymentController", function ($scope,$http) {

    $scope.clearData=function(){
        $scope.payment={};
    }

    $scope.obj={};
    $scope.doPayment=function (val) {
        if(val.card!=null){
            $scope.obj={
                "CardNo":val.card,
                "CVV":val.cvv
            }

            $http.post('http://192.168.8.101:8280/payments/doPayment',$scope.obj).then(result=>{

                if(result.data=="Payment Successful"){
                    alert(result.data);
                }
                else if(result.data=="Payment UnSuccessful... Account Value Is Not Enough to do the transaction."){
                    alert(result.data);
                }
                else if(result.data=="Invalid Card No."){
                    alert(result.data);
                }

            });

        }
        else if(val.phone!=null){

            $scope.obj={
                "PhoneNo":val.phone
            }

            $http.post('http://192.168.8.101:8280/monyeTransations/proceed',$scope.obj).then(result=>{

                if(result.data=="Payment Successful"){
                    alert(result.data);
                }
                else if(result.data=="Payment UnSuccessful... Account Value Is Not Enough to do the transaction."){
                    alert(result.data);
                }
                else if(result.data=="Invalid Card No."){
                    alert(result.data);
                }
            });
        }

        else {
            alert('Enter Payment data');
        }

    }

});