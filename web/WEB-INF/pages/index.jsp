<%--
  Created by IntelliJ IDEA.
  User: Kazak_VV
  Date: 31.07.2014
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Guess country</title>
</head>
<body>

    <form action="${pageContext.request.contextPath}/play" method="post">

        Please enter your name: <input name="playerName" type="text" /></br>
        <input type="submit" value="Play" />

    </form>

</body>
</html>
