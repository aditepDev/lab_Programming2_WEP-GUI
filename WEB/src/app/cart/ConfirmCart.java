package app.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.event.CaretListener;

import org.model.beans.Cart;
import org.model.beans.CustomerModel;
import org.model.beans.ReceiptDetailsModel;
import org.model.beans.ReceiptModel;
import org.model.beans.StationeriesModel;
import org.model.beans.SupplierGoodModel;
import org.model.dao.ReceiptDAO;
import org.model.dao.ReceiptDetailsDAO;
import org.model.dao.SupplierGoodDAO;
import org.model.db.Database;

/**
 * Servlet implementation class ConfirmCart
 */
@WebServlet("/ConfirmCart.do")
public class ConfirmCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		try (PrintWriter out = response.getWriter()) {
			
				if (session.getAttribute("userId") != null) {
					
					System.out.println("Confirm Cart!");
					ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");
					
					String Date = new SimpleDateFormat("dd-MM-YYYY").format(new Date());
					
					System.out.println("Date: "+Date);
					//Insert receipt herder
					Database db = new Database();				
					ReceiptDAO recDAO = new ReceiptDAO(db);
					//get customer from session
					int userID = Integer.parseInt(session.getAttribute("userId").toString());
					CustomerModel cusMode = new CustomerModel();
					cusMode.setCustomerId(userID);
					//Set value receipt model
					ReceiptModel recModel = new ReceiptModel();
					recModel.setRec_date(Date);
					recModel.setCustomer_id(cusMode);										
					recModel.setTotal(0);
					//Add receipt to receipt table
					int retID = recDAO.Add(recModel);
					System.out.println("Receipt ID:"+ retID);
					db.close();
					int total = 0;
					for (Iterator<Cart> iterator = cartList.iterator(); iterator.hasNext();) {											
						Cart next = iterator.next();
						
						int id = next.getId();
						int price = next.getPrice();
						int qty = next.getQty();
						int amount = qty * price;
						total = total + amount;
						
						//select supplier_good from key in cartList
						db = new Database();
						SupplierGoodDAO suppGDAO = new SupplierGoodDAO(db);
						SupplierGoodModel suppGModel = suppGDAO.FindByID(id);
						db.close();
						System.out.println("SUPPLIER_GOOD_ID: "+ suppGModel.getSupplire_good_id());
						
						
						//insert to RECEIPT_DETAILS
						db = new Database();
						ReceiptDetailsDAO recDDAO = new ReceiptDetailsDAO(db);
						
						//set value to Receipt Model
						recModel = new ReceiptModel();
						recModel.setReceipt_id(retID);
						//set value to STATIONERIES model
						StationeriesModel stnModel = new StationeriesModel();
						stnModel.setGoods_id(suppGModel.getGoods_id().getGoods_id());
						ReceiptDetailsModel recDModel = new ReceiptDetailsModel();						
						recDModel.setReceipt_id(recModel);
						recDModel.setGoods_id(stnModel);
						recDModel.setQty(qty);
						recDModel.setAmount(amount);
						
						int retCode = recDDAO.Add(recDModel);						
						db.close();
						//stock deduction
						db = new Database();
						suppGDAO = new SupplierGoodDAO(db);
						SupplierGoodModel suppGModelDeduct = new SupplierGoodModel();
						int deduct = suppGModel.getStockOty() - qty;
						suppGModelDeduct.setSupplire_good_id(suppGModel.getSupplire_good_id());
						suppGModelDeduct.setStockOty(deduct);						
						suppGDAO.UpdateQty(suppGModelDeduct);
						db.close();
						
					}
					//update receipt total
					db = new  Database();
					recDAO = new ReceiptDAO(db);
					recModel = new ReceiptModel();
					recModel.setReceipt_id(retID);
					recModel.setTotal(total);
					recDAO.UpdateTotal(recModel);
					db.close();
					
					//set session carList to null
					session.setAttribute("cartList", null);
					
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		processRequest(request, response);
	}

}
