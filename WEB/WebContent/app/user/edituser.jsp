<%@page import="org.model.beans.CustomerModel"%>
<%
	String path = request.getContextPath();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EDIT USER</title>
<hr />
	<jsp:include page="/app/menu/menu.jsp" />
	<hr />
</head>
<body>
	<div class="progress">
<div class="progress-bar bg-dark" role="progressbar" style="width: 80%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
  <div class="progress-bar bg-danger" role="progressbar" style="width: 20%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
  
</div>
<div class="container">	
	<%
		CustomerModel cusModal = (CustomerModel) request.getAttribute("cusModel");
	%>
	<h1>
  EDIT PROFILE
  <small class="text-muted">CUSTOMER</small>
</h1>
<br>
	<form action="<%=path%>/ConfirmEditUser.do" method="poth">

  <fieldset>
    <div class="form-group">
      <label for="exampleInputEmail1">CUSTOMER ID</label>
      <input type="text" name="customerId" class="form-control"  value = "<%=cusModal.getCustomerId()%>" placeholder="<%=cusModal.getCustomerId()%>" readonly="readonly">
    </div>  
      <div class="form-group">
      <label for="exampleInputEmail1">CUSTOMER NAME</label>
      <input type="text" name="customerName" class="form-control" value="<%=cusModal.getCusname()%>" placeholder="<%=cusModal.getCusname()%>" >
    </div>  
    <div class="form-group">
      <label for="exampleInputEmail1">ADDRESS</label>
      <input type="text" name="customerAddr" class="form-control" value="<%=cusModal.getAddress()%>" placeholder="<%=cusModal.getAddress()%>" >
    </div> 
     <div class="form-group">
      <label for="exampleInputEmail1">PHONE</label>
      <input type="text" name="customerPhone" class="form-control"  value="<%=cusModal.getPhone()%>" placeholder="<%=cusModal.getPhone()%>" >
    </div> 
    <div class="form-group">
      <label for="exampleInputEmail1">EMAIL</label>
      <input type="email" class="form-control" id="exampleInputEmail1" name= "customerEmail" value="<%=cusModal.getEmail()%>"  placeholder="<%=cusModal.getEmail()%>">
      <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>  
      <div class="form-group">
      <label for="exampleInputEmail1">USERNAME</label>
      <input type="text" name="customerUser" class="form-control"  value="<%=cusModal.getUsername()%>" placeholder="<%=cusModal.getUsername()%>" readonly="readonly">
    </div> 
     <div class="form-group">
      <label for="exampleInputEmail1">PASSWORD</label>
      <input type="text" name="customerPasswd" class="form-control" value="<%=cusModal.getPasswd()%>"  placeholder="<%=cusModal.getPasswd()%>" >
    </div> 
     <div class="form-group">
      <label for="exampleInputEmail1">REGISTER DATE</label>
      <input type="text" name="customerId" class="form-control" value="<%=cusModal.getTime_reg()%>"  placeholder="<%=cusModal.getTime_reg()%>" readonly="readonly">
    </div> 
    <input type="submit" value="EDIT"  class="btn btn-danger"><input
						type="hidden" name="customerId"
						value="<%=cusModal.getCustomerId()%>">
  </fieldset>

<table border="1"
			class="table table-striped table-hover table-bordered">
			<thead class="table table-striped table-hover table-bordered">
				<tr class="thead-dark">
					<th>CUSTOMER ID</th>
					<th>CUSTOMER NAME</th>
					<th>ADDRESS</th>
					<th>PHONE</th>
					<th>EMAIL</th>
					<th>USERNAME</th>
					<th>PASSWORD</th>
					<th>REGISTER DATE</th>
					<th>EDIT</th>
				</tr>
				<tr >
					<td><%=cusModal.getCustomerId()%></td>
					<td><%=cusModal.getCusname()%></td>
					<td><%=cusModal.getAddress()%></td>
					<td><%=cusModal.getPhone()%></td>
					<td><%=cusModal.getEmail()%></td>
					<td><%=cusModal.getUsername()%></td>
					<td><%=cusModal.getPasswd()%></td>
					<td><%=cusModal.getTime_reg()%></td>
					<td><input type="submit" value="EDIT" type="button" class="btn btn-danger"><input
						type="hidden" name="customerId"
						value="<%=cusModal.getCustomerId()%>"></td>

				</tr>
		</table>
</form>
</div>

</body>
</html>