<%-- 
    Document   : base
    Created on : Jul 21, 2022, 12:35:43 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>
            <tiles:insertAttribute name="title" />
        </title>
        <!-- Favicon -->
        <link href="resources/img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&family=Pacifico&display=swap" rel="stylesheet">

        <!-- Icon Font Stylesheet -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="<c:url value="/resources/lib/animate/animate.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/lib/owlcarousel/assets/owl.carousel.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" />" rel="stylesheet" />

        <!-- Customized Bootstrap Stylesheet -->
        <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="<c:url value="/css/style.css" />" rel="stylesheet">
        
        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="<c:url value="/resources/lib/wow/wow.min.js" />"></script>
        <script src="<c:url value="/resources/lib/easing/easing.min.js" />"></script>
        <script src="<c:url value="/resources/lib/waypoints/waypoints.min.js" />"></script>
        <script src="<c:url value="/resources/lib/counterup/counterup.min.js" />"></script>
        <script src="<c:url value="/resources/lib/owlcarousel/owl.carousel.min.js" />"></script>
        <script src="<c:url value="/resources/lib/tempusdominus/js/moment.min.js" />"></script>
        <script src="<c:url value="/resources/lib/tempusdominus/js/moment-timezone.min.js" />"></script>
        <script src="<c:url value="/resources/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js" />"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>

    </head>
    <body>
        <!-- HEADER -->
        <tiles:insertAttribute name="header" />


        <!-- CONTENT -->
        <tiles:insertAttribute name="content" />


        <!-- FOOTER -->
        <tiles:insertAttribute name="footer" />

        

        <!-- Template Javascript -->
        <script src="<c:url value="/js/main.js" />"></script>
        <script src="<c:url value="/js/menu.js" />"></script>
        <script src="<c:url value="/js/custom.js" />"></script>


    </body>
</html>
