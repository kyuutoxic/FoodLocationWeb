<%-- 
    Document   : index
    Created on : Jul 21, 2022, 12:10:17 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                        <tr id="cart${c.menuId}">
                            <th scope="row">1</th>
                            <td>${c.menuName}</td>
                            <td><fmt:formatNumber type="number" value="${c.price}" maxFractionDigits="2" />&nbsp;VND</td>
                            <td style="text-align: center">
                                <!--                                <button class="btn-minus-quantity">-</button>
                                                                <input type="text" value="${c.quantity}" id="quantity">
                                                                <button class="btn-plus-quantity">+</button>-->
                                <div class="input-group">
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-default btn-number" data-type="minus" data-field="${c.menuId}">
                                            <lord-icon
                                                src="https://cdn.lordicon.com/ymerwkwd.json"
                                                trigger="loop-on-hover"
                                                colors="primary:#ffffff,secondary:#fea116"
                                                scale="50"
                                                style="width:30px;height:30px">
                                            </lord-icon>
                                        </button>
                                    </span>
                                    <input id="${c.menuId}" type="text" name="${c.menuId}" class="form-control input-number" value="${c.quantity}" min="1" max="10" onblur="updateCart(${c.menuId})">
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-default btn-number" data-type="plus" data-field="${c.menuId}">
                                            <lord-icon
                                                src="https://cdn.lordicon.com/xzksbhzh.json"
                                                trigger="hover"
                                                colors="primary:#ffffff,secondary:#fea116"
                                                scale="50"
                                                style="width:30px;height:30px">
                                            </lord-icon>
                                        </button>
                                    </span>
                                </div>
                            </td>
                            <td style="padding: 1rem 1rem;"><button class="btn-delete-cart" onclick="deleteCart(${c.menuId})">Delete</button></td>                    
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="payment-field">
                <div style="display: flex"><h1>Total:&nbsp;&nbsp;</h1><h1 id="amountCart"><fmt:formatNumber type="number" value="${cartStats.amount}" maxFractionDigits="2" /></h1><h1>&nbsp;VND</h1></div>
                        <c:if test="${currentUser != null}">
                    <a href="#" class="showModal" datatarget="choose-type-payment"><button class="btn-pay">Continue to Pay</button></a>
                </c:if>
                <c:if test="${currentUser == null}">
                    <h4><a href="<c:url value="/login" />">Vui long dang nhap</a></h4>
                </c:if>
            </div>
        </c:if>

    </section>
    <div class="myModal" id="choose-type-payment">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
                    <button type="button" class="btn-close" aria-label="Close" datatarget="choose-type-payment" dataaction="close"></button>
                </div>
                <div class="modal-body">
                    <div class="btn-momo-payment">
                        <a href="<c:url value="/payment/Momo" />">
                            <div>
                                Continue to Pay with Momo Wallet
                            </div>
                        </a>
                    </div>
                    <div class="btn-offline-payment">
                        <a href="<c:url value="/payment/Offline" />">
                            <div>
                                Continue to Pay with COD
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.lordicon.com/xdjxvujz.js"></script>


