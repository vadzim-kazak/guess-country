<%--
  Created by IntelliJ IDEA.
  User: Kazak_VV
  Date: 30.07.2014
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Guess country game</title>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/img/favicon.png" />


    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pace.css" media="screen">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" media="screen">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/custom.css" media="screen">

    <script src="${pageContext.request.contextPath}/resources/js/require.js" data-main="app"></script>
    <script>
        require.config({
            baseUrl: "${pageContext.request.contextPath}/resources/js"
        });
    </script>

    <!-- Google analytics -->
    <script>
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
            (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
                m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
        })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

        ga('create', 'UA-54335163-1', 'auto');
        ga('send', 'pageview');

    </script>

</head>
<body>

    <!-- Map -->
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12 map-height" id="map-canvas">
            </div>
        </div>
    </div>

</body>
</html>
