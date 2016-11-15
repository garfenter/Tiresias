var prequalMainController = angular.module('Prequal.MainController', []);

prequalMainController.controller('MainController', ['$scope', '$timeout', '$ionicLoading', '$ionicPlatform', '$ionicActionSheet', '$q', '$http', '$cordovaCamera', '$cordovaGeolocation', 'UserService', 
                                                    function($scope, $timeout, $ionicLoading, $ionicPlatform, $ionicActionSheet, $q, $http, $cordovaCamera, $cordovaGeolocation, UserService) {
    $scope.person = {};
    $scope.step = 0;    
    $scope.user = null;
    $scope.accessToken = null;
                                                        
    $scope.takeDpiPicture = function() {
        var options = { 
            quality : 75, 
            destinationType : Camera.DestinationType.DATA_URL, 
            sourceType : Camera.PictureSourceType.CAMERA, 
            allowEdit : false,
            encodingType: Camera.EncodingType.JPEG,
            popoverOptions: CameraPopoverOptions,
            saveToPhotoAlbum: false
        };

        $cordovaCamera.getPicture(options).then(function(imageData) {
            $scope.dpiImgURI = "data:image/jpeg;base64," + imageData;
            $scope.dpiData = imageData;
        }, function(err) {
            
        });
    };
                                                        
    $scope.loggedIn = function () {
        $scope.step = 1;  
    };
    
    $scope.takePersonPicture = function() {
        var options = { 
            quality : 75, 
            destinationType : Camera.DestinationType.DATA_URL, 
            sourceType : Camera.PictureSourceType.CAMERA, 
            allowEdit : false,
            encodingType: Camera.EncodingType.JPEG,
            popoverOptions: CameraPopoverOptions,
            saveToPhotoAlbum: false
        };

        $cordovaCamera.getPicture(options).then(function(imageData) {
            $scope.personImgURI = "data:image/jpeg;base64," + imageData;
            $scope.personData = imageData;
        }, function(err) {
            
        });
    }
    
    $scope.setStep = function(step){
        $scope.step = step;  
    };
    
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
        var posOptions = {timeout: 10000, enableHighAccuracy: false};
        $cordovaGeolocation
            .getCurrentPosition(posOptions)
            .then(function (position) {
              $scope.person.latitude = position.coords.latitude
              $scope.person.longitude = position.coords.longitude
            }, function(err) {
              alert("No se ha logrado obtener la ubicación GPS")
            });
    };
    
    $scope.send = function() {
        $scope.show("Enviando datos...", function(){
            
            var fd = new FormData();
            fd.append("dpiPicture", b64toBlob($scope.dpiData, 'image/jpeg'));
            fd.append("personPicture", b64toBlob($scope.personData, 'image/jpeg'));
            var canvas = document.getElementById('signature-drawing');
            var imageData = canvas.toDataURL();
            imageData = imageData.substring("data:image/png;base64,".length, imageData.length);
            fd.append("signature", b64toBlob(imageData, 'image/png'));
            fd.append("map", JSON.stringify($scope.person));
            fd.append("accessToken", $scope.accessToken);
            fd.append("userId", $scope.user.userID);
            
            $http.post('http://bpm.prequal.io:8180/jbpm-initiator/rs/jbpm/process/start', fd, {
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
            })
            .success(function(){
                    alert("Datos enviados exitosamente");
                    $scope.hide();
                    $scope.step = 5;
            })
            .error(function(){
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
    
    $scope.prepareCanvas = function(){
        

    };
    
    $scope.restart = function(){
        $scope.person = {};
        $scope.clearCanvas();
        $scope.step = 1;
        $scope.personImgURI = null;
        $scope.dpiImgURI = null;
        $scope.dpiData = null;
        $scope.personData = null;
    };
    
    $scope.clearCanvas = function(){
        var context = document.getElementById("signature-drawing").getContext('2d');
        context.clearRect(0, 0, context.canvas.width, context.canvas.height); // Clears the canvas
    };
    
    /**
    ** FACEBOOK LOGIN:
    **/
    var fbLoginSuccess = function(response) {
        if (!response.authResponse){
          fbLoginError("Cannot find the authResponse");
          return;
        }
        var authResponse = response.authResponse;
        $scope.loggedIn();        
        getFacebookProfileInfo(authResponse).then(function(profileInfo) {          
            $scope.user = {
                authResponse: authResponse,
				userID: profileInfo.id,
				name: profileInfo.name,
				email: profileInfo.email,
                picture : "http://graph.facebook.com/" + authResponse.userID + "/picture?type=large",
                type: 'facebook'
            };
            UserService.setUser($scope.user);            
            $ionicLoading.hide();
          
        }, function(fail){
          console.log('profile info fail', fail);
        });
  };

  var fbLoginError = function(error){
    console.log('fbLoginError', error);
    $ionicLoading.hide();
  };

  var getFacebookProfileInfo = function (authResponse) {
    var info = $q.defer();

    facebookConnectPlugin.api('/me?fields=email,name&access_token=' + authResponse.accessToken, null,
      function (response) {
        console.log(response);
        info.resolve(response);
      },
      function (response) {
		console.log(response);
        info.reject(response);
      }
    );
    return info.promise;
  };
  
  $scope.facebookSignIn = function() {
    if (window.cordova.platformId == "browser") {
        var appId = "1751078571809908";
        facebookConnectPlugin.browserInit(appId);
    }
    facebookConnectPlugin.getLoginStatus(function(success){
          if(success.status === 'connected'){
                $scope.accessToken = success.accessToken;                
                $scope.user = UserService.getUser('facebook');
                if($scope.user === null || !$scope.user.userID){
                    fbLoginSuccess(success);
                }else{
                    $scope.loggedIn();                    
                }
            } else {        
                console.log('getLoginStatus', success.status);
                $ionicLoading.show({
                    template: 'Logging in...'
                });
                facebookConnectPlugin.login(['email', 'public_profile'], fbLoginSuccess, fbLoginError);
            }
        });
    };
                                                        
    $scope.showLogOutMenuFacebook = function() {
		var hideSheet = $ionicActionSheet.show({
			destructiveText: 'Logout',
			titleText: 'Are you sure you want to logout? This app is awsome so I recommend you to stay.',
			cancelText: 'Cancel',
			cancel: function() {},
			buttonClicked: function(index) {
				return true;
			},
			destructiveButtonClicked: function(){
				$ionicLoading.show({
				  template: 'Logging out...'
				});
                // Facebook logout
                facebookConnectPlugin.logout(function(){
                  $ionicLoading.hide();
                  $scope.step = 0;
                },
                function(fail){
                  $ionicLoading.hide();
                });
			}
		});
	};
    /**
    ** FIN FACEBOOK LOGIN
    **/
                                                        
    /**
    ** INICIO GOOGLE +
    **/
                                                        
    $scope.googleSignIn = function() {
        $ionicLoading.show({
          template: 'Logging in...'
        });

        window.plugins.googleplus.login(
          {
            'webClientId': '169439555911-4l6psl4k0g422b2leic85nbedjqckfaa.apps.googleusercontent.com'
          },
          function (user_data) {
            $scope.user = {
              userID: user_data.userId,
              name: user_data.displayName,
              email: user_data.email,
              picture: user_data.imageUrl,
              accessToken: user_data.accessToken,
              idToken: user_data.idToken
            };
            UserService.setUser($scope.user);

            $ionicLoading.hide();            
          },
          function (msg) {
            $ionicLoading.hide();
          }
        );
    };
    $scope.showLogOutMenuGoogle = function() {
		var hideSheet = $ionicActionSheet.show({
			destructiveText: 'Logout',
			titleText: 'Are you sure you want to logout? This app is awsome so I recommend you to stay.',
			cancelText: 'Cancel',
			cancel: function() {},
			buttonClicked: function(index) {
				return true;
			},
			destructiveButtonClicked: function(){
				$ionicLoading.show({
					template: 'Logging out...'
				});
				// Google logout
				window.plugins.googleplus.logout(
					function (msg) {
						console.log(msg);
						$ionicLoading.hide();
						$state.go('welcome');
					},
					function(fail){
						console.log(fail);
					}
				);
			}
		});
	};
        
    /**
    ** FIN GOOGLE +
    **/
    
    $scope.checkIfLogged = function (){
        if (window.cordova.platformId == "browser") {
            var appId = "1751078571809908";
            facebookConnectPlugin.browserInit(appId);
        }
        facebookConnectPlugin.getLoginStatus(function(success){
              if(success.status === 'connected'){
                    $scope.accessToken = success.accessToken;                
                    $scope.user = UserService.getUser('facebook');
                    if($scope.user === null || !$scope.user.userID ){
                        fbLoginSuccess(success);
                    }else{
                        $scope.loggedIn();
                    }
                } else {
                    window.plugins.googleplus.trySilentLogin(
                    {
                      'webClientId': '169439555911-4l6psl4k0g422b2leic85nbedjqckfaa.apps.googleusercontent.com'
                    },
                    function (user_data) {                      
                      $scope.accessToken = user_data.accessToken;
                      $scope.loggedIn();
                      $scope.user = {
                          userID: user_data.userId,
                          name: user_data.displayName,
                          email: user_data.email,
                          picture: user_data.imageUrl,
                          accessToken: user_data.accessToken,
                          idToken: user_data.idToken
                        };
                      UserService.setUser($scope.user);
                    },
                    function (msg) {
                      
                    }
                    );
                }
        });
    };    
    $ionicPlatform.ready(function() {
        $scope.checkIfLogged();
    })
    
}]);