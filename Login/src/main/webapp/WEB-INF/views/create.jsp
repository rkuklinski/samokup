<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html>
 
<head>
<title>Login Page</title>
</head>
<body>
    <h3>Create an account</h3>
    <c:url var="createAccount" value="/create/add"></c:url>
    
    <script type="text/javascript"> 
    function checkForm(form) { 
    	if(form.username.value == "") { 
    		alert("Error: Username cannot be blank!"); 
    		form.username.focus(); 
    		return false; 
    	} 
    	re = /^\w+$/; 
    	if(!re.test(form.username.value)) { 
    		alert("Error: Username must contain only letters, numbers and underscores!"); 
    		form.username.focus(); 
    		return false; 
    	} 
    	
    	if(form.password.value != "" && form.password.value == form.repeat_password.value) { 
    		if(form.password.value.length < 6) { 
    			alert("Error: Password must contain at least six characters!"); 
    			form.password.focus(); 
    			return false; 
    		} 
    		
    		if(form.password.value == form.username.value) { 
    			alert("Error: Password must be different from Username!"); 
    			form.password.focus(); 
    			return false; 
    		} 
    		
    		re = /[0-9]/; 
    		if(!re.test(form.password.value)) { 
    			alert("Error: password must contain at least one number (0-9)!"); 
    			form.password.focus(); 
    			return false; 
    		} 
    		
    		re = /[a-z]/; 
    		if(!re.test(form.password.value)) { 
    			alert("Error: password must contain at least one lowercase letter (a-z)!"); 
    			form.password.focus(); 
    			return false; 
    		} 
    		
    		re = /[A-Z]/; 
    		if(!re.test(form.password.value)) { 
    			alert("Error: password must contain at least one uppercase letter (A-Z)!"); 
    			form.password.focus(); return false; 
    		} 
    	} else { 
    		alert("Error: Please check that you've entered and confirmed your password!"); 
    		form.password.focus(); 
    		return false; 
    	} 
    	return true; 
    } 
    </script>
    <form action="${createAccount}" method="POST" onsubmit="return checkForm(this);">
        <table>
            <tr>
                <td>Email (Your ID):</td>
                <td><input type='email' name='email' required placeholder="Enter a valid email address" pattern="\w+"/></td>
            </tr> 
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password' required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" onchange="form.repeat_password.pattern = this.value;"/></td>
            </tr>
            <tr>
                <td>Repeat password:</td>
                <td><input type='password' name='repeat_password' required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" onchange="form.password.pattern = this.value;"/></td>
            </tr>
            <tr>
                <td>Username</td>
                <td><input type='text' name='username' required pattern="\w+"/></td>
            </tr>  
            <tr>
                <td>Some other not defined data</td>
                <td></td>
            </tr>            
            <tr>
                <td colspan='2'>
                <input type="submit" value="Create" />
                </td>
            </tr>
        </table>
    </form>
</body>
</html>