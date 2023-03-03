package servlets;

import java.io.IOException;
import java.io.PrintWriter;

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

import entity.Student;

@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
      @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String id = req.getParameter("id");
    	String s_name = req.getParameter("s_name");
    	String stream = req.getParameter("stream");
    	String fees = req.getParameter("fees");
    	
    	int id1 = Integer.parseInt(id);
    	int fees1 = Integer.parseInt(fees);
    	
    	Student s = new Student();
    	s.setId(id1);
    	s.setS_name(s_name);
    	s.setStream(stream);
    	s.setFees(fees1);
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("swati");
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();
    	
    	et.begin();
    	em.merge(s);
    	et.commit();
    	
    	resp.setContentType("text/html");
    	RequestDispatcher rd = req.getRequestDispatcher("UpdateStudentDetailsSuccessfully.html");
    	rd.include(req, resp);
    	
    }
}