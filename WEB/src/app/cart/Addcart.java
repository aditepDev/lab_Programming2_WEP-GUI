package app.cart;

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

import org.model.beans.Cart;
import org.model.beans.SupplierGoodModel;
import org.model.dao.SupplierGoodDAO;
import org.model.db.Database;

/**
 * Servlet implementation class Addcart
 */
@WebServlet("/Addcart.do")
public class Addcart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		try (PrintWriter out = response.getWriter()) {

			if (session.getAttribute("userId") != null) {
				int id = Integer.parseInt(request.getParameter("suppGoodID"));
				int price = Integer.parseInt(request.getParameter("suppGoodPrice"));
				int qty = Integer.parseInt(request.getParameter("qty"));

				String goodName = request.getParameter("goodName");
				System.out.println("id:" + id + ",Name: " + goodName + ",price" + price + ", qty" + qty + ", amount: "
						+ qty * price);

				Cart cart = new Cart();
				cart.setId(id);
				cart.setPrice(price);
				cart.setQty(qty);
				cart.setGoodName(goodName);

				if (session.getAttribute("cartList") == null) {
					// session ว่าง แอดชิ้น ที่ 1
					ArrayList<Cart> cartList = new ArrayList<>();
					cartList.add(cart);
					session.setAttribute("cartList", cartList);

				} else {
					// session มีแล้ว แอด ชิ้นที่ 2 3 4 5
					ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");
					cartList.add(cart);
					session.setAttribute("cartList", cartList);
				}
				System.out.println("====cart====");
				ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");
				for (Cart cart2 : cartList) {
					System.out.println(
							"id: " + cart2.getId() + ", price:" + cart2.getPrice() + ", qty:" + cart2.getQty());
				}
				System.out.println("===========");
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
