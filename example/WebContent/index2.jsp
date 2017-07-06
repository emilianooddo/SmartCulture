<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
</head>

<body >
<%
		
String nome = (String)request.getAttribute("nome");
String cognome = (String)request.getAttribute("cognome");
		
	%>
<h2>Cerca i tuoi luoghi di interesse</h2>
<h5>Benvenuto <%=nome%> <%=cognome%></h5>

<a href="Logout">Logout</a>|  
<a href="Profile">Profile</a>  
<form method="post" action="markerManager">
Città:<input type="text" name="citta" >
  <select name="tipo">
    <option value="monumento">Monumento</option>
    <option value="chiesa">Chiese Cattedrali</option>
    <option value="museo">Museo</option>
    </select>
  <br><br>
  <input type="submit"  value="Cerca">
</form>
   <div id="map" style="width: 800px; height: 650px; position: relative; top:0; overflow: hidden;"></div>
</body>
</html>