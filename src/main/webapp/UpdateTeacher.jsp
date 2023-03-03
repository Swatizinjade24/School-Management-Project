<%@page import="entity.Teacher"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Teacher</title>
</head>
<body>
<%
     String id = request.getParameter("id");
     int id1 = Integer.parseInt(id);
     
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("swati");
     EntityManager em = emf.createEntityManager();
     
     Teacher t = em.find(Teacher.class, id1);
%>
<form action="UpdateTeacher" method="post">
Id:<input type="text" value="<%=t.getId() %>" name="id"><br><br>
Id:<input type="text" value="<%=t.getT_name() %>" name="t_name"><br><br>
Id:<input type="text" value="<%=t.getSubject() %>" name="subject"><br><br>
Id:<input type="text" value="<%=t.getSalary() %>" name="salary"><br><br>
<input type="Submit">
</form>
</body>
</html>