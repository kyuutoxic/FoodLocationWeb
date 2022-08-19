<%-- 
    Document   : index
    Created on : Jul 21, 2022, 12:10:17 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-xxl py-5">

    <section style="margin: 50px 0;">
        <c:if test="${carts == null}">
            <h4 class="text-danger">Khong co san pham nao trong gio</h4>
        </c:if>
        <c:if test="${carts != null}">
            <h1>Cart</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col-1">#</th>
                        <th scope="col-5">NAME</th>
                        <th scope="col-2">UNIT PRICE</th>
                        <th scope="col-3" style="text-align: center">QUANTITY</th>
                        <th scope="col-1"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${carts}" var="c">
                        <tr id="product${c.menuId}">
                            <th scope="row">1</th>
                            <td>${c.menuName}</td>
                            <td>${c.price} VNÐ</td>
                            <td style="text-align: center">
                                <!--                                <button class="btn-minus-quantity">-</button>
                                                                <input type="text" value="${c.quantity}" id="quantity">
                                                                <button class="btn-plus-quantity">+</button>-->
                                <div class="input-group">
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-default btn-number" disabled="disabled" data-type="minus" data-field="${c.menuId}">
                                            <span class="glyphicon glyphicon-minus"></span>
                                        </button>
                                    </span>
                                    <input type="text" name="${c.menuId}" class="form-control input-number" value="${c.quantity}" min="1" max="10" onblur="updateCart(this, ${c.menuId})">
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-default btn-number" data-type="plus" data-field="${c.menuId}">
                                            <span class="glyphicon glyphicon-plus"></span>
                                        </button>
                                    </span>
                                </div>
                            </td>
                            <td><button class="btn-delete-cart" onclick="deleteCart(${c.menuId})">Delete</button></td>                    
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="payment-field">
                <h1 id="amountCart">Total: ${cartStats.amount}VNÐ</h1>
                <button class="btn-pay">Pay</button>
            </div>
        </c:if>

    </section>

</div>
<script src="<c:url value="/js/menu.js" />"></script>


