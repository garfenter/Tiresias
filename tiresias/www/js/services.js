var prequalServices = angular.module('Prequal.Services', []);
    prequalServices.factory('UserService', function() {
      var userService = {};
      
      userService.getUser = function(type){
          var value = localStorage.getItem("user_" + type);
          if(value === null) {
              return null;              
          }
          return JSON.parse(value);
      };
      
      userService.setUser = function(user, type){
          var value = JSON.stringify(user);
          localStorage.setItem("user_" + type, value);          
          localStorage.setItem("last_used_type", type);
      };    
      
      return userService;
});