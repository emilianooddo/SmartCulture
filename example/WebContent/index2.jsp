<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
    <title>Home</title>

</head>

<body >
<%

session=request.getSession(false);
if (session != null) {
	if (session.getAttribute("nome") != null) {
		
		out.print("Hello, " + (String) session.getAttribute("nome") + (String)session.getAttribute("id") +"  Welcome ");
	} else {
		response.sendRedirect("SimpleLogin.html");
	}
}
%>
<%
response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control",
        "no-cache, no-store, must-revalidate, private, max-age=0");
response.setDateHeader("Expires", 0);
%>
<%@page session="true"%>
<h2>Cerca i tuoi luoghi di interesse</h2>


<a href="Logout">Logout</a>
<a href="Profile">Profile</a>  
<a href="Friends.jsp">AddFriend</a>
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