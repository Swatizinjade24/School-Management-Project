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

import entity.Student;
import entity.Teacher;
@WebServlet("/deleteteacher")
public class DeleteTeacher extends HttpServlet {
	 @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	String id = req.getParameter("id");
	    	
	    	int id1 = Integer.parseInt(id);
	    	
	    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("swati");
	    	EntityManager em = emf.createEntityManager();
	    	EntityTransaction et = em.getTransaction();
	    	
	    	Teacher t = em.find(Teacher.class, id1);
	    	if(t!=null) {
	    		et.begin();
	    		em.remove(t);
	    		et.commit();
	    	}
	    	else {
	    		System.out.println("Invalid Data");
	    	}
	    	RequestDispatcher rd = req.getRequestDispatcher("DeleteTeacherSuccessfully.html");
	    	rd.include(req, resp);
	    }
}
