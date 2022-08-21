<%-- 
    Document   : index
    Created on : Jul 21, 2022, 12:10:17 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="<c:url value="/js/menu.js" />"></script>
<div class="container-xxl py-5">
    <section style="margin: 50px 0;">
        <h1 style="margin: 50px 0;">PAYMENT INFO</h1>
        <div>
            <h3>CUSTOMER INFO</h3>
            <div>
                <strong>Full name:&nbsp;</strong>
                <span>${currentUser.firstName}&nbsp;${currentUser.lastName}</span>
            </div>
            <div>
                <strong>Phone:&nbsp;</strong>
                <span>${currentUser.phone}</span>
            </div>
            <div>
                <strong>Email:&nbsp;</strong>
                <span>${currentUser.email}</span>
            </div>
            <div>
                <strong>Address:&nbsp;</strong>
                <span>${currentUser.address}</span>
            </div>
        </div>
        <table class="table" style="margin: 50px 0;">
            <thead>
                <tr>
                    <th scope="col">NAME</th>
                    <th scope="col">STORE</th>
                    <th scope="col">UNIT PRICE</th>
                    <th scope="col">QUANTITY</th>
                    <th scope="col">TOTAL</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${carts}" var="c">
                <script>loadStoreByMenuId(${c.menuId})</script>
                <tr id="product${c.menuId}">
                    <th scope="row">${c.menuName}</td>
                    <td id="store${c.menuId}"></td>
                    <td>${c.price} VNÐ</td>
                    <td>${c.quantity}</td>
                    <td>${c.price * c.quantity} VNÐ</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="row" style="padding: 0 50px; margin: 20px 0;">
            <div class="col">
                <strong>SUBTOTAL:&nbsp;</strong>
                <div>${cartStats.amount} VNÐ</div>
            </div>
            <div class="col" style="text-align: center">
                <strong>SHIP:&nbsp;</strong>
                <div id="ship"></div>
            </div>
            <div class="col" style="text-align: center">
                <strong>TOTAL:&nbsp;</strong>
                <div >
                    <span id="total">${cartStats.amount}</span>
                    <span>&nbsp;VNÐ</span>
                </div>
            </div>
        </div>
        <div class="payment-field" style="justify-content: flex-end;">
            <c:if test="${currentUser != null}">
                <button class="btn-pay" onclick="pay()">Pay</button>
            </c:if>
            <c:if test="${currentUser == null}">
                <h4><a href="<c:url value="/login" />">Vui long dang nhap</a></h4>
            </c:if>
        </div> 

    </section>

</div>
<script src="https://cdn.lordicon.com/xdjxvujz.js"></script>
<script>
                    $(document).ready(function () {
                        loadStoreInCart();
                    });
</script>


