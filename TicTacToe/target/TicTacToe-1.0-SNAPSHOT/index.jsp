<%-- 
    Document   : index
    Created on : 12/04/2023, 6:10:16 p. m.
    Author     : Usuario
--%>

<jsp:useBean id="gameBean" scope="session" class="game.GameBean" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tic Tac Toe</title>
    </head> 
    <body>
        <h1>Tic Tac Toe VERSION 2.0</h1>
        <form action="EntryServlet" method="post">
            <input type="submit" name="User" value="You start"><br/>
            <input type="submit" name="Computer" value="The computer starts">
        </form>
    </body>
</html>


