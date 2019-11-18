function removeButtonRegister() {
	 var elem = document.getElementById('Register');
	 elem.parentNode.removeChild(elem);
	 elem = document.getElementById('Login');
	 elem.parentNode.removeChild(elem);
	 elem = document.getElementById('title');
	 elem.parentNode.removeChild(elem);
	 elem = document.getElementById('description');
	 elem.parentNode.removeChild(elem);
	 elem = document.getElementById('register_form1');
	 elem.style.visibility = 'visible';
	 elem = document.getElementById('register_form2');
	 elem.style.visibility = 'visible';
	 elem = document.getElementById('register_form3');
	 elem.style.visibility = 'visible';
	 elem = document.getElementById('register_form4');
	 elem.style.visibility = 'visible';
	 elem = document.getElementById('register_form5');
	 elem.style.visibility = 'visible';
	 elem = document.getElementById('register_form6');
	 elem.style.visibility = 'visible';
	 elem = document.getElementById('register_form7');
	 elem.style.visibility = 'visible';
	 elem = document.getElementById('register_form8');
	 elem.style.visibility = 'visible';
	 elem = document.getElementById('role');
	 elem.style.visibility = 'visible';
	 elem = document.getElementById('Rsubmit');
	 elem.style.visibility = 'visible';
	 elem = document.getElementById('Rfname');
	 elem.readOnly = false;
	}
	
function removeButtonLogin() {
	 var elem = document.getElementById('Register');
	 elem.parentNode.removeChild(elem);
	 elem = document.getElementById('Login');
	 elem.parentNode.removeChild(elem);
	 elem = document.getElementById('title');
	 elem.parentNode.removeChild(elem);
	 elem = document.getElementById('description');
	 elem.parentNode.removeChild(elem);
	 elem = document.getElementById('Login_form');
	 elem.style.visibility = 'visible';
	 elem = document.getElementById('Lemail');
	 elem.readOnly = false;
	 elem = document.getElementById('LPassword');
	 elem.readOnly = false;
	 elem = document.getElementById('login');
	 elem.disabled = false;
	}