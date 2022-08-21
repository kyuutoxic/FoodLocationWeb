<%-- 
    Document   : header
    Created on : Sep 6, 2021, 8:35:44 AM
    Author     : duonghuuthanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Navbar & Hero Start -->
<div class="container-xxl position-relative p-0">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark px-4 px-lg-5 py-3 py-lg-0" style="display:flex; flex-wrap:wrap; background-color: #0f172b !important;">
        <a href="<c:url value="/"/>" class="navbar-brand p-0" id="brand-top">
            <h1 class="text-primary m-0"><i class="fa fa-utensils me-3"></i>Restoran</h1>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="fa fa-bars"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav ms-auto py-0 pe-4">
                <a href="index.html" class="nav-item nav-link active">Home</a>
                <a href="about.html" class="nav-item nav-link">About</a>
                <a href="service.html" class="nav-item nav-link">Service</a>
                <a href="menu.html" class="nav-item nav-link">Menu</a>
                <a href="contact.html" class="nav-item nav-link">Contact</a>
            </div>
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <a href="<c:url value="/login"/>" class="btn btn-primary py-2 px-4">Login</a>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                        <img src="${currentUser.avatar}" class="avatar" alt="alt"/>
                    </a>
                    <div class="dropdown-menu m-0">
                        <a href="#" class="dropdown-item">User Account</a>
                        <a href="<c:url value="/logout"/>" class="py-2 px-4">LogOut</a>
                    </div>
                </div>
                <div class="mr-3" style="font-size: large; color: white;">
                    ${pageContext.request.userPrincipal.name}
                </div>
            </c:if>
            <div class="d-flex justify-content-center" style="width: 10%" id="nav-cart">
                <div class="cart">
                    <a href="<c:url value="/cart" />" class="ml-3 p-0 align-items-center ">
                        <i class="bi bi-basket fa-2x total-count" id="cartCounter1" value="${cartCounter}"></i>
                    </a>
                    <div class="collapse cart-detail" style="height: 80vh">
                        <section class="h-100" style="background-color: #eee; overflow: scroll;">
                            <div class="container h-100 py-5">
                                <div class="row d-flex justify-content-center align-items-center h-100">
                                    <div class="col-10">

                                        <div class="d-flex justify-content-between align-items-center mb-4">
                                            <h3 class="fw-normal mb-0 text-black">Shopping Cart</h3>
                                            <div>
                                                <p class="mb-0"><span class="text-muted">Sort by:</span> <a href="#!" class="text-body">price <i
                                                            class="fas fa-angle-down mt-1"></i></a></p>
                                            </div>
                                        </div>
                                        <div id="minicart">
                                            <c:if test="${cart != null}">
                                                <c:forEach items="${cart}" var="m">
                                                    <div class="card rounded-3 mb-4" id="product1${m.value.menuId}">
                                                        <div class="card-body p-4">
                                                            <div class="row d-flex justify-content-between align-items-center">
                                                                <div class="col-md-2 col-lg-2 col-xl-2 m-0 p-0">
                                                                    <img
                                                                        src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-shopping-carts/img1.webp"
                                                                        class="img-fluid rounded-3" alt="Cotton T-shirt">
                                                                </div>
                                                                <div class="col-md-4 col-lg-4 col-xl-4 m-0 p-2">
                                                                    <p class="lead mb-2" style="width: 100%">${m.value.menuName}</p>
                                                                    <p><span class="text-muted">Quantity: </span>${m.value.quantity}</p>
                                                                </div>
                                                                <div class="col-md-4 col-lg-3 col-xl-3 offset-lg-1 m-0 p-0">
                                                                    <span class="mb-0" style="width: 100%">${m.value.price}</span>
                                                                </div>
                                                                <div class="col-md-1 col-lg-1 col-xl-1 text-end m-0 p-0">
                                                                    <a href="#!" class="text-danger"><i class="fas fa-trash fa-lg" onclick="deleteCart(${m.value.menuId})"></i></a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </c:if>
                                        </div>

                                        <div class="card">
                                            <div class="card-body "style="margin: auto">
                                                <button type="button" class="btn btn-warning btn-block btn-lg" >Proceed to Pay</button>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </section>
                    </div>
                </div>
            </div>    
        </div>        
        <div class="container-fluid d-flex" id="nav-nd" style="display: none !important;">
            <a href="" class="navbar-brand p-3" style="margin-right: 4%" id="brand-nd">
                <h2 class="text-primary m-0"><i class="fa fa-utensils me-3"></i>Restoran</h2>
            </a>
            <form class="d-flex bg-white p-0  w-50" action="<c:url value="/menu" />">
                <input name="kw" class="form-control me-2" type="text" placeholder="Search" aria-label="Search"
                       style="border: none;">
                <button class="btn btn-danger" type="submit">Search</button>
            </form>
            <div class="d-flex justify-content-center" style="width: 20%">
                <div class="cart">
                    <a href="<c:url value="/cart" />" class="ml-3 p-0 align-items-center ">
                        <i class="bi bi-basket fa-2x total-count" id="cartCounter2" value="${cartCounter}"></i>
                    </a>
                    <div class="collapse cart-detail" style="height: 80vh">
                        <section class="h-100" style="background-color: #eee; overflow: scroll;">
                            <div class="container h-100 py-5">
                                <div class="row d-flex justify-content-center align-items-center h-100">
                                    <div class="col-10">

                                        <div class="d-flex justify-content-between align-items-center mb-4">
                                            <h3 class="fw-normal mb-0 text-black">Shopping Cart</h3>
                                            <div>
                                                <p class="mb-0"><span class="text-muted">Sort by:</span> <a href="#!" class="text-body">price <i
                                                            class="fas fa-angle-down mt-1"></i></a></p>
                                            </div>
                                        </div>
                                        <div id="minicart2">
                                            <c:if test="${cart != null}">
                                                <c:forEach items="${cart}" var="m">

                                                    <div class="card rounded-3 mb-4" id="product2${m.value.menuId}">
                                                        <div class="card-body p-4">
                                                            <div class="row d-flex justify-content-between align-items-center">
                                                                <div class="col-md-2 col-lg-2 col-xl-2 m-0 p-0">
                                                                    <img
                                                                        src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-shopping-carts/img1.webp"
                                                                        class="img-fluid rounded-3" alt="Cotton T-shirt">
                                                                </div>
                                                                <div class="col-md-4 col-lg-4 col-xl-4 m-0 p-2">
                                                                    <p class="lead mb-2" style="width: 100%">${m.value.menuName}</p>
                                                                    <p><span class="text-muted">Quantity: </span>${m.value.quantity}</p>
                                                                </div>
                                                                <div class="col-md-4 col-lg-3 col-xl-3 offset-lg-1 m-0 p-0">
                                                                    <span class="mb-0" style="width: 100%">${m.value.price}</span>
                                                                </div>
                                                                <div class="col-md-1 col-lg-1 col-xl-1 text-end m-0 p-0">
                                                                    <a href="#!" class="text-danger"><i class="fas fa-trash fa-lg"></i></a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </c:if>
                                            <c:if test="${cart == null}">
                                                <h1>Chua co san pham trong gio hang</h1>
                                            </c:if>
                                        </div>


                                        <div class="card">
                                            <div class="card-body "style="margin: auto">
                                                <button type="button" class="btn btn-warning btn-block btn-lg" >Proceed to Pay</button>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </section>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</div>
<!-- Navbar & Hero End -->

