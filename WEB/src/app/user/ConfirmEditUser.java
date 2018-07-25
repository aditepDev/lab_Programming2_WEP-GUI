package app.user;

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
 * Servlet implementation class ConfirmEditUser
 */
@WebServlet("/ConfirmEditUser.do")
public class ConfirmEditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		try (PrintWriter out = response.getWriter()) {

			if (session.getAttribute("username") != null) {
				Database db = new Database();
				CustomerDAO cusDAO = new CustomerDAO(db);
				int customerId = Integer.parseInt(request.getParameter("customerId").toString());

				String customerName = request.getParameter("customerName");
				String customerAddr = request.getParameter("customerAddr");
				String customerPhone = request.getParameter("customerPhone");
				String customerEmail = request.getParameter("customerEmail");
				String customerUser = request.getParameter("customerUser");
				String customerPasswd = request.getParameter("customerPasswd");

				CustomerModel cusModel = new CustomerModel();
				cusModel.setCustomerId(customerId);
				cusModel.setCusname(customerName);
				cusModel.setAddress(customerAddr);
				cusModel.setPhone(customerPhone);
				cusModel.setEmail(customerEmail);
				cusModel.setUsername(customerUser);
				cusModel.setPasswd(customerPasswd);

				cusDAO.Update(cusModel);
				db.commit();
				db.close();
				response.sendRedirect(request.getContextPath() + "/User.do");

				db.close();
			} else {
				response.sendRedirect(request.getContextPath() + "/Login.do");
			}
		} catch (Exception e) {
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
