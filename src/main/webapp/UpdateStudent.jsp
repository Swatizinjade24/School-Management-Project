<%@page import="entity.Student"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student</title>
</head>
<body>
<%
     String id = request.getParameter("id");
     int id1 = Integer.parseInt(id);
     
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("swati");
     EntityManager em = emf.createEntityManager();
     
     Student s = em.find(Student.class, id1);
%>
<form action="UpdateStudent" method="post">
Id:<input type="text" value="<%=s.getId() %>" name="id"><br><br>
Id:<input type="text" value="<%=s.getS_name() %>" name="s_name"><br><br>
Id:<input type="text" value="<%=s.getStream() %>" name="stream"><br><br>
Id:<input type="text" value="<%=s.getFees() %>" name="fees"><br><br>
<input type="Submit">
</form>
</body>
</html>