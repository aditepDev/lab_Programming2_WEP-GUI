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

import org.model.beans.ReceiptDetailsModel;
import org.model.beans.SupplierGoodModel;
import org.model.dao.ReceiptDetailsDAO;
import org.model.dao.SupplierGoodDAO;
import org.model.db.Database;

/**
 * Servlet implementation class ShowSellDetails
 */
@WebServlet("/ShowSellDetails.do")
public class ShowSellDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		try (PrintWriter out = response.getWriter()) {

			if (session.getAttribute("userId") != null) {
				int id = Integer.parseInt(request.getParameter("id"));

				Database db = new Database();
				ReceiptDetailsDAO recDDAO = new ReceiptDetailsDAO(db);
				ArrayList<ReceiptDetailsModel> recDList = recDDAO.FindByReciptID(id);
				db.close();

				System.out.println("Sell Details:" + recDList.size());
				request.setAttribute("recDList", recDList);
				RequestDispatcher rd = request.getRequestDispatcher("/app/report/showselldetails.jsp");
				rd.forward(request, response);

			} else {
				response.sendRedirect(request.getContextPath() + "/Login.do");
			}
		} catch (Exception e) {
			System.out.println("Err");

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
