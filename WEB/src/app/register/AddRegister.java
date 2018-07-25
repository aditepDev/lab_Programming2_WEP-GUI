package app.register;

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
 * Servlet implementation class AddRegister
 */
@WebServlet("/AddRegister.do")
public class AddRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter out = response.getWriter()) {

			Database db = new Database();
			CustomerDAO cusDAO = new CustomerDAO(db);
			CustomerModel cusModel = new CustomerModel();
			cusModel.setCusname(request.getParameter("cus_name"));
			cusModel.setAddress(request.getParameter("addr"));
			cusModel.setPhone(request.getParameter("phone"));
			cusModel.setEmail(request.getParameter("email"));
			cusModel.setUsername(request.getParameter("username"));
			cusModel.setPasswd(request.getParameter("password"));
			int ret = cusDAO.Add(cusModel);
			db.commit();
			db.close();

			if (ret > -1) {
				request.setAttribute("ret_status", true);
			} else {
				request.setAttribute("ret_status", false);
			}

			RequestDispatcher rd = request.getRequestDispatcher("/app/register/addregister.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/app/register/addregister.jsp");
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
