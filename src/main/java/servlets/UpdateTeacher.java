package servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Teacher;
@WebServlet("/UpdateTeacher")
public class UpdateTeacher extends HttpServlet {
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String id = req.getParameter("id");
    	String t_name = req.getParameter("t_name");
    	String subject = req.getParameter("subject");
    	String salary = req.getParameter("salary");
    	
    	int id1 = Integer.parseInt(id);
    	int salary1 = Integer.parseInt(salary);
    	
    	Teacher t = new Teacher();
    	t.setId(id1);
    	t.setT_name(t_name);
    	t.setSubject(subject);
    	t.setSalary(salary1);
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("swati");
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();
    	
    	et.begin();
    	em.merge(t);
    	et.commit();
    	
    	resp.setContentType("text/html");
    	RequestDispatcher rd = req.getRequestDispatcher("UpdateTeacherDetailsSuccessfully.html");
    	rd.include(req, resp);
    	
    }
}

