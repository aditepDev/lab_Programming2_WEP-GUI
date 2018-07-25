/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

import org.model.beans.InvoiceModel;
import org.model.beans.ReceiptModel;
import org.model.beans.SupplierGoodModel;
import org.model.dao.InvoiceDAO;
import org.model.dao.ReceiptDAO;
import org.model.dao.SupplierGoodDAO;
import org.model.db.Database;

/**
 *
 * @author Aditep
 */
@WebServlet(name = "Report", urlPatterns = { "/Report.do" })
public class Report extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		try (PrintWriter out = response.getWriter()) {

			if (session.getAttribute("userId") != null) {

				// รายงานยอดการขาย
				Database db = new Database();
				ReceiptDAO recDAO = new ReceiptDAO(db);
				ArrayList<ReceiptModel> recList = recDAO.FindAll();
				db.close();
				request.setAttribute("recList", recList);
				// รายงานยอดคงเหลือ สินค้า
				db = new Database();
				SupplierGoodDAO suppGDAO = new SupplierGoodDAO(db);
				ArrayList<SupplierGoodModel> suppGList = suppGDAO.FindAll();
				db.close();
				request.setAttribute("suppGList", suppGList);
				// รายงานยอดกาสั่งซื้อ
				db = new Database();
				InvoiceDAO invDAO = new InvoiceDAO(db);
				ArrayList<InvoiceModel> invList = invDAO.FindAll();
				db.close();
				request.setAttribute("invList", invList);
				RequestDispatcher rd = request.getRequestDispatcher("/app/report/report.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/Login.do");
			}

		} catch (Exception e) {
		}

	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on
	// the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
