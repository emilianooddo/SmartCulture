<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Esempio di una mappa con Google maps v3</title>
   <meta name="description" content="Un esempio di una mappa Google(tm) su una pagina HTML usando Google Maps v3, HTML5 e CSS3">
   <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
   

<title>Insert title here</title>
</head>
<body onload="maps()">

		<%
		
		
		//float[] coordinate_x = (float[])request.getAttribute("coordinate_x");
		//float[] coordinate_y = (float[])request.getAttribute("coordinate_y");
		String coordinate_x = (String)request.getAttribute("coordinate_x");
		String coordinate_y = (String)request.getAttribute("coordinate_y");
		

		%>
		
		
<h3>Risultati della ricerca:</h3>

<div id="map" style="width: 800px; height: 650px; position: relative; top:0; overflow: hidden;"></div>

   <p id="demo"></p>
   
<script type="text/javascript"async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAueas29SNrOG_NHvyesnZnZb-ktwfkkGg&callback=initMap"
  type="text/javascript"></script>
   <script type="text/javascript">
      function maps() {
    	  
    	  
    	  var stringx = '<%=coordinate_x%>'; 
    	  var stringy = '<%=coordinate_y%>'; 
    	  
    	  var resx = stringx.split(" ");
    	  var resy = stringy.split(" ");
    	  var size = resx.lenght;
    	  var map = new google.maps.Map(document.getElementById('map'), {
    	      zoom: 14,
    	      center: new google.maps.LatLng(38.115016, 13.354877),
    	      mapTypeId: google.maps.MapTypeId.ROADMAP
    	    });

    	    var infowindow = new google.maps.InfoWindow();

    	    var marker, i;

    	    for (i = 0; i < size; i++) {  
    	      marker = new google.maps.Marker({
    	        position: new google.maps.LatLng(resx[i],resy[i]),
    	        map: map
    	      });

    	      google.maps.event.addListener(marker, 'click', (function(marker, i) {
    	        return function() {
    	          //infowindow.setContent(locations[i][0]);
    	          infowindow.open(map, marker);
    	        }
    	      })(marker, i));
    	    }
    	}
         
      
   </script>
</body>

</html>