<!DOCTYPE html>
<html>

<head>
	<link rel="stylesheet" href="css/guest.css"  type="text/css">
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
	<script type="text/javascript" src="jquery.js"></script>
	<title>SmarTourist</title>
</head>


<div id="bar">
<div id="title"><h1>SmarTourist</h1></div>
<div id="image"><img src="logo.png" width="15%" height="15%"></div>
<div id="welcome"><h3>Benvenuto Ospite!</h3></div>
</div>


<body onload="maps()">
<div id="container" >

		<%
		//String coordinate_x = (String)request.getAttribute("coordinate_x");
		//String coordinate_y = (String)request.getAttribute("coordinate_y");
		
		String[] coordinate_x = (String[])request.getAttribute("coordinate_x");
		String[] coordinate_y = (String[])request.getAttribute("coordinate_y");
		int size = coordinate_x.length;
	%>
		
		
<h3>Risultati della ricerca:</h3>

<div id="map" style="width: 100%; height: 40%; position: relative; top:0; overflow: hidden; z-index: 0"></div>

   
<script type="text/javascript" async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAueas29SNrOG_NHvyesnZnZb-ktwfkkGg&callback=initMap"
  type="text/javascript"></script>
   <script type="text/javascript">
   
      function maps() {
    	  
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
		  var names=[];
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
    	          infowindow.setContent(desc[i]);
    	          infowindow.open(map, marker);
    	        }
    	      })(marker, i));
    	      
    	     
    	    } 
    	}
         
      
   </script>
   
</div>
</body>
</html>