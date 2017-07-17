<!DOCTYPE html>
<html>

<head>
	<link rel="stylesheet" href="css/profile.css"  type="text/css">
	<meta charset="ISO-8859-1">
	<title>SmarTourist</title>
</head>

<%
session=request.getSession(false);
if (session != null) {
//	if (session.getAttribute("name") != null) {
	//	out.print("Hello, " + (String) session.getAttribute("name") + "  Welcome ");
//	} else {
	//	response.sendRedirect("index.html");
//	}
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
		<li><a class="active" href="profile.jsp">PROFILO</a></li>
		<li><a href="search.jsp">RICERCA</a></li>
		<li><a href="friends.jsp">AMICI</a></li>
		<li><a href="Logout">LOGOUT</a></li>
	</ul>
</div>

<body>
	<div id="container">
 	<%
		
		String foto = (String)session.getAttribute("avatar");
	%>

		<h2><%=(String) session.getAttribute("name")%> <%=(String) session.getAttribute("surname")%></h2>
 		
		
		<img src=" <%=foto%>" alt="Immagine" style= width:228px;height:228px;>
  		<h4>Data di nascita: <%=(String) session.getAttribute("birth")%></h4>
  		<h4>Email: <%=(String) session.getAttribute("email")%></h4>
  		<a href="modifyProfile.jsp">Modifica Profilo</a>
  		<a href="FriendList">Lista amici</a>
  		<a href="LocationList">Lista luoghi di interesse</a>
  		
	</div>
</body>

</html>