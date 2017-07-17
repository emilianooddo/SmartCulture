<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<link rel="stylesheet" href="css/homepage.css"  type="text/css">
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
		<li><a class="active" href="showNoticeBoard">HOME</a></li>
		<li><a href="profile.jsp">PROFILO</a></li>
		<li><a href="search.jsp">RICERCA</a></li>
		<li><a href="friends.jsp">AMICI</a></li>
		<li><a href="Logout">LOGOUT</a></li>
	</ul>
</div>

<body>
	<div id="container">
	<h2 align="center">Ultimi elementi aggiunti dai tuoi amici</h2><br>
<%
			String news = new String();
			String[] foto = (String[])request.getAttribute("foto");
			String[] nomi = (String[])request.getAttribute("nome");
			String[] cognomi = (String[])request.getAttribute("cognome");
			String[] luoghi = (String[])request.getAttribute("places");
			
			
			for(int i = 0; i <nomi.length;i++){
				%><img src=" <%=foto[i]%>" alt="Immagine" style= width:40px;height:40px;><%
				news = "    <b>&middot; " + nomi[i] + " " + cognomi[i] + "</b>"+ " ha aggiunto <b>" + luoghi[i] + "</b> tra i suoi preferiti.<br>";
				out.println(news);
			}
%>
  		
	</div>
</body>

</html>