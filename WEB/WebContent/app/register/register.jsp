<%-- 
    Document   : newjspregister
    Created on : Nov 21, 2017, 3:25:14 PM
    Author     : Aditep
--%>
<%
	String path = request.getContextPath();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<hr />
	<jsp:include page="/app/menu/menu.jsp" />
	<hr />
</head>
<div >
<body>
	<div class="progress">
<div class="progress-bar bg-dark" role="progressbar" style="width: 80%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
  <div class="progress-bar bg-danger" role="progressbar" style="width: 20%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
  
</div>
	
	
	<div  class="form-group" class="container" align="center">
	<form action="<%=path%>/AddRegister.do" method="post"><h5>NAME</h5><input type="text" name="cus_name" class="form-control" placeholder="Mr.customer" style="margin-top: 0px; margin-bottom: 0px; height: 33px; width: 450px;">
		<h5>ADDRESS</h5>  <select
						class="form-control" id="exampleSelect1" name="addr" style="margin-top: 0px; margin-bottom: 0px; height: 33px; width: 450px" >
							<option></option>
							<option>Amnat Charoen</option>
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
				
			<h5>PHONE</h5> <input type="text" name="phone" class="form-control" placeholder="080-xxxxxxx" style="margin-top: 0px; margin-bottom: 0px; height: 33px; width: 450px;">
		<h5>EMAIL</h5> <input type="text" name="email" class="form-control" placeholder="emailuser@msu.com" style="margin-top: 0px; margin-bottom: 0px; height: 33px; width: 450px;">
		<h5>USERNAME</h5> <input type="text" name="username" class="form-control" placeholder="root" style="margin-top: 0px; margin-bottom: 0px; height: 33px; width: 450px;">
		<h5>PASSWORD</h5> <input type="password" name="password" class="form-control" placeholder="1234" style="margin-top: 0px; margin-bottom: 0px; height: 33px; width: 450px;">
		<br> <input class= "btn btn-secondary" type="submit" name="SUBMIT" value="SUBMIT" > |
		<input  class="btn btn-danger" type="reset" value="RESET">
	</form>
</div>


</body>
</div>
</html>
