<%@page import="com.js.dto.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>LIST OF ALL BOOKS</h1>
<table border="2px soild red">
<tr>
<th>Bid </th>
<th>Bname</th>
<th>Bauthor</th>
<th>Bpage</th>
<th>Bpricel</th>
<th>Delete</th>
<th>UPDATE</th>
</tr>

<% ArrayList<Book> books =(ArrayList)request.getAttribute("data");
    for(Book b : books){
    %>
    <tr>
   <td><%= b.getBid() %></td> 
    <td><%= b.getBname() %></td> 
    <td><%= b.getBauthor() %></td> 
    <td><%= b.getBpage() %></td> 
    <td><%= b.getBpricel() %></td>
   <td><a href="delete?id=<%= b.getBid() %>">delete</a></td>
   <td><a href="update1?id=<%= b.getBid() %>">edit</a></td>
   </tr>
   <%} %>
</table>
<a href="welcome.html">HOME</a>
</body>
</html>