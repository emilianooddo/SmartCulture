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
		
		float[] coordinate_x = (float[])request.getAttribute("coordinate_x");
		float[] coordinate_y = (float[])request.getAttribute("coordinate_y");
		//int s = (int)request.getAttribute("s");
		int size = coordinate_x.length;
		int i;
		float x = coordinate_x[0];
		float y = coordinate_y[0];
		out.println(coordinate_x[0]);
		%>
		

<%
        %>

<h3>Risultati della ricerca:</h3>

<div id="map" style="width: 800px; height: 650px; position: relative; top:0; overflow: hidden;"></div>
<%
//for(i=0;i<size;i++)
   //out.println(coordinate_x[i]); 

//for( i=0;i<size;i++)
    //out.println(coordinate_y[i]); 
%>

   
   
   
<script type="text/javascript"async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAueas29SNrOG_NHvyesnZnZb-ktwfkkGg&callback=initMap"
  type="text/javascript"></script>
   <script type="text/javascript">
      function maps() {
    	  
    	  var x='<%=x%>';
    	  var y='<%=y%>';
    	  var latlng = new google.maps.LatLng(38.115016, 13.354877); // centro della mappa
          var myLatlng = new google.maps.LatLng(x,y); // segnapunto
         // definizione della mappa
         var myOptions = {
             zoom: 14,
             center: latlng,
            mapTypeId: google.maps.MapTypeId.MAPS,
            mapTypeControlOptions: {style: google.maps.MapTypeControlStyle.HORIZONTAL_BAR}
         }
         mymap = new google.maps.Map(document.getElementById("map"), myOptions);
         // definizione segnapunto
         var marker = new google.maps.Marker({
            position: myLatlng,
            map: mymap,
            title:"Il teatro Selinus si trova qui!"
         });
      }
   </script>
</body>

</html>