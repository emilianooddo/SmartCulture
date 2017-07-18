<!DOCTYPE html>
<html>

<head>
	<link rel="stylesheet" href="css/profile.css"  type="text/css">
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
			<input type="text" name="username" placeholder="Trova Amici" value="">
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
		<li style=" margin-top: 12em; align: center; padding: 1em 0em 1em 1em;"><h6>Authors: &copy; Emiliano Oddo &nbsp; &nbsp; &nbsp; &nbsp; Giorgio Pitarresi</h6></li>
	</ul>
</div>

<body>
	<div id="container">
 	<%
 			String username = (String)request.getAttribute("username");	
 			String nome = (String)request.getAttribute("name");
			String cognome = (String)request.getAttribute("surname");
			String email =(String)request.getAttribute("email");	
			String data = (String)request.getAttribute("birth");
			String foto = (String)request.getAttribute("avatar");
	%>

		<h2><%=nome%> <%=cognome%></h2>
		<img src=" <%=foto%>" alt="Immagine" style= width:228px;height:228px;>
  		<h3>Data di nascita: <%=data%></h3>
  		<h3>Email: <%=email%></h3>
  		
  		<%
  			out.print("<a id=\"friend\" href="+"FriendListUsers?username="+username+">Lista amici</a>"+"<br>");
  			out.print("<a id=\"location\" href="+"LocationListUsers?username="+username+">Lista luoghi di interesse</a>"+"<br>");
  		%>
	
	</div>
</body>

</html>