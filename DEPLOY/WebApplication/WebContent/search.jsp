<!DOCTYPE html>
<html>

<head>
	<link rel="stylesheet" href="css/search.css"  type="text/css">
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
		<li><a href="showNoticeBoard">HOME</a></li>
		<li><a href="profile.jsp">PROFILO</a></li>
		<li><a class="active" href="search.jsp">RICERCA</a></li>
		<li><a href="friends.jsp">AMICI</a></li>
		<li><a href="Logout">LOGOUT</a></li>
		<li style=" margin-top: 12em; align: center; padding: 1em 0em 1em 1em;"><h6>Authors: &copy; Emiliano Oddo &nbsp; &nbsp; &nbsp; &nbsp; Giorgio Pitarresi</h6></li>
	</ul>
</div>

<body>
<div id="container">
	<h2>Cerca i tuoi luoghi di interesse</h2>
	<form method="post" action="MarkerManager">
		Città:<input type="text" name="citta" >
  		<select name="tipo">
    		<option value="monumento">Monumento</option>
    		<option value="chiesa">Chiese Cattedrali</option>
    		<option value="museo">Museo</option>
    	</select>
  		<br><br>
  		<input type="submit"  value="Cerca">
	</form>
	<div id="map" style="width: 100%; height: 40%; top:0;"></div>
</div>
</body>
</html>