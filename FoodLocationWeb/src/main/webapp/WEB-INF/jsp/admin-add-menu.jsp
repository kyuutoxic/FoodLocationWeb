<%-- 
    Document   : admin-add-product
    Created on : Aug 12, 2022, 2:17:48 PM
    Author     : kyuut
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="app-main__outer">
    <div class="app-main__inner">
        <h5 class="card-title">Controls Types</h5>
        <c:url value="/admin/add-menu" var="a" />
        <form:form method="post" action="${a}" modelAttribute="menu" enctype="multipart/form-data">
            <div class="position-relative form-group">
                <label for="name" class="">Name</label>
                <form:input id="name" type="text" class="form-control" path="name" />
            </div>
            <div class="position-relative form-group">
                <label for="price" class="">Price</label>
                <form:input id="price" type="text" class="form-control" path="price" />
            </div>  
            <div class="position-relative form-group">
                <label for="exampleText" class="">Note</label>
                <form:textarea id="note" class="form-control" path="note"/>
            </div>
            <div class="position-relative form-group">
                <label for="from" class="">From</label>
                <form:input id="from" type="time" class="form-control" path="from" />
            </div><!--
            -->            <div class="position-relative form-group">
                <label for="to" class="">To</label>
                <form:input id="to" type="time" class="form-control" path="to" />
            </div>
            <div class="position-relative form-group">
                <label for="typeMenu" class="">Type Menu</label>

                <form:select class="form-control" path="typeId">
                    <c:forEach var="t" items="${type}">
                        <form:option value="${t.id}">${t.name}</form:option>
                    </c:forEach>
                </form:select>
            </div>

            <div class="position-relative form-group">
                <label for="image" class="">Image</label>
                <form:input type="file" class="form-control-file" path="image" />
            </div>
            <button type="submit" class="btn btn-primary btn-lg btn-block btn-in-login">Them</button>

        </form:form>
    </div>
</div>

