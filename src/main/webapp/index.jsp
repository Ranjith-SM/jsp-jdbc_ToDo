<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
<title> To-Do </title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>


</head>
<body>
<h2>LOGIN</h2>

<div class="row">
    <div class="col" ></div>
    <div class="col">
        <form action="login" method="POST">

            <div class="form-outline mb-4">
                <label class="form-label" >UserName</label>
                <input type="text" id="form2Example2" class="form-control" name="username" />

            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form2Example2">Password</label>
                <input type="password" id="form2Example2" class="form-control"  name="password" />

              </div>


            <%
                if(request.getAttribute("error") != null ) {
                    out.print("<p> Invalid Credentials </p>");
                }
            %>
            <input type="submit"  class="btn btn-primary btn-block mb-4" name="login" value="login" />

            <p>Not a User? <a href="register.jsp" />Register Here</a> </p>
        </form>
    </div>
    <div class="col"> </div>


</div>


</body>
</html>
