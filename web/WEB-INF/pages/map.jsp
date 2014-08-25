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
    <title></title>


    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" media="screen">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/custom.css" media="screen">

    <script src="${pageContext.request.contextPath}/resources/js/require.js" data-main="app"></script>
    <script>
        require.config({
            baseUrl: "${pageContext.request.contextPath}/resources/js"
        });
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

    <!--Waiting fow other player modal... -->
    <div class="modal fade" id="waitingForOtherPlayerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">

                <div class="modal-body">
                    <div class="container-fluid">

                        <div class="row alert no-bottom-margin alert-info">
                            <div class="col-lg-2">
                                <img src="${pageContext.request.contextPath}/resources/img/ajax-loader.gif">
                            </div>
                            <div class="col-lg-10">
                                <span id="waitingMessage"></span>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
