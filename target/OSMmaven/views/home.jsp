<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Thế giới Bất động sản 24h</title>

    <jsp:include page="/views/partials/head.jsp" />
</head>
<body>
<jsp:include page="/views/partials/moveTop.jsp" />
<header>
    <jsp:include page="/views/partials/header.jsp" />
</header>
<article>

    <jsp:include page="/views/partials/slider.jsp" />
    <jsp:include page="/views/partials/map.jsp" />
    <jsp:include page="/views/partials/rent.jsp"/>
    <jsp:include page="/views/partials/sale.jsp" />
    <jsp:include page="/views/partials/contactHome.jsp" />
    <jsp:include page="/views/partials/project.jsp" />
</article>
<footer>
    <jsp:include page="/views/partials/footer.jsp" />
</footer>
</body>
</html>