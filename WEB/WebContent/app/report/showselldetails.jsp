<%@page import="java.util.Iterator"%>
<%@page import="org.model.beans.ReceiptDetailsModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<hr />
	<jsp:include page="/app/menu/menu.jsp" />
	<hr />
<title>SHOW SELL DETAILS</title>
</head>
<body>	
	
<div class="progress">
<div class="progress-bar bg-dark" role="progressbar" style="width: 50%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
  <div class="progress-bar bg-danger" role="progressbar" style="width: 50%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
</div>
<div class="container">
<h1>
  SELL DETAIL
  <small class="text-muted">RECEIPT_ID = <%=request.getParameter("id")%> </small>
</h1>
	<table border="1"
		class="table table-striped table-hover table-bordered">
		<thead class="table table-striped table-hover table-bordered">
			<tr>

				<th>RECEIPT_DET_ID</th>
				<th>RECEIPT_ID</th>
				<th>GOODS_ID</th>
				<th>CUSTOMER</th>
				<th>QTY</th>
				<th>AMOUNT</th>
				<th>TIME_REG</th>
			</tr>
			</div>
		</thead>

		<tbody class="thead-dark">
			<%
				ArrayList<ReceiptDetailsModel> recDModel = (ArrayList<ReceiptDetailsModel>) request.getAttribute("recDList");
			
				for (Iterator<ReceiptDetailsModel> iterator = recDModel.iterator(); iterator.hasNext();) {
					ReceiptDetailsModel next = iterator.next();

					//RECEIPT_DETAILS
					int recDID = next.getReceipt_det_id();
					int qty = next.getQty();
					int amount = next.getAmount();
					String time_reg = next.getTime_reg();

					//STATIONERIES
					String stnName = next.getGoods_id().getGoods_name();
					String stnDes = next.getGoods_id().getDescript();
					String stnColor = next.getGoods_id().getColor();

					//RECEIPT
					int recID = next.getReceipt_id().getReceipt_id();
					String recDate = next.getReceipt_id().getRec_date();
					int recTotal = next.getReceipt_id().getTotal();

					//CUSTOMER

					String cusName = next.getReceipt_id().getCustomer_id().getCusname();
					String cusAddr = next.getReceipt_id().getCustomer_id().getAddress();
					String cusPhone = next.getReceipt_id().getCustomer_id().getPhone();
					String cusEmail = next.getReceipt_id().getCustomer_id().getEmail(); 
			%>
			<tr>
				
				<td><%=recDID%></td>
				<td>recID = <%=recID%><br /> Date = <%=recDate%><br /> Total = <%=recTotal%><br /></td>
				<td>Name = <%=stnName%><br />Des = <%=stnDes%><br />Color = <%=stnColor%><br /></td>
				<td>Name = <%=cusName%><br />address = <%=cusAddr%><br />Phone = <%=cusPhone%><br />Email = <%=cusEmail%><br /></td>
				<td><%=qty%></td>
				<td><%=amount%></td>
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