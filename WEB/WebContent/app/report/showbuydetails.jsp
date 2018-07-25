<%@page import="org.model.beans.InvoiceDetailsModel"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.model.beans.InvoiceModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SHOW BUY DETAILS</title>
	<hr />
	<jsp:include page="/app/menu/menu.jsp" />
	<hr />
</head>
<body>
<div class="progress">
<div class="progress-bar bg-dark" role="progressbar" style="width: 50%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
  <div class="progress-bar bg-danger" role="progressbar" style="width: 50%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
  
</div>	
<div class="container">
<h1>
  BUY DETAIL
  <small class="text-muted">INVOICE_ID = <%=request.getParameter("id")%> </small>
</h1>
	

	<table border="1"
		class="table table-striped table-hover table-bordered">
		<thead class="table table-striped table-hover table-bordered">
			<tr>

				<th>INVOICE_DETAILS_ID</th>
				<th>INVOICE_ID</th>
				<th>STATIONERIES</th>
				<th>SUPPLIERS</th>
				<th>QTY</th>
				<th>AMOUNT</th>
				<th>STATUS</th>
				<th>TIME_REG</th>

			</tr>
			</div>
		</thead>

		<tbody class="thead-dark">
			<%
				ArrayList<InvoiceDetailsModel> invDModel = (ArrayList<InvoiceDetailsModel>) request
						.getAttribute("invDList");

				for (Iterator<InvoiceDetailsModel> iterator = invDModel.iterator(); iterator.hasNext();) {
					InvoiceDetailsModel next = iterator.next();

					//INVOICE_DETAILS
					int invDID = next.getInvoice_deteils_id();
					int qty = next.getQty();
					int amount = next.getAmount();
					int status = next.getStatus();
					String time_reg = next.getTime_reg();

					//INVOICE
					int invID = next.getInvoice_id().getInvoice_id();
					String invDate = next.getInvoice_id().getInv_date();
					int invTotal = next.getInvoice_id().getTotal();
					int invStatus = next.getInvoice_id().getStatus();


					//STATIONERIES
					String stnName = next.getGoods_id().getGoods_name();
					String stnDes = next.getGoods_id().getDescript();
					String stnColor = next.getGoods_id().getColor();
					
					//SUPPLIERS
					String supName = next.getInvoice_id().getSuppliers_id().getName();
					String supAddr = next.getInvoice_id().getSuppliers_id().getAddress();
					String supPhone = next.getInvoice_id().getSuppliers_id().getPhone();
					String supEmail = next.getInvoice_id().getSuppliers_id().getEmail();
					
					
					int invStatuss = invStatus;
					String invStatussstring;
					if(invStatuss == 0){
						invStatussstring = "OUT OFF STOCK";
					}else{
							invStatussstring = "IN STOCK";
							}
					int statuss = status;
					String statusString;
					if(statuss == 0){
						statusString = "OUT OFF STOCK";
					}else{
						statusString = "IN STOCK";
							}
			%>
			<tr>

				<td><%=invDID%></td>
				<td>InvID = <%=invID%><br />Date = <%=invDate%><br />Total = <%=invTotal%><br />Status = <%=invStatussstring%><br /></td>
				<td>Name = <%=stnName%><br />Des = <%=stnDes%><br />Color = <%=stnColor%><br /></td>
				<td>Name = <%=supName%><br />address = <%=supAddr%><br />Phone
					= <%=supPhone%><br />Email = <%=supEmail%><br /></td>
				<td><%=qty%></td>
				<td><%=amount%></td>				
				<td><%=statusString%></td>
				<td><%=time_reg%></td>
			</tr>
			<%
				}
			%>



		</tbody>
	</table>
</div>
</body>
</html>