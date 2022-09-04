<%-- 
    Document   : admin-product
    Created on : Aug 12, 2022, 1:50:08 PM
    Author     : kyuut
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="app-main__outer">
    <div class="app-main__inner">
        
        <table class="table" style="margin-top: 20px">
            <thead>
                <tr>
                    <th scope="col" >#</th>
                    <th scope="col">ID</th>
                    <th scope="col">QUANTITY</th>
                    <th scope="col">UNITPRICE</th>
                    <th scope="col">MENU</th>
                    <th scope="col">ORDER</th>
                </tr>
            </thead>
            <tbody id="adminOrderDetail">
            </tbody>
        </table>
        
    </div>
</div>
<script src="<c:url value="/js/menu.js" />"></script>
<script>
    window.addEventListener('load', loadAdminOrderDetail());
</script>
