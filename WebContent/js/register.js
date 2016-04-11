function checkR(){
	var a = checkName();
	var b = checkPsw();
	var c = checkPsw2();
	if(a && b && c)
		return true;
	return false;
}
function checkPsw2(){
	var value = document.getElementById("password2").value;
	if(value == null || value == "")
	{
		document.getElementById("password2Sp").setAttribute("style", "display: inline");
		return false;
	}
	document.getElementById("password2Sp").setAttribute("display", "none");
	return true;
}