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

    <meta charset="utf-8" />
    <meta name="description" content="Guessing country location on map game." >
    <meta name="keywords" content="game, geography, geo, map, location" >

    <title>Guess country game</title>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/img/favicon.png" />

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" media="screen">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/custom.css" media="screen">
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

    <!-- Google analytics -->
    <script>
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
            (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
                m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
        })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

        ga('create', 'UA-54335163-1', 'auto');
        ga('send', 'pageview');

    </script>

    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <script type="text/javascript" src="//vk.com/js/api/openapi.js?115"></script>

    <style type="text/css">

        .page-header.clear-bottom {
            border-bottom: none;
        }

    </style>

</head>
<body>

    <script type="text/javascript">
        VK.init({apiId: 4532823, onlyWidgets: true});
    </script>

    <div id="fb-root"></div>
    <script>(function(d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s); js.id = id;
        js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.0";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));</script>

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
            <div class="col-lg-9 col-md-11">
                <div class="page-header clear-bottom">
                    <h1>Guess Country</h1>
                    <p class="lead">A small map related game.</p>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-9 col-md-11">

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

        <div class="row social-likes">
            <!-- Facebook like button -->
            <div class="col-lg-1 col-xs-3">
                <div class="fb-like"
                     data-colorscheme="dark"
                     data-href="http://guess-country.com"
                     data-layout="button_count"
                     data-action="like"
                     data-show-faces="true"
                     data-share="false">
                </div>
            </div>
            <div class="col-lg-1 col-xs-3">
                <!-- Google plus like button -->
                <!-- Place this tag where you want the +1 button to render. -->
                <div class="g-plusone" data-size="medium"></div>
            </div>
            <div class="col-lg-1 col-xs-3">
                <!-- VK like button -->
                <!-- Put this div tag to the place, where the Like block will be -->
                <div id="vk_like"></div>
                <script type="text/javascript">
                    VK.Widgets.Like("vk_like", {type: "mini"});
                </script>
            </div>
        </div>

    </div>

</body>
</html>
