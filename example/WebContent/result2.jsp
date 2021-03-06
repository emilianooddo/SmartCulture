<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="jquery.js"></script>
<title>Esempio di una mappa con Google maps v3</title>
   <meta name="description" content="Un esempio di una mappa Google(tm) su una pagina HTML usando Google Maps v3, HTML5 e CSS3">
   <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
   

<title>Insert title here</title>
</head>
<body onload="maps()">

		<%

		String[] coordinate_x = (String[])request.getAttribute("coordinate_x");
		String[] coordinate_y = (String[])request.getAttribute("coordinate_y");
		String[] nomi = (String[])request.getAttribute("nomi");
		int size = coordinate_x.length;
		
		for (int i = 0; i < size; i++) {  
		String prova = nomi[i];
		}
	%>
		
		
<h3>Risultati della ricerca:</h3>


<div id="map" style="width: 1500px; height: 650px; position: relative; top:0; overflow: hidden;"></div>
<div id="elements"></div>

   
<script type="text/javascript" async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAueas29SNrOG_NHvyesnZnZb-ktwfkkGg&callback=initMap"
  type="text/javascript"></script>
   <script type="text/javascript">
   
      function maps() {
    	  
    	  var start ="";
    	 var size='<%=size%>';
    	  var X=[];  
    	  <%  
    	  for (int i=0; i < size; i++) {  
    	  %>  
    	  X[<%= i %>] = '<%=coordinate_x[i] %>';   
    	  <%}%> 
    	  
    	  var Y =[];  
    	  <%  
    	  for (int i=0; i < size; i++) {  
    	  %>  
    	  Y[<%= i %>] = '<%=coordinate_y[i] %>';   
    	  <%}%> 
    	  
    	  var nomi=[];
    	  
    	  <%  
    	  for (int i=0; i < size; i++) {  
    	  %>  
    	  nomi[<%= i %>] = '<%=nomi[i] %>';   
    	  <%}%> 
    	  
    	  var template ="";
    	  var desc =[];

    	var map = new google.maps.Map(document.getElementById('map'), {
    	      zoom: 12,
    	      center: new google.maps.LatLng(38.115016, 13.354877),
    	      mapTypeId: google.maps.MapTypeId.ROADMAP
    	    });
    	
    	
    	    var infowindow = new google.maps.InfoWindow();

    	    var marker,i;
			
			var xmlhttp = new XMLHttpRequest();
    		var url = "data.json";
    		
    		xmlhttp.onreadystatechange = function() {
    			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
    				var myArr = JSON.parse(xmlhttp.responseText);
    				desc=myFunction(myArr);
    				
    				
    		}
    		}
    		xmlhttp.open("GET", url, true);
    		xmlhttp.send();

    		
    		function myFunction(arr) {
    			var out = [];
    			var i,k;
    			var j=0;

    			for (i=0; i<arr.length; ++i) {
    				for(k =0; k<size;++k){
    				if(arr[i].x == X[k]){
    				out[j] = arr[i].desc;
    				j++;
    				}
    				
    			}}
    			return out;
    		}
    		
    			
    			for (i = 0; i < size; i++) {  
    	      marker = new google.maps.Marker({
    	        position: new google.maps.LatLng(X[i],Y[i]),
    	        map: map
    	      });

    	      
    	      
    	      
    	      google.maps.event.addListener(marker, 'click', (function(marker, i) {
    	        return function() {
    	          infowindow.setContent(desc[i]+ " <a id=\"add\" href="+"Add"+">Aggiungi</a>");
    	          infowindow.open(map, marker);
    	          $('#add').click(function(e) {
    	              e.preventDefault();
    	          var dataRequestObject= {};
    	          dataRequestObject= {lat:X[i],lng:Y[i]};
    	         	$.ajax({
  	        	    
  	        	    url: "defineElements",
  	        	    type: 'POST',
  	        	  	data: dataRequestObject
  	        	   });
    	          });
    	        }
    	      })(marker, i));
    	      
    	     
    	      template = template + nomi[i] + " <a href=\"#\" onclick="+"bookmark(this);\" value="+ nomi[i]+">Invia richiesta</a>" + "</br>";
    	      
    	      function bookmark(lnk)
    	      {
    	          alert(lnk.getAttribute('value'));
    	      }
    	      
    	      
    	    }
    			
    			document.getElementById("elements").innerHTML = template;
    			
    			
    			
    			
    	}
         
      
   </script>
   
</body>

</html>