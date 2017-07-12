<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> BACHECA</h2>


<%
String prova = new String();
String[] nomi = (String[])request.getAttribute("nome");
String[] cognomi = (String[])request.getAttribute("cognome");
String[] luoghi = (String[])request.getAttribute("places");

for(int i = 0; i <nomi.length;i++){
		prova = nomi[i] + "</br>" +
				cognomi[i] + "</br>"+
				luoghi[i] + "</br>";
	
}


%>

<%= prova %>


</body>
</html>