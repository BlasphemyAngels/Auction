function changeImage(img){
	img.src = img.src + "?" + new Date().getTime();
}
function check(){
	var a = checkName();
	var b = checkPsw();
	if(a && b)
		return true;
	return false;
}
function checkName(){
	var value = document.getElementById("username").value;
	if(value == null || value == "")
	{
		document.getElementById("usernameSp").setAttribute("style", "display: inline");
		return false;
	}
	document.getElementById("usernameSp").setAttribute("display", "none");
	return true;
}
function checkPsw(){
	var value = document.getElementById("password").value;
	if(value == null || value == "")
	{
		document.getElementById("passwordSp").setAttribute("style", "display: inline");
		return false;
	}
	document.getElementById("passwordSp").setAttribute("display", "none");
	return true;
}