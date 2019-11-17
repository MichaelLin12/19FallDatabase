function removeButtonRegister() {
	 var elem = document.getElementById('Register');
	 elem.parentNode.removeChild(elem);
	 elem = document.getElementById('Login');
	 elem.parentNode.removeChild(elem);
	 
	 var x = document.createElement("FORM");
	 x.setAttribute("id", "myForm");
	 document.body.appendChild(x);

	 var y = document.createElement("INPUT");
	 y.setAttribute("type", "text");
	 y.setAttribute("value", "");
	 document.getElementById("myForm").appendChild(y);
	 
	 document.getElementById("myForm").style.position = "absolute";
	 document.getElementById("myForm").style.left = "50%";
	 document.getElementById("myForm").style.top = "55%";
	 document.getElementById("myForm").style.transform = "translate(-50%,-50%)";
	 
	 document.getElementById("myForm").style.position = "absolute";
	 document.getElementById("myForm").style.left = "50%";
	 document.getElementById("myForm").style.top = "60%";
	 document.getElementById("myForm").style.transform = "translate(-50%,-50%)";
	}
	
function removeButtonLogin() {
	 var elem = document.getElementById('Register');
	 elem.parentNode.removeChild(elem);
	 elem = document.getElementById('Login');
	 elem.parentNode.removeChild(elem);
	}