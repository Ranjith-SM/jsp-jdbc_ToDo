<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<title>ToDo</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>

<body>
    <%
        if(session.getAttribute("userid") == null){
             response.sendRedirect(request.getContextPath());
        }
    %>
    <h2>Welcome <c:out value="${user.username}" /></h2>


    <form action="logout.jsp" method="link">
        <input type="submit" value="Logout"/>
    </form>

    <form class="mx-auto" action="home" method="post">
        <p>Enter todo: <input type="text" name="todo" value="${todo.todo}"/>
        <input type="submit" value="Add" />
    </form>

    <c:if test="${todos.size() eq 0}">
        <p>No Items to display</p>
    </c:if>

    <c:if test="${todos.size() gt 0}">

        <div class="mx-auto" style="width:500px;">
            <table class="table ">
                            <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Todo</th>
                                    <th scope="col">Actions</th>
                                </tr>
                            </thead>
                            <tbody class="table-group-divider">
                                <c:forEach var="todo" items="${todos}">
                                    <tr scope="row">
                                        <td>
                                            <c:out value="${todo.id}" />
                                        </td>
                                        <td>
                                            <c:out value="${todo.todo}" />
                                        </td>
                                        <td><a href="home?id=<c:out value='${todo.id}' />">Delete</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>

                        </table>
        </div>

    </c:if>
 </body>
 </html>
