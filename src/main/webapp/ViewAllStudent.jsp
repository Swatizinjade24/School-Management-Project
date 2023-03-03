<%@page import="entity.Student"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Student</title>
</head>
<body>
<%
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("swati");
     EntityManager em = emf.createEntityManager();
     
     Query q = em.createQuery("select a from Student a");
     List<Student> s = q.getResultList(); 
%>
<table cellpadding="20px" border="1">
<th>Id</th>
<th>Student Name</th>
<th>Stream</th>
<th>Fees</th>
<%  for(Student s1:s){ %>
    <tr align="center"></tr>
    <td> <%=s1.getId() %></td>
    <td> <%=s1.getS_name() %></td>
    <td> <%=s1.getStream() %></td>
    <td> <%=s1.getFees() %></td>
<% } %>    
</table><br>
<button type="Done"><a href="StudentMenu.html">View All Student Successfully</a></button>
</body>
</html>