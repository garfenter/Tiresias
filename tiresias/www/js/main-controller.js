var prequalMainController = angular.module('Prequal.MainController', []);

prequalMainController.controller('MainController', ['$scope', '$timeout', '$ionicLoading', '$http', function($scope, $timeout, $ionicLoading, $http) {
    $scope.person = {};
    
    $scope.read = function(){
        $scope.show("Cargando...", function(){
            $scope.person = {};
            cordova.exec(function(data){
                $scope.readed = true;
                $scope.hide();
                $scope.person = JSON.parse(data);
            }, function(data){
                $scope.hide();
                alert(data);
            }, "FtReaderPlugin", "read", [""]);
        });
    };
    
    $scope.send = function() {
        $scope.show("Enviando datos...", function(){
            $http.post('http://52.27.102.98:8080/jbpm-initiator/rs/jbpm/process/start', $scope.person).then(function(response) {
                alert("Datos enviados exitosamente");
                $scope.hide();
            }, function(response) {
                alert("No se han logrado enviar los datos, verifique la conexión a internet");
                $scope.hide();
            });
        });
        
    };
    
    $scope.show = function(text, callback) {
        $ionicLoading.show({
          template: text
        }).then(function(){
           console.log("The loading indicator is now displayed");
           callback();
        });
    };
    $scope.hide = function(){
        $ionicLoading.hide().then(function(){
           console.log("The loading indicator is now hidden");
        });
    };
    
}]);