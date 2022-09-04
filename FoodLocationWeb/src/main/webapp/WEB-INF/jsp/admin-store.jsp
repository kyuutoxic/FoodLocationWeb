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
                    <th scope="col">USERNAME</th>
                    <th scope="col">NAME STORE</th>
                    <th scope="col">PHONE</th>
                    <th scope="col">EMAIL</th>
                    <th scope="col">ADDRESS</th>
                    <th scope="col">ACTIVE</th>
                    <th scope="col">IsDelete</th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody id="adminStore">
            </tbody>
        </table>

    </div>
</div>
<script src="<c:url value="/js/menu.js" />"></script>
<script>
    window.addEventListener('load', loadAdminStore());
</script>
