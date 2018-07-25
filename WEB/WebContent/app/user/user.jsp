<%@page import="org.model.beans.CustomerModel"%>
<%
	String path = request.getContextPath();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>USER</title>
<hr />
<jsp:include page="/app/menu/menu.jsp" />
<hr />
</head>
<body>
	<div class="progress">
		<div class="progress-bar bg-dark" role="progressbar"
			style="width: 80%;" aria-valuenow="25" aria-valuemin="0"
			aria-valuemax="100"></div>
		<div class="progress-bar bg-danger" role="progressbar"
			style="width: 20%;" aria-valuenow="25" aria-valuemin="0"
			aria-valuemax="100"></div>
	</div>

	<%
		CustomerModel cusModal = (CustomerModel) request.getAttribute("cusModel");
	%>
	<div class="container">
		<h1>
			PROFILE <small class="text-muted">CUSTOMER</small>
		</h1>
		<form action="<%=path%>/EditUser.do" method="poth"></form>

		<div class="alert alert-dismissible alert-success">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<h4>HEY!!</h4>
			You can edit profile.
		</div>
	</div>
	<div class="container">


		</h1>
		<br>
		<form action="<%=path%>/ConfirmEditUser.do" method="poth">

			<fieldset>
				<div class="form-group">
					<label for="exampleInputEmail1">CUSTOMER ID</label> <input
						type="text" name="customerId" class="form-control"
						value="<%=cusModal.getCustomerId()%>"
						placeholder="<%=cusModal.getCustomerId()%>" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">NAME</label> <input type="text"
						name="customerName" class="form-control"
						value="<%=cusModal.getCusname()%>"
						placeholder="<%=cusModal.getCusname()%>">
				</div>
				<div class="form-group">
					<label for="exampleSelect1">ADDRESS</label> <select
						class="form-control" id="exampleSelect1" name="customerAddr"
						type="text" value="<%=cusModal.getAddress()%>"
						placeholder="<%=cusModal.getAddress()%>" style="margin-top: 0px; margin-bottom: 0px; height: 33px;">
							<option><%=cusModal.getAddress()%></option>
							<option>Amnat Charoen</option>
							<option>Ang Thong</option>
							<option>Bangkok</option>
							<option>buogkan</option>
							<option>Buri Ram</option>
							<option>Chachoengsao</option>
							<option>Chai Nat</option>
							<option>Chaiyaphum</option>
							<option>Chanthaburi</option>
							<option>Chiang Mai</option>
							<option>Chiang Rai</option>
							<option>Chon Buri</option>
							<option>Chumphon</option>
							<option>Kalasin</option>
							<option>Kamphaeng Phet</option>
							<option>Kanchanaburi</option>
							<option>Khon Kaen</option>
							<option>Krabi</option>
							<option>Lampang</option>
							<option>Lamphun</option>
							<option>Loburi</option>
							<option>Loei</option>
							<option>Mae Hong Son</option>
							<option>Maha Sarakham</option>
							<option>Mukdahan</option>
							<option>Nakhon Nayok</option>
							<option>Nakhon Pathom</option>
							<option>Nakhon Phanom</option>
							<option>Nakhon Ratchasima</option>
							<option>Nakhon Sawan</option>
							<option>Nakhon Si Thammarat</option>
							<option>Nan</option>
							<option>Narathiwat</option>
							<option>Nong Bua Lam Phu</option>
							<option>Nong Khai</option>
							<option>Nonthaburi</option>
							<option>Pathum Thani</option>
							<option>Pattani</option>
							<option>Phangnga</option>
							<option>Phatthalung</option>
							<option>Phayao</option>
							<option>Phetchabun</option>
							<option>Phetchaburi</option>
							<option>Phichit</option>
							<option>Phitsanulok</option>
							<option>Phra Nakhon Si Ayutthaya</option>
							<option>Phrae</option>
							<option>Phuket</option>
							<option>Prachin Buri</option>
							<option>Prachuap Khiri Khan</option>
							<option>Ranong</option>
							<option>Ratchaburi</option>
							<option>Rayong</option>
							<option>Roi Et</option>
							<option>Sa Kaeo</option>
							<option>Sakon Nakhon</option>
							<option>Samut Prakan</option>
							<option>Samut Sakhon</option>
							<option>Samut Songkhram</option>
							<option>Saraburi</option>
							<option>Satun</option>
							<option>Si Sa Ket</option>
							<option>Sing Buri</option>
							<option>Songkhla</option>
							<option>Sukhothai</option>
							<option>Suphan Buri</option>
							<option>Surat Thani</option>
							<option>Surin</option>
							<option>Tak</option>
							<option>Trang</option>
							<option>Trat</option>
							<option>Ubon Ratchathani</option>
							<option>Udon Thani</option>
							<option>Uthai Thani</option>
							<option>Uttaradit</option>
							<option>Yala</option>
							<option>Yasothon</option>
						

					</select>
				</div>

				<div class="form-group">
					<label for="exampleInputEmail1">PHONE</label> <input type="text"
						name="customerPhone" class="form-control"
						value="<%=cusModal.getPhone()%>"
						placeholder="<%=cusModal.getPhone()%>">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">EMAIL</label> <input type="email"
						class="form-control" id="exampleInputEmail1" name="customerEmail"
						value="<%=cusModal.getEmail()%>"
						placeholder="<%=cusModal.getEmail()%>"> <small
						id="emailHelp" class="form-text text-muted">We'll never
						share your email with anyone else.</small>
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">USERNAME</label> <input type="text"
						name="customerUser" class="form-control"
						value="<%=cusModal.getUsername()%>"
						placeholder="<%=cusModal.getUsername()%>" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">PASSWORD</label> <input type="text"
						name="customerPasswd" class="form-control"
						value="<%=cusModal.getPasswd()%>"
						placeholder="<%=cusModal.getPasswd()%>">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">REGISTER DATE</label> <input
						type="text" name="customerId" class="form-control"
						value="<%=cusModal.getTime_reg()%>"
						placeholder="<%=cusModal.getTime_reg()%>" readonly="readonly">
				</div>
				<input type="submit" value="EDIT"
					class="btn btn-danger btn-lg btn-block"><input
					type="hidden" name="customerId">
			</fieldset>
		</form>
	</div>

</body>
</html>