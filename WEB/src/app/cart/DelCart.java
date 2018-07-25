package app.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.model.beans.Cart;

/**
 * Servlet implementation class DelCart
 */
@WebServlet("/DelCart.do")
public class DelCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		try (PrintWriter out = response.getWriter()) {

			if (session.getAttribute("userId") != null) {

				System.out.println("DEL CART =" + request.getParameter("index"));
				// get value from cart list in sell.jsp
				int index = Integer.parseInt(request.getParameter("index"));
				// get value from session name ("cartList")
				ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");
				// remove value from "cartList" ( ArrayList<Cart>)
				cartList.remove(index);

				if (cartList.size() <= 0) {
					session.setAttribute("cartList", null);
				}
				// set value "cartList" to session again
				session.setAttribute("cartList", cartList);

				response.sendRedirect(request.getContextPath() + "/Sell.do");

			} else {

				response.sendRedirect(request.getContextPath() + "/Login.do");
			}

		} catch (Exception e) {
			System.out.println("Addcart Error");

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
