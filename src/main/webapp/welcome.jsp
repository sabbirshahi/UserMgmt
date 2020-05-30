<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
    <c:forEach var="create" items="${reportCreateList}">
                                            <tr>
                                                <td><c:out value="${create.action}" /></td>
                                                <td><c:out value="${create.username}" /></td>
                                                <td>Demo Bahadur</td>
                                                <td>4/11/2020</td>
                                                <td><button class="block-delete">Block</button> <button class="block-delete">Delete</button></td>
                                            </tr>
                                            </c:forEach>


        <a href="Logout">Logout</a>
        
    </body>
</html>
