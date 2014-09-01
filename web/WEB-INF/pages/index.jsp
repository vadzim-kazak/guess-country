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

    <title>Guess country game</title>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/img/favicon.png" />

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" media="screen">
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

    <style type="text/css">

        .page-header.clear-bottom {
            border-bottom: none;
        }

    </style>

</head>
<body>

    <!-- Navbar -->
    <div class="row">
        <div class="col-lg-12">
            <div class="navbar navbar-default">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"></a>
                </div>
            </div>
        </div>
    </div>

    <div class="container">

        <div class="row">
            <div class="col-lg-8">
                <div class="page-header clear-bottom">
                    <h1>Guess Country</h1>
                    <p class="lead">A small map related game.</p>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-8">

                <div class="well bs-component">

                    <form action="${pageContext.request.contextPath}/play" method="post" class="form-horizontal">
                        <fieldset>
                            <legend>Game settings</legend>

                            <!-- Player name -->
                            <div class="form-group">
                                <label for="playerName" class="col-lg-2 control-label">Your name:</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="playerName" name="playerName" placeholder="Please enter your name here...">
                                </div>
                            </div>

                            <!-- Game type -->
                            <div class="form-group">
                                <label class="col-lg-2 control-label">Game mode:</label>
                                <div class="col-lg-10">
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="gameMode" value="SINGLE" checked="">
                                            Single
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="gameMode" value="DUEL">
                                            Duel
                                        </label>
                                    </div>
                                </div>
                            </div>

                            <!-- Play button -->
                            <div class="form-group">
                                <div class="col-lg-10 col-lg-offset-2">
                                    <button type="submit" class="btn btn-info">Play</button>
                                </div>
                            </div>

                        </fieldset>
                    </form>

                </div>
            </div>
        </div>

    </div>

</body>
</html>
