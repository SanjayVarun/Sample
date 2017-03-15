function showServiceType(){
	
	document.getElementById("ServiceType").hidden= false;
	document.getElementById("ServiceTime").hidden= false;
	document.getElementById("Addressdiv").hidden= true;
}
function hideServiceType(){
	document.getElementById("ServiceType").hidden= true;
	document.getElementById("Addressdiv").hidden= false;
	document.getElementById("ServiceTime").hidden= true;
}