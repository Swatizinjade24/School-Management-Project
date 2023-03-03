<%@page import="java.io.PrintWriter"%>
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
<title>View Student By Id</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    int id1 = Integer.parseInt(id);
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("swati");
    EntityManager em = emf.createEntityManager();
    
    Student s = em.find(Student.class, id1);
    
    PrintWriter pw = response.getWriter();
    pw.write("Student Id:" +s.getId());
    pw.write("\t Student Student_Name:" +s.getS_name());
    pw.write("\t Student Stream:" +s.getStream());
    pw.write("\t Student Fees:" +s.getFees());
%>
<br><br><button type="Done"><a href="StudentMenu.html">View Student By Id Successfully</a></button>
</body>
</html>