<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register here!</title>
<script src="Registerjs.js"> </script>
<link rel="stylesheet" href="Signup.css" type="text/css">

</head>
<body>
<div class="exceptsignup"></div>
<div class="SignupContent">

  <div class="Registerform">
 <form method="post" action="RegisterServlet">
 <div class="Radiobuttons">
 <input type="radio" class="Serviceproviderradio" name="radio" value="ServiceProvider" onclick="showServiceType()"> ServiceProvider
 <input type="radio" class="Customerradio" name="radio" value="Customer" onclick="hideServiceType()">Customer
 </div>

 <div class="usernamefield"> 
 <label for="usernamefield"> Username </label>
 <input type="text" class="usernamefield" name="Username">
 </div>

 <div class="passwordfield"> 
 <label for="passwordfield"> Password </label>
 <input type="password" class="passwordfield" name="Password">
 </div>

 <div class="namefield"> 
 <label for="namefield"> Name </label>
 <input type="text" class="namefield" name="Name">
 </div>

 <div class="Phnotext"> 
<label for="Phnotext"> Phone Number </label>
 <input type="text" class="Phnotext" name="Phonenumber">
 </div>

<div class="Loctext"> 
<label for="Loctext"> Location </label>
 <input type="text" class="Loctext" name="Location">
</div>

<div id="Addressdiv">

<div class="Addresstext"> 
<label for="Addresstext"> Address </label>
<input type="text" class="Addresstext" name="Address">
</div>

<div class="Emailtext"> 
<label for="Emailtext"> Email-id </label>
<input type="text" class="Emailtext" name="Email">
</div>

</div>

<div id="ServiceTime">

<div class="Fromtime"> 
<label for="Fromtime"> From </label>
<input type="text" class="Fromtime" name="from">
</div>

<div class="Totime"> 
<label for="Totime"> To </label>
<input type="text" class="Totime" name="to">
</div>

</div>

<div id="ServiceType" class="ServiceType"> 
<label for="ServiceType"> Service Type </label>
 <input type="radio" class="ServiceType" id="Elec" name="profession" value="Electrical">Electrical
 <input type="radio" class="ServiceType" id="Plumbing" name="profession" value="Plumbing"> Plumbing
 <input type="radio" class="ServiceType" id="PC"name="profession" value=" PC Assist">PC Assist
 <input type="radio" class="ServiceType" id="Carpentry"name="profession" value="Carpentry">Carpentry 
 <input type="radio" class="ServiceType" id="Mechanic" name="profession" value="Mechanic"> Mechanic
 <input type="radio" class="ServiceType" id="Houseclean" name="profession" value="House Cleaning">House Cleaning 
</div>

<div class="submitbutton"> 
<input type="submit" value="Submit" class="submitbutton" name="Submit" > 
</div>

</form>
</div>
</div>
</body>
</html>