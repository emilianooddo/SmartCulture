<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Cerca amici</title>
<%
		//String coordinate_x = (String)request.getAttribute("coordinate_x");
		//String coordinate_y = (String)request.getAttribute("coordinate_y");
		
		String nickname = (String)request.getAttribute("nickname");
		String nome = (String)request.getAttribute("nome");
		String cognome = (String)request.getAttribute("cognome");
		
	%>
</head>
<body>

    <form id="myAjaxRequestForm" action="friendsManager">
        <fieldset>
            <legend>Cerca amici!</legend>

                <p>
                    <label >Nickname:</label><br />
                    <input id="fnick" type="text" name="friend_nick" />
                </p>
                <p>
                    <input type="button" id="ibutton" value="Cerca"/>
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
    var ajaxdata = $("#fnick").val();
    var value ='id='+ajaxdata;

    $.ajax({
    url: "friendsManager",
    type: "post",
    data: value,
    cache: false,
    success: function(data) {
    $("#id").val('');
    $("#ajaxResponse").html(data);
    $("#ajaxResponse").append(" <a id=\"add\" href="+"AddFriend"+">Aggiungi</a>");
    $('#add').click(function(e) {
        e.preventDefault();
        
        
        $.ajax({
            url: "addFriend",
            type: "post",
            data: value,
            cache: false,
            success: function(data) {
            $("#id").val('');
            $("#ajaxResponse").append("<br>"+data);
        
            }
        
        
        
        });
    });
    }
    
    
    
    
    
    });
});
});




	</script>

</body>
</html>


