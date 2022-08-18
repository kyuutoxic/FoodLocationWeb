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
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv="Content-Language" content="en">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
        <meta name="description" content="This is an example dashboard created using build-in elements and components.">
        <meta name="msapplication-tap-highlight" content="no">
        <title>
            <tiles:insertAttribute name="title" />
        </title>

        <!-- Template Stylesheet -->
        <link href="<c:url value="/css/admin.css" />" rel="stylesheet">

    </head>
    <body>
        <div class="app-container app-theme-white body-tabs-shadow fixed-sidebar fixed-header">

            <!-- HEADER -->
            <tiles:insertAttribute name="store-header" />


            <!-- CONTENT -->
            <tiles:insertAttribute name="store-content" />


            <!-- FOOTER -->
            <tiles:insertAttribute name="store-footer" />

        </div>

        <!-- Template Javascript -->
        <script src="<c:url value="/js/admin.js" />"></script>
    </body>
</html>
