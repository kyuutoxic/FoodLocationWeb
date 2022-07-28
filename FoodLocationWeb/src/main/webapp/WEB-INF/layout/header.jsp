<%-- 
    Document   : header
    Created on : Sep 6, 2021, 8:35:44 AM
    Author     : duonghuuthanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Navbar & Hero Start -->
<div class="container-xxl position-relative p-0">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark px-4 px-lg-5 py-3 py-lg-0">
        <a href="" class="navbar-brand p-0">
            <h1 class="text-primary m-0"><i class="fa fa-utensils me-3"></i>Restoran</h1>
            <!-- <img src="img/logo.png" alt="Logo"> -->
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
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Pages</a>
                    <div class="dropdown-menu m-0">
                        <a href="booking.html" class="dropdown-item">Booking</a>
                        <a href="team.html" class="dropdown-item">Our Team</a>
                        <a href="testimonial.html" class="dropdown-item">Testimonial</a>
                    </div>
                </div>
                <a href="contact.html" class="nav-item nav-link">Contact</a>
            </div>
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <a href="<c:url value="/login"/>" class="btn btn-primary py-2 px-4">Login</a>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <a href="<c:url value="/logout"/>" class="btn btn-primary py-2 px-4">LogOut</a>
            </c:if>
        </div>
    </nav>

    <div class="container-xxl py-5 bg-dark hero-header mb-5">
        <div class="container my-5 py-5">
            <div class="row align-items-center g-5">
                <div class="col-md-7 col-lg-6 py-8 text-md-start text-center">
                    <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light">Are you starving?</h1>
                    <h1 class="text-800 mb-5 fs-4 text-light">Within a few clicks, find meals that<br class="d-none d-xxl-block">are accessible near you</h1>
                    <div class="card w-xxl-75">
                        <div class="card-body">
                            <div class="tab-content mt-3" id="nav-tabContent">
                                <div class="tab-pane fade active show" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                                    <form class="row gx-2 gy-2 align-items-center">
                                        <div class="col">
                                            <div class="input-group-icon"><i class="fas fa-map-marker-alt text-danger input-box-icon"></i><label class="visually-hidden" for="inputDelivery">Address</label><input class="form-control input-box form-foodwagon-control" id="inputDelivery" type="text" placeholder="Enter Your Address"></div>
                                        </div>
                                        <div class="d-grid gap-3 col-sm-auto"><button class="btn btn-danger" type="submit">Find Food</button></div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-5 col-lg-6 text-center text-lg-end overflow-hidden">
                    <img class="img-fluid" src="resources/img/hero.png" alt="">
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Navbar & Hero End -->

