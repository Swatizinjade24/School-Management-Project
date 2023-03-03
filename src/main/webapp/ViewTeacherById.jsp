<%@page import="entity.Teacher"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Teacher By Id</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    int id1 = Integer.parseInt(id);
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("swati");
    EntityManager em = emf.createEntityManager();
    
    Teacher t = em.find(Teacher.class, id1);
    
    PrintWriter pw = response.getWriter();
    pw.write("Teacher Id:" +t.getId());
    pw.write("\t Teacher Teacher_Name:" +t.getT_name());
    pw.write("\t Teacher Subject:" +t.getSubject());
    pw.write("\t Teacher Salary:" +t.getSalary());
%>
<br><br><button type="Done"><a href="TeacherMenu.html">View Teacher By Id Successfully</a></button>
</body>
</html>