<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<body>
<h2>LOGIN</h2>
<form action="register" method="POST">
    <p>Username: <input type="text" name="username" /> </p>
    <p>Password: <input type="password" name="password" /> </p>
    <p>Password: <input type="password" name="Confirm-password" /> </p>
    <%
        if(request.getAttribute("pass_error") != null) {
            out.print("<p> Passwords doesn't match!!! </p>");
            out.print("<p> ----Please Enter Valid Passwords---- </p>");
        }
        if (request.getAttribute("user_error") != null) {
            out.print("<p> ---- UserName is Not Available ----</p>");
            out.print("<p> ---- Please Enter Unique Username ---- </p>");
        }
    %>

    <input type="submit" name="login" value="Register" />
</form>

</body>
</html>