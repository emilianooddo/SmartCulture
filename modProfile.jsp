<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control",
        "no-cache, no-store, must-revalidate, private, max-age=0");
response.setDateHeader("Expires", 0);
%>
<%@page session="true"%>
<h2>Modifica Profilo</h2>
 <form ENCTYPE="multipart/form-data" action="ModProfile">
  <input type="file" name="foto" accept="image/*">
  <input type="text" placeholder="Nome" name="nome" required>
  <input type="text" placeholder="Cognome" name="cognome" required>
  <input type="submit">
</form> 
</body>
</html>