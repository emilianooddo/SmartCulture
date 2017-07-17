<!DOCTYPE html>
<html>

<head>
	<link rel="stylesheet" href="css/friends.css"  type="text/css">
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
		<li><a href="profile.jsp">PROFILO</a></li>
		<li><a href="search.jsp">RICERCA</a></li>
		<li><a class="active" href="friends.jsp">AMICI</a></li>
		<li><a href="Logout">LOGOUT</a></li>
	</ul>
</div>

<body>
	<div id="container">
  		<%
		//String coordinate_x = (String)request.getAttribute("coordinate_x");
		//String coordinate_y = (String)request.getAttribute("coordinate_y");
		
		String user = (String)request.getAttribute("user");
		String nome = (String)request.getAttribute("nome");
		String cognome = (String)request.getAttribute("cognome");
		
	%>

	<a href="ShowRequests">Richieste</a>&nbsp;&nbsp;<a href="FriendList">Lista Amici</a><br><br>


    <form id="myAjaxRequestForm" action="FriendsManager">
        <fieldset>
            <legend>Cerca amici</legend>

                <p>
                    <label>Username:</label><br />
                    <input id="usr" type="text" name="user_name" />
                </p>
                <p>
                    <input type="submit" id="ibutton" value="Cerca"/>
                </p>
        </fieldset>
    </form>
    <div id="anotherSection">
        <fieldset>
            <legend>Risultati</legend>
                 <div id="ajaxResponse"></div>
        </fieldset>
    </div>   

<script type="text/javascript" src="jquery-2.2.4.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $('#ibutton').click(function(e) {
    e.preventDefault();
    var ajaxdata = $("#usr").val();
    var value ='username='+ajaxdata;
   
    $.ajax({
    url: "FriendsManager",
    type: "post",
    data: value,
    cache: false,
    success: function(data) {
    $("#username").val('');
    $("#ajaxResponse").html(data);
    if(data!=false)	{
    $("#ajaxResponse").append(" <a id=\"add\" href="+"AddFriend"+">Invia richiesta</a>");
    }
    else	{
    	$("#ajaxResponse").html("<br>Nessun utente trovato!");
    }
    $('#add').click(function(e) {
        e.preventDefault();			//funziona
        
        
        $.ajax({
            url: "AddFriend",
            type: "post",
            data: value,
            cache: false,
            success: function(data) {
            $("#username").val('');
            $("#ajaxResponse").append("<br>"+data);
        
            }
        
        
        
        });
    });
    }
    
    });
});
});
	</script>
	</div>
</body>

</html>