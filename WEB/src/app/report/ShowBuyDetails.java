package app.report;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.model.beans.InvoiceDetailsModel;
import org.model.beans.InvoiceModel;
import org.model.beans.SupplierGoodModel;
import org.model.dao.InvoiceDAO;
import org.model.dao.InvoiceDetailsDAO;
import org.model.dao.SupplierGoodDAO;
import org.model.db.Database;

/**
 * Servlet implementation class ShowBuyDetails
 */
@WebServlet("/ShowBuyDetails.do")
public class ShowBuyDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		try (PrintWriter out = response.getWriter()) {

			if (session.getAttribute("userId") != null) {
				int id = Integer.parseInt(request.getParameter("id"));
				Database db = new Database();
				InvoiceDetailsDAO invDDAO = new InvoiceDetailsDAO(db);
				ArrayList<InvoiceDetailsModel> invDList = invDDAO.FindByInvDID(id);
				db.close();

				request.setAttribute("invDList", invDList);
				System.out.println("Buy Details:" + invDList.size());

				RequestDispatcher rd = request.getRequestDispatcher("/app/report/showbuydetails.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/Login.do");
			}

		} catch (Exception e) {
			e.getStackTrace();

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
