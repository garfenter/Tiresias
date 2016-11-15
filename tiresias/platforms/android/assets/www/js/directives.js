var prequalDirectives = angular.module('Prequal.Directives', []);

prequalDirectives.directive("drawing", function(){
  return {
    restrict: "A",
    link: function(scope, element){
      var ctx = element[0].getContext('2d');

      // variable that decides if something should be drawn on mousemove
      var drawing = false;

      // the last coordinates before the current move
      var lastX;
      var lastY;
        
      element.bind('touchstart', function(event){
        lastX = event.touches[0].clientX - event.currentTarget.offsetLeft;
        lastY = event.touches[0].clientY - (event.currentTarget.offsetTop + 43);
        console.log(lastX);
        console.log(lastY);
        console.log(event.currentTarget.offsetLeft);
        console.log(event.currentTarget.offsetTop);
        // begins new line
        ctx.beginPath();
        drawing = true;
      });
        
     element.bind('touchmove', function(event){
        if(drawing){
          // get current mouse position
          currentX = event.touches[0].clientX - (event.currentTarget.offsetLeft);
          currentY = event.touches[0].clientY - (event.currentTarget.offsetTop + 43);

          draw(lastX, lastY, currentX, currentY);

          // set current coordinates to last one
          lastX = currentX;
          lastY = currentY;
        }
      });
        
      element.bind('touchend', function(event){
        // stop drawing
        drawing = false;
      });
        
      element.bind('mousedown', function(event){
        if(event.offsetX!==undefined){
          lastX = event.offsetX;
          lastY = event.offsetY;
        } else { // Firefox compatibility
          lastX = event.layerX - (event.currentTarget.offsetLeft);
          lastY = event.layerY - (event.currentTarget.offsetTop + 43);
        }

        // begins new line
        ctx.beginPath();

        drawing = true;
      });
      element.bind('mousemove', function(event){
        if(drawing){
          // get current mouse position
          if(event.offsetX!==undefined){
            currentX = event.offsetX;
            currentY = event.offsetY;
          } else {
            currentX = event.layerX - event.currentTarget.offsetLeft;
            currentY = event.layerY - event.currentTarget.offsetTop;
          }

          draw(lastX, lastY, currentX, currentY);

          // set current coordinates to last one
          lastX = currentX;
          lastY = currentY;
        }

      });
      element.bind('mouseup', function(event){
        // stop drawing
        drawing = false;
      });

      // canvas reset
      function reset(){
       element[0].width = element[0].width; 
      }

      function draw(lX, lY, cX, cY){
        // line from
        ctx.moveTo(lX,lY);
        // to
        ctx.lineTo(cX,cY);
        // color
        ctx.strokeStyle = "#000000";
        // draw it
        ctx.stroke();
      }
    }
  };
}).directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);;