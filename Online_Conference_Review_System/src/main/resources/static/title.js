function removeButtonRegister() {
	 var elem = document.getElementById('Register');
	 elem.parentNode.removeChild(elem);
	 elem = document.getElementById('Login');
	 elem.parentNode.removeChild(elem);
	}
	
function removeButtonLogin() {
	 var elem = document.getElementById('Register');
	 elem.parentNode.removeChild(elem);
	 elem = document.getElementById('Login');
	 elem.parentNode.removeChild(elem);
	 elem = document.getElementById('Login_form');
	 elem.style.visibility = 'visible';
	 elem = document.getElementById('email');
	 elem.readOnly = false;
	 elem = document.getElementById('Password');
	 elem.readOnly = false;
	}