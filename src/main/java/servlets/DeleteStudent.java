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

@WebServlet("/deletestudent")
public class DeleteStudent extends HttpServlet {
       @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String id = req.getParameter("id");
    	
    	int id1 = Integer.parseInt(id);
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("swati");
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();
    	
    	Student s = em.find(Student.class, id1);
    	if(s!=null) {
    		et.begin();
    		em.remove(s);
    		et.commit();
    	}
    	else {
    		System.out.println("Invalid Data");
    	}
    	RequestDispatcher rd = req.getRequestDispatcher("DeleteStudentSuccessfully.html");
    	rd.include(req, resp);
    }
}
