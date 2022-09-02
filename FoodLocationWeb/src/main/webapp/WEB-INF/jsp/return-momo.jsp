<%-- 
    Document   : index
    Created on : Jul 21, 2022, 12:10:17 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="<c:url value="/js/menu.js" />"></script>
<div class="container-xxl py-5">
    <section style="margin: 50px 0;">
        <c:choose>
            <c:when test="${message eq null}">
                <h1 style="color: red">Xin hay giu long tu trong cua minh, neu khong ban se bi bat!!!!!!</h1>
            </c:when>    
            <c:otherwise>
                <h1>${message}</h1>
            </c:otherwise>
        </c:choose>
    </section>
</div>


