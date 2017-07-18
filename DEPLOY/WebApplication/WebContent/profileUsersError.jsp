<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<link rel="stylesheet" href="css/homepage.css"  type="text/css">
	<meta charset="ISO-8859-1">
	<link rel="shortcut icon" href="icon.png" type="image/png"/>
	<title>SmarTourist</title>
</head>

<%
session=request.getSession(false);
if (session != null) {

	if (session.getAttribute("name") == null) {
		response.sendRedirect("index.html");
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



<div id="bar">
	<div id="title">
		<h1>SmarTourist</h1>
	</div>
	<div id="image">
		<img src="logo.png" width="15%" height="15%">
	</div>
	<div id="searchfriends">
		<form method="get" action="ShowProfileUsers">
			<input type="text" name="searchfriends" placeholder="Trova Amici" value="">
			<input type="submit" value="Cerca">
		</form>
	</div>

	<div id="welcome">
		<h3>Benvenuto <%=(String) session.getAttribute("name")%> <%=(String) session.getAttribute("surname")%></h3>
	</div>
</div>

<div id="nav">
	<ul>
		<li><a class="active" href="showNoticeBoard">HOME</a></li>
		<li><a href="profile.jsp">PROFILO</a></li>
		<li><a href="search.jsp">RICERCA</a></li>
		<li><a href="friends.jsp">AMICI</a></li>
		<li><a href="Logout">LOGOUT</a></li>
		<li style=" margin-top: 12em; align: center; padding: 1em 0em 1em 1em;"><h6>Authors: &copy; Emiliano Oddo &nbsp; &nbsp; &nbsp; &nbsp; Giorgio Pitarresi</h6></li>
	</ul>
</div>

<body>
	<div id="container">
	<br><br>
	<h2 align="center">Nessun utente trovato con l'username inserito.</h2><br>
	<h3 align="center">Riprovare..</h3>	
	</div>
</body>

</html>