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

import entity.Principal;
@WebServlet("/principalaccount")
public class PrincipalServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String name  = req.getParameter("name");
	    String age = req.getParameter("age");
	    String mobile_no = req.getParameter("mobile_no");
	    String email = req.getParameter("email");
	    String password = req.getParameter("password");
	    
	    int age1 = Integer.parseInt(age);
	    long mobile_no1 = Long.parseLong(mobile_no);
	    
	    Principal p = new Principal();
	    p.setP_name(name);
	    p.setAge(age1);
	    p.setMobile_no(mobile_no1);
	    p.setEmail(email);
	    p.setPassword(password);
	    
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("swati");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	    
	    et.begin();
	    em.persist(p);
	    et.commit();
	    
	    PrintWriter pw = resp.getWriter();
	    pw.write("Account Created Successfully");
	    
	    RequestDispatcher rd = req.getRequestDispatcher("Login.html");
	    rd.include(req, resp);
	    resp.setContentType("text/html");
}
}
