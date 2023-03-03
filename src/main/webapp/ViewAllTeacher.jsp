<%@page import="entity.Teacher"%>
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
<title>View All Teacher</title>
</head>
<body>
<%
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("swati");
     EntityManager em = emf.createEntityManager();
     
     Query q = em.createQuery("select a from Teacher a");
     List<Teacher> t = q.getResultList(); 
%>
<table cellpadding="20px" border="1">
<th>Id</th>
<th>Teacher Name</th>
<th>Subject</th>
<th>Salary</th>
<%  for(Teacher t1:t){ %>
    <tr align="center"></tr>
    <td> <%=t1.getId() %></td>
    <td> <%=t1.getT_name() %></td>
    <td> <%=t1.getSubject() %></td>
    <td> <%=t1.getSalary() %></td>
<% } %>    
</table><br>
<button type="Done"><a href="TeacherMenu.html">View All Teacher Successfully</a></button>
</body>
</html>