<%-- 
    Document   : sell
    Created on : Nov 21, 2017, 5:54:50 AM
    Author     : Aditep
--%>
<%@page import="org.model.beans.Cart"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.model.beans.SupplierGoodModel"%>
<%@page import="java.util.ArrayList"%>
<%
	String path = request.getContextPath();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SELL</title>
<hr />
	<jsp:include page="/app/menu/menu.jsp" />
	<hr />
</head>

<body>
  <div class="progress">
<div class="progress-bar bg-dark" role="progressbar" style="width: 40%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
  <div class="progress-bar bg-danger" role="progressbar" style="width: 60%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
  
</div> 
	<div class="container">
<h1>
  SELL
  <small class="text-muted">GOODS STATIONERRIES</small>
</h1>
<p class="lead"></p>

	<table border="1"
		class="table table-striped table-hover table-bordered">
		<thead class="table table-striped table-hover table-bordered">
			<tr>
				<th></th>
				<th>GOOD NAME</th>
				<th>GOOD DESCRIPT</th>
				<th>GOOD COLOR</th>
				<th>GOOD PRICE</th>
				<th>QTY</th>
				<th>SUPPLIER</th>
			</tr>
			</div>
		</thead>

		<tbody class="thead-dark">
			<%
				ArrayList<SupplierGoodModel> spgModel = (ArrayList<SupplierGoodModel>) request.getAttribute("sppgList");
				for (Iterator<SupplierGoodModel> iterator = spgModel.iterator(); iterator.hasNext();) {
					SupplierGoodModel next = iterator.next();
					
					String goodName = next.getGoods_id().getGoods_name();
					String goodDes = next.getGoods_id().getDescript();
					String goodColor = next.getGoods_id().getColor();
					
					int goodPrice = next.getPrice();
					String supp = next.getSupplier_id().getName();
					int suppGoodId = next.getSupplire_good_id();
			%>
			<form action="<%=path%>/Addcart.do" method="post">
				<tr>
					<td><div align="center">
							<input class="btn btn-info" type="submit" value="Add Cart">
						</div></td>
					<td><%=goodName%></td>
					<td><%=goodDes%></td>
					<td><%=goodColor%></td>
					<td><%=goodPrice%></td>
					<td><select name="qty">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
					</select></td>
					<td><%=supp%></td>

				</tr>
				<input type="hidden" value="<%=suppGoodId%>" name="suppGoodID" /> <input
					type="hidden" value="<%=goodPrice%>" name="suppGoodPrice" /> <input
					type="hidden" value="<%=goodName%>" name="goodName" />
			</form>
			<%
				}
			%>



		</tbody>
	</table>
	<hr />
</div>
	<% if (session.getAttribute("cartList") != null) { %>
	<div class="container">
	<h1>
 CART
  <small class="text-muted">LIST</small>
</h1>
	
		<table border="1"
			class="table table-striped table-hover table-bordered">
			<thead class="table table-striped table-hover table-bordered">
				<tr>
					<th>CART ID#</th>
					<th>GOOD ID</th>
					<th>GOOD Name</th>
					<th>GOOD PRICE</th>
					<th>GOOD QTY</th>
					<th>AMOUNT</th>
					<th>DELETE</th>
				</tr>
			</thead>

			<tbody class="thead-dark">
				<%
					
						ArrayList<Cart> cart = (ArrayList<Cart>) session.getAttribute("cartList");
						int index = 0;
						for (Iterator<Cart> iterator = cart.iterator(); iterator.hasNext(); index++) {
							Cart next = iterator.next();
							int id = next.getId();
							int price = next.getPrice();
							int qty = next.getQty();
							int amount = qty * price;
							String goodName = next.getGoodName();
							int CartID = index + 1;
				%>
				<form action="<%=path%>/DelCart.do" method="post">
					<tr>
						<td><%=CartID%>#</td>
						<td><%=id%></td>
						<td><%=goodName%></td>
						<td><%=price%></td>
						<td><%=qty%></td>
						<td><%=amount%></td>
						<td><input type="submit" value="Delete"
							class="btn btn-danger"></td>

					</tr>
					<input type="hidden" value="<%=index%>" name="index">

				</form>
				<%
					}
						%>
						<Form action="<%=path%>/ConfirmCart.do" method="post">
						<tr>						
						<td colspan="7"><input type="submit" value="Confirm Cart" class="btn btn-secondary"></td>
						</tr>
						</Form>
						<%
						
						
					}
				%>



			</tbody>
		</table>
	</div>
</body>
</html>
