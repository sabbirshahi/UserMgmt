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
       
        <h1>Hi, ${FILES_DIR_FILE}${imagePath} !!! We welcome you !!!</h1>

        <img src="uploadimage?fileName=${not empty marginLeft ? 'margin-left:'.concat(marginLeft) :demo}" height="100px" width="100px" onerror="this.src='https://i.stack.imgur.com/l60Hf.png';">
        <img src="${FILES_DIR_FILE}${imagePath}" height="100px" width="100px">
 
<form action="uploadimage" method="post" enctype="multipart/form-data">
Select File to Upload:<input type="file" name="fileName">
<br>
<input type="submit" value="Upload">
</form>

        <a href="Logout">Logout</a>
        
    </body>
</html>
