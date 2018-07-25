package app.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.model.beans.CustomerModel;
import org.model.dao.CustomerDAO;
import org.model.db.Database;

/**
 * Servlet implementation class ChkLogin
 */
@WebServlet("/ChkLogin.do")
public class ChkLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		try (PrintWriter out = response.getWriter()) {

			Database db = new Database();
			CustomerDAO cusDAO = new CustomerDAO(db);
			CustomerModel cusModel = cusDAO.FindLogin(request.getParameter("username"),
					request.getParameter("password"));
			db.close();

			if (cusModel.getCusname() != null) {
				System.out.println(cusModel.getCusname());
				session.setAttribute("userId", cusModel.getCustomerId());
				session.setAttribute("username", cusModel.getCusname());
				session.setAttribute("useremail", cusModel.getEmail());
				session.setAttribute("STATUS", cusModel.getSTATUS());

				response.sendRedirect(request.getContextPath() + "/Home.do");
			} else {
				response.sendRedirect(request.getContextPath() + "/Login.do");
			}
			// RequestDispatcher rd =
			// request.getRequestDispatcher("/app/login/chklogin.jsp");
			// rd.forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		processRequest(request, response);
	}

}
