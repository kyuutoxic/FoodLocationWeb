<%-- 
    Document   : admin-product
    Created on : Aug 12, 2022, 1:50:08 PM
    Author     : kyuut
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="app-main__outer">
    <div class="app-main__inner">
        <a class="btn btn-primary" href="<c:url value="/admin/add-menu" />">Them mon an</a>
        
        <table class="table" style="margin-top: 20px">
            <thead>
                <tr>
                    <th scope="col" >#</th>
                    <th scope="col">ID</th>
                    <th scope="col">NAME</th>
                    <th scope="col">PRICE</th>
                    <th scope="col">STORE</th>
                    <th scope="col">NOTE</th>
                    <th scope="col">FROM</th>
                    <th scope="col">TO</th>
                    <th scope="col">TYPE</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody id="adminProd">
            </tbody>
        </table>
        
    </div>
</div>
<script src="<c:url value="/js/menu.js" />"></script>
<script>
    <c:url value="/api/menu" var="endpoint" />
    <c:url value="/admin/detail-menu/" var="menudetail"/>
    window.addEventListener('load', loadAdminMenu('${endpoint}', '${menudetail}'));
</script>
