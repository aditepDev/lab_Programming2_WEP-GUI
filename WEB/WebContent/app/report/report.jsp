<%-- 
    Document   : report
    Created on : Nov 21, 2017, 5:54:40 AM
    Author     : Aditep
--%>
<%@page import="org.model.beans.StationeriesModel"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.model.beans.InvoiceModel"%>
<%@page import="org.model.beans.SupplierGoodModel"%>
<%@page import="org.model.beans.ReceiptModel"%>
<%@page import="java.util.ArrayList"%>

<%
	String path = request.getContextPath();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>REPORT</title>
<hr />
<jsp:include page="/app/menu/menu.jsp" />
<hr />
</head>
<body>

	<div class="progress">
		<div class="progress-bar bg-dark" role="progressbar"
			style="width: 60%;" aria-valuenow="25" aria-valuemin="0"
			aria-valuemax="100"></div>
		<div class="progress-bar bg-danger" role="progressbar"
			style="width: 40%;" aria-valuenow="25" aria-valuemin="0"
			aria-valuemax="100"></div>
	</div>
	<div class="container">
		<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link active"
				data-toggle="tab" href="#SELL">SELL</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="tab"
				href="#BUY">BUY</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="tab"
				href="#STOCK">STOCK</a></li>
		</ul>
	</div>
	<div id="myTabContent" class="tab-content">

		<!-- ==================== sell report  ================ -->

		<div class="tab-pane fade in active show" id="SELL">
			<div class="container">
				<br> <br>
				<h1>
					SELL <small class="text-muted">REPORT</small>
				</h1>
				<!-- DataTable Plugin -->
				<script src="${js}/jquery.dataTables.js"></script>
				<script type="text/javascript">
					$(document).ready(function() {
						$("#selldatatavle").dataTable({
							"sPaginationType" : "full_numbers",
							"bJQueryUI" : true
						});
					});
				</script>
				<table border="1"
					class="table table-striped table-hover table-bordered"
					id="selldatatavle">
					<thead class="table table-striped table-hover table-bordered">
						<tr class="table-active">
							<th>RECEIPT_ID</th>
							<th>REC_DATE</th>
							<th>CUSTOMER</th>
							<th>TOTAL</th>
							<th>TIME_REG</th>
							<th>DETAIL OF RECEIPT_ID</th>
						</tr>
					</thead>

					<tbody class="thead-dark">
						<%
							ArrayList<ReceiptModel> recList = (ArrayList<ReceiptModel>) request.getAttribute("recList");

							if (recList != null) {

								for (Iterator<ReceiptModel> iterator = recList.iterator(); iterator.hasNext();) {
									ReceiptModel next = iterator.next();
									//Recript
									int recID = next.getReceipt_id();
									String recDate = next.getRec_date();
									int totol = next.getTotal();
									String time_reg = next.getTime_reg();

									//customer
									String cusName = next.getCustomer_id().getCusname();
									String cusAddr = next.getCustomer_id().getAddress();
									String cusPhone = next.getCustomer_id().getPhone();
									String cusEmail = next.getCustomer_id().getEmail();
						%>
						<tr>
							<td><%=recID%></td>
							<td><%=recDate%></td>
							<td>
								<h5>
									Name :
									</h><%=cusName%><br />
									<h5>
										Address :
										</h><%=cusAddr%><br />
										<h5>
											Phone :
											</h><%=cusPhone%><br />
											<h5>
												Email :
												</h><%=cusEmail%><br />
							</td>
							<td><%=totol%></td>
							<td><%=time_reg%></td>
							<td><li class="nav-item"><a
									href="<%=path%>/ShowSellDetails.do?id=<%=recID%>"><span class="badge badge-danger">DETAIL</span></a></li></td>




						</tr>


						<%
							}
						%>


						<%
							}
						%>

					</tbody>
				</table>
			</div>
		</div>


		<!--===============================BUY=================================-->

		<div class="tab-pane fade" id="BUY">
			<div class="container">
				<br> <br>
				<h1>
					BUY <small class="text-muted">REPORT</small>
				</h1>
				<table border="1"
					class="table table-striped table-hover table-bordered">
					<thead class="table table-striped table-hover table-bordered">
						<tr class="table-active">
							<th>INVOICE_ID</th>
							<th>SUPPLIERS</th>
							<th>INV_DATE</th>
							<th>TOTAL</th>
							<th>STATUS</th>
							<th>TIME_REG</th>
							<th>DETAIL OF INVOICE_ID</th>
						</tr>
					</thead>

					<tbody class="thead-dark">
						<%
							ArrayList<InvoiceModel> invList = (ArrayList<InvoiceModel>) request.getAttribute("invList");

							if (invList != null) {

								for (Iterator<InvoiceModel> iterator = invList.iterator(); iterator.hasNext();) {
									InvoiceModel next = iterator.next();
									//INVOICE
									int invID = next.getInvoice_id();
									String invDate = next.getInv_date();
									int invTotol = next.getTotal();
									int invStatus = next.getStatus();
									String invTime_reg = next.getTime_reg();

									//SUPPLIERS

									String supName = next.getSuppliers_id().getName();
									String supAddr = next.getSuppliers_id().getAddress();
									String supPhone = next.getSuppliers_id().getPhone();
									String supEmail = next.getSuppliers_id().getEmail();

									int invStatuss = invStatus;
									String invStatussstring;
									if (invStatuss == 0) {
										invStatussstring = "OUT OFF STOCK";
									} else {
										invStatussstring = "IN STOCK";
									}
						%>



						<tr>
							<td><%=invID%></td>

							<td>
								<h5>
									Name :
									</h><%=supName%><br />
									<h5>
										Address :
										</h><%=supAddr%><br />
										<h5>
											Phone :
											</h><%=supPhone%><br />
											<h5>
												Email :
												</h><%=supEmail%><br />
							</td>
							<td><%=invDate%></td>
							<td><%=invTotol%></td>
							<td><%=invStatussstring%></td>
							<td><%=invTime_reg%></td>
							<td><li class="nav-item"><a
									href="<%=path%>/ShowBuyDetails.do?id=<%=invID%>"><span class="badge badge-danger">DETAIL</span></a></li></td>
						</tr>


						<%
							}
						%>

						<%
							}
						%>



					</tbody>
				</table>
			</div>
		</div>
		</from>

		<!-- ==================================STOCK================================= -->

		<div class="tab-pane fade" id="STOCK">
			<div class="container">
				<br> <br>
				<h1>
					STOCK <small class="text-muted">REPORT</small>
				</h1>

				<table border="1"
					class="table table-striped table-hover table-bordered">
					<thead class="table table-striped table-hover table-bordered">
						<tr class="table-active">
							<th>SUPPLIER_GOOD_ID</th>
							<th>SUPPLIER</th>
							<th>STATIONERIES</th>
							<th>PRICE</th>
							<th>STOCK_QTY</th>
						</tr>
					</thead>

					<tbody class="thead-dark">
						<%
							ArrayList<SupplierGoodModel> suppGList = (ArrayList<SupplierGoodModel>) request.getAttribute("suppGList");

							if (suppGList != null) {

								for (Iterator<SupplierGoodModel> iterator = suppGList.iterator(); iterator.hasNext();) {
									SupplierGoodModel next = iterator.next();

									//SUPPLIER_GOOD
									int suppGID = next.getSupplire_good_id();
									int suppprice = next.getPrice();
									int suppQty = next.getStockOty();

									//SUPPLIERS
									String supName = next.getSupplier_id().getName();
									String supAddr = next.getSupplier_id().getAddress();
									String supPhone = next.getSupplier_id().getPhone();
									String supEmail = next.getSupplier_id().getEmail();

									//Stationeries
									String Spgname = next.getGoods_id().getGoods_name();
									String spgDes = next.getGoods_id().getDescript();
									String spgcolor = next.getGoods_id().getColor();
						%>
						<form action="<%=path%>/DelCart.do" method="post">
							<tr>
								<td><%=suppGID%></td>
								</div>
								<td>
									<h5>
										Name :
										</h><%=supName%><br />
										<h5>
											Address :
											</h><%=supAddr%><br />
											<h5>
												Phone :
												</h><%=supPhone%><br />
												<h5>
													Email :
													</h><%=supEmail%><br />
								</td>
								<td><h5>
										Name :
										</h><%=Spgname%><br />
										<h5>
											DESCRIPT :
											</h><%=spgDes%><br />
											<h5>
												COLOR :
												</h><%=spgcolor%><br /></td>
								<td><%=suppprice%></td>
								<td><%=suppQty%></td>

							</tr>

						</form>
						<%
							}
						%>

						<%
							}
						%>

					</tbody>
				</table>

				</hr>
			</div>
		</div>
	</div>




</body>
</html>
