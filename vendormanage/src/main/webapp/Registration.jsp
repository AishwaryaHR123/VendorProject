<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>x-workz</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
		<h5 class="text-white h4">X-workz</h5>

		<nav aria-label="breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a class="btn btn-primary"
					href="index.jsp" role="button">Home</a></li>
				
			</ol>
		</nav>
	</nav>
	<h3>Vendor Form!!</h3>
	

	<span style="color:red">
		<c:forEach var="objectErrors" items="${error}">
			${objectErrors.defaultMessage}<br>
		</c:forEach>
	</span>
	 <span style="color:red"><h3>${uniqueError}</h3></span>	
	  
	<form action="laptop" method="post" class="p-3 mb-2 bg-secondary text-white" >
		 <div class="row">
       <div class="col">
     VendorName: <input type="text" class="form-control" placeholder="VendorName" aria-label="Vendor name" name="vendorName" value="${dto.getVendorName()}" >
    </div>
  <div class="col">
    Location:<input type="text" class="form-control" placeholder="Location" aria-label="Location" name="location" value="${dto.getLocation()}">
  </div>
  </div><br>
 <div class="row">
  <div class="col">
   CompanyStartDate:<input type="date" class="form-control" placeholder="CompanyStartDate" aria-label="CompanyStartDate" name="companyStartDate" value="${dto.getCompanyStartDate()}">
  </div>
  <div class="col">
   GstNo: <input type="text" class="form-control" placeholder="GstNo" aria-label="GstNo" name="gstNo" value="${dto.getGstNo()}" id="gstNo" onchange="onGstNo()">
   	 <span id="gstError" style="color:red"></span>
  </div>
 </div><br>
 <div class="row">
  <div class="col">
   ServiceType:<select name="serviceType" class="form-control">
   <option>Select Service</option>
	<option value="HealthCareService" <c:if test="${dto.getServiceType()=='HealthCareService'}"> selected="selected" </c:if>> HealthCareService</option>
	<option value="WaterService" <c:if test="${dto.getServiceType()=='WaterService'}"> selected="selected" </c:if>>WaterService</option>
	<option value="TransportationService" <c:if test="${dto.getServiceType()=='TransportationService'}"> selected="selected" </c:if>> TransportationService</option>
	<option value="EntertainmentService" <c:if test="${dto.getServiceType()=='EntertainmentService'}"> selected="selected" </c:if>> EntertainmentService</option>	
   </select>
  </div>
  <div class="col">
   OwnerName: <input type="text" class="form-control" placeholder="OwnerName" aria-label="OwnerName" name="ownerName" value="${dto.getOwnerName()}">
  </div>
 </div><br>
 <div class="row">
 
  <div class="col">
   ContactNo:<input type="text" class="form-control" placeholder="ContactNo" aria-label="ContactNo" name="contactNo" value="${dto.getContactNo()}" id="contact" onchange="onContact()">
   <span id="contactError" style="color:red"></span> 
  </div>
  <div class="col">
   AlternativeNo: <input type="text" class="form-control" placeholder="AlternativeNo" aria-label="AlternativeNo" name="alternativeNo" value="${dto.getAlternativeNo()}">
  </div>
 </div><br>
 <div class="row">
  <div class="col">
   Email:<input type="text" class="form-control" placeholder="Email" aria-label="Email" name="email" value="${dto.getEmail()}" id="mail" onchange="onEmail()">
   <span id="mailError" style="color:red"></span>
  </div>
  
  <div class="col">
   Website: <input type="text" class="form-control" placeholder="Website" aria-label="Website" name="website" value="${dto.getWebsite()}" id="website" onchange="onWebsite()">
   <span id="webError" style="color:red"></span>
  </div>
 </div><br>
						
			<input type="submit" id="button" value="Register" class="btn btn-success"  />

	</form>
	

<script>
function onGstNo() {
	console.log("Running onGstNo...")
	var gstValue=document.getElementById('gstNo').value
	console.log(gstValue)
	if(gstValue !=null && gstValue!=" " && gstValue.length>3 && gstValue.length<30) 
		{
		console.log('valid gst');
		document.getElementById('gstNo').innerHTML='';
		
		const xhttp=new XMLHttpRequest();
		xhttp.open("GET","http://localhost:8080/vendormanage/uniqueGst/"+gstValue);
		xhttp.send();
		xhttp.onload=function()
		{
			console.log(this);
			document.getElementById('gstError').innerHTML= this.responseText;	
		}
		}
		else{
			console.log('invalid gst');
			document.getElementById('button').disabled='disabled';
			document.getElementById('gstError').innerHTML='Enter a valid gstNo';
			
		}
	
}

function onContact()
{
	console.log("Running onContact...")
	var contactValue=document.getElementById('contact').value
	console.log(contactValue)
	if(contactValue != "" && contactValue.length == 10) 
		{
		console.log('valid contact');
		document.getElementById('contact').innerHTML='';
	
		const xhttp=new XMLHttpRequest();
		xhttp.open("GET","http://localhost:8080/vendormanage/uniqueContact/"+contactValue);
		xhttp.send();
		xhttp.onload=function()
		{
			console.log(this);
			document.getElementById('contactError').innerHTML= this.responseText;
			
		} 
		}
		else{
			console.log('invalid contact');
			document.getElementById('button').disabled='disabled';
			document.getElementById('contactError').innerHTML="<span style='color:red'>Enter a valid number</span>";
			return true;
			
		
		}
	}
	
function onWebsite()
{
	console.log("Running onWebsite...")
	var webValue=document.getElementById('website').value
	console.log(webValue)
	if(webValue !=null && webValue!=" " && webValue.length>3 && webValue.length<30) 
		{
		console.log('valid website');
		document.getElementById('website').innerHTML='';
		
		const xhttp=new XMLHttpRequest();
		xhttp.open("GET","http://localhost:8080/vendormanage/uniqueWebsite/"+webValue);
		xhttp.send();
		xhttp.onload=function()
		{
			console.log(this);
			document.getElementById('webError').innerHTML= this.responseText;
			
		}
		}
		else{
			console.log('invalid website');
			document.getElementById('button').disabled='disabled';
			document.getElementById('webError').innerHTML='Enter a valid website';
				
		}
	}

function onEmail() {
	console.log("Running onEmail...")
	var mailsValue=document.getElementById('mail').value
	console.log(mailsValue)
	if(mailsValue !=null && mailsValue!=" " && mailsValue.length>3 && mailsValue.length<30) 
		{
		console.log('valid email');
		document.getElementById('mailError').innerHTML='';
		
		const xhttp=new XMLHttpRequest();
		xhttp.open("GET","http://localhost:8080/vendormanage/uniqueEmail/"+mailsValue);
		xhttp.send();
		xhttp.onload=function()
		{
			console.log(this);
			document.getElementById('mailError').innerHTML= this.responseText;		
		}
		}
		else{
			console.log('invalid email');
			document.getElementById('button').disabled='disabled';
			document.getElementById('mailError').innerHTML='Enter a valid email';
		}
	
}

</script>
</body>
</html>