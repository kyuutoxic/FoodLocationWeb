<%-- 
    Document   : index
    Created on : Jul 21, 2022, 12:10:17 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Service Start -->
<div id="toast-container" class="position-fixed bottom-0 end-0 p-3" style="z-index: 1000"></div>
<div class="container-xxl py-5 bg-dark hero-header mb-5" id="banner-home">
    <div class="container my-5 py-5">
        <div class="row align-items-center g-5">
            <div class="col-md-7 col-lg-6 py-8 text-md-start text-center">
                <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light">Are you starving?</h1>
                <h1 class="text-800 mb-5 fs-4 text-light">Within a few clicks, find meals that<br class="d-none d-xxl-block">are accessible near you</h1>
                <div class="card w-xxl-75">
                    <div class="card-body">
                        <div class="tab-content mt-3" id="nav-tabContent">
                            <div class="tab-pane fade active show" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                                <form class="d-flex bg-white p-0" action="<c:url value="/menu" />">
                                    <input name="kw" class="form-control me-2" type="text" placeholder="Search" aria-label="Search"
                                           style="border: none;">
                                    <button class="btn btn-danger" type="submit">Search</button>
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
<div class="container-xxl py-5">
    <div class="container">
        <div class="row g-4">
            <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                <div class="service-item rounded pt-3">
                    <div class="p-4">
                        <i class="fa fa-3x fa-user-tie text-primary mb-4"></i>
                        <h5>Master Chefs</h5>
                        <p>Diam elitr kasd sed at elitr sed ipsum justo dolor sed clita amet diam</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.3s">
                <div class="service-item rounded pt-3">
                    <div class="p-4">
                        <i class="fa fa-3x fa-utensils text-primary mb-4"></i>
                        <h5>Quality Food</h5>
                        <p>Diam elitr kasd sed at elitr sed ipsum justo dolor sed clita amet diam</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.5s">
                <div class="service-item rounded pt-3">
                    <div class="p-4">
                        <i class="fa fa-3x fa-cart-plus text-primary mb-4"></i>
                        <h5>Online Order</h5>
                        <p>Diam elitr kasd sed at elitr sed ipsum justo dolor sed clita amet diam</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.7s">
                <div class="service-item rounded pt-3">
                    <div class="p-4">
                        <i class="fa fa-3x fa-headset text-primary mb-4"></i>
                        <h5>24/7 Service</h5>
                        <p>Diam elitr kasd sed at elitr sed ipsum justo dolor sed clita amet diam</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Service End -->
<!-- Menu Start -->
<div class="container-xxl py-5">
    <div class="container">
        <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
            <h5 class="section-title ff-secondary text-center text-primary fw-normal">Food Menu</h5>
            <h1 class="mb-5">Most Popular Items</h1>
        </div>
        <div class="tab-class text-center wow fadeInUp" data-wow-delay="0.1s">
            <ul class="nav nav-pills d-inline-flex justify-content-center border-bottom mb-5">
                <li class="nav-item">
                    <a class="d-flex align-items-center text-start mx-3 ms-0 pb-3 active" data-bs-toggle="pill" href="#tab-1">
                        <i class="fa fa-coffee fa-2x text-primary"></i>
                        <div class="ps-3">
                            <small class="text-body">Popular</small>
                            <h6 class="mt-n1 mb-0">Breakfast</h6>
                        </div>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="d-flex align-items-center text-start mx-3 pb-3" data-bs-toggle="pill" href="#tab-2">
                        <i class="fa fa-hamburger fa-2x text-primary"></i>
                        <div class="ps-3">
                            <small class="text-body">Special</small>
                            <h6 class="mt-n1 mb-0">Launch</h6>
                        </div>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="d-flex align-items-center text-start mx-3 me-0 pb-3" data-bs-toggle="pill" href="#tab-3">
                        <i class="fa fa-utensils fa-2x text-primary"></i>
                        <div class="ps-3">
                            <small class="text-body">Lovely</small>
                            <h6 class="mt-n1 mb-0">Dinner</h6>
                        </div>
                    </a>
                </li>
            </ul>
            <div class="tab-content">
                <div id="tab-1" class="tab-pane fade show p-0 active">
                    <div id="carouselExampleDark1" class="carousel carousel-dark slide" data-bs-ride="carousel">
                        <div class="carousel-indicators">
                            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
                            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
                        </div>
                        <div class="carousel-inner">
                            <div class="carousel-item active" data-bs-interval="10000">
                                <div class="row g-4">
                                    <div class="col-lg-2 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-1.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-2 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-2.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-2 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-3.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-2 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-4.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item" data-bs-interval="10000">
                                <div class="row g-4">
                                    <div class="col-lg-3 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-1.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-2.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-3.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-4.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item" ata-bs-interval="10000">
                                <div class="row g-4">
                                    <div class="col-lg-3 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-1.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-2.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-3.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-4.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <button class="carousel-control-prev carousel-control" type="button" data-bs-target="#carouselExampleDark1" data-bs-slide="prev">
                            <img class="carousel-control-icon" src="resources/img/prev.svg"/>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next carousel-control" type="button" data-bs-target="#carouselExampleDark1" data-bs-slide="next">
                            <img class="carousel-control-icon" src="resources/img/next.svg"/>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                </div>
                <div id="tab-2" class="tab-pane fade show p-0">
                    <div id="carouselExampleDark2" class="carousel carousel-dark slide" data-bs-ride="carousel">
                        <div class="carousel-indicators">
                            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
                            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
                        </div>
                        <div class="carousel-inner">
                            <div class="carousel-item active" data-bs-interval="10000">
                                <div class="row g-4">
                                    <div class="col-lg-2 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-1.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-2 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-2.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-2 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-3.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-2 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-4.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item" data-bs-interval="10000">
                                <div class="row g-4">
                                    <div class="col-lg-3 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-1.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-2.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-3.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-4.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item" ata-bs-interval="10000">
                                <div class="row g-4">
                                    <div class="col-lg-3 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-1.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-2.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-3.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-4.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <button class="carousel-control-prev carousel-control" type="button" data-bs-target="#carouselExampleDark2" data-bs-slide="prev">
                            <img class="carousel-control-icon" src="resources/img/prev.svg"/>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next carousel-control" type="button" data-bs-target="#carouselExampleDark2" data-bs-slide="next">
                            <img class="carousel-control-icon" src="resources/img/next.svg"/>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                </div>
                <div id="tab-3" class="tab-pane fade show p-0">
                    <div id="carouselExampleDark3" class="carousel carousel-dark slide" data-bs-ride="carousel">
                        <div class="carousel-indicators">
                            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
                            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
                        </div>
                        <div class="carousel-inner">
                            <div class="carousel-item active" data-bs-interval="10000">
                                <div class="row g-4">
                                    <div class="col-lg-2 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-1.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-2 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-2.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-2 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-3.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-2 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-4.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item" data-bs-interval="10000">
                                <div class="row g-4">
                                    <div class="col-lg-3 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-1.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-2.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-3.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-4.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item" ata-bs-interval="10000">
                                <div class="row g-4">
                                    <div class="col-lg-3 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-1.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-2.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-3.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/menu-4.png" alt="...">
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2">
                                            <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <button class="carousel-control-prev carousel-control" type="button" data-bs-target="#carouselExampleDark3" data-bs-slide="prev">
                            <img class="carousel-control-icon" src="resources/img/prev.svg"/>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next carousel-control" type="button" data-bs-target="#carouselExampleDark3" data-bs-slide="next">
                            <img class="carousel-control-icon" src="resources/img/next.svg"/>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<!-- Menu End -->
<!--Store list start-->
<div class="container-xxl py-5 wow fadeInUp" data-wow-delay="0.1s">
    <div class="container">
        <div class="text-center">
            <h5 class="section-title ff-secondary text-center text-primary fw-normal">Best Store</h5>
            <h1 class="mb-5">Most Popular Store</h1>
        </div>
        <div class="row" id="listmenu">

        </div>
    </div>
</div>
<!--Store list end-->
<!-- Testimonial Start -->
<div class="container-xxl py-5 wow fadeInUp" data-wow-delay="0.1s">
    <div class="container">
        <div class="text-center">
            <h5 class="section-title ff-secondary text-center text-primary fw-normal">Testimonial</h5>
            <h1 class="mb-5">Our Clients Say!!!</h1>
        </div>
        <div class="owl-carousel testimonial-carousel">
            <div class="testimonial-item bg-transparent border rounded p-4">
                <i class="fa fa-quote-left fa-2x text-primary mb-3"></i>
                <p>Dolor et eos labore, stet justo sed est sed. Diam sed sed dolor stet amet eirmod eos labore diam</p>
                <div class="d-flex align-items-center">
                    <img class="img-fluid flex-shrink-0 rounded-circle" src="resources/img/testimonial-1.jpg" style="width: 50px; height: 50px;">
                    <div class="ps-3">
                        <h5 class="mb-1">Client Name</h5>
                        <small>Profession</small>
                    </div>
                </div>
            </div>
            <div class="testimonial-item bg-transparent border rounded p-4">
                <i class="fa fa-quote-left fa-2x text-primary mb-3"></i>
                <p>Dolor et eos labore, stet justo sed est sed. Diam sed sed dolor stet amet eirmod eos labore diam</p>
                <div class="d-flex align-items-center">
                    <img class="img-fluid flex-shrink-0 rounded-circle" src="resources/img/testimonial-2.jpg" style="width: 50px; height: 50px;">
                    <div class="ps-3">
                        <h5 class="mb-1">Client Name</h5>
                        <small>Profession</small>
                    </div>
                </div>
            </div>
            <div class="testimonial-item bg-transparent border rounded p-4">
                <i class="fa fa-quote-left fa-2x text-primary mb-3"></i>
                <p>Dolor et eos labore, stet justo sed est sed. Diam sed sed dolor stet amet eirmod eos labore diam</p>
                <div class="d-flex align-items-center">
                    <img class="img-fluid flex-shrink-0 rounded-circle" src="resources/img/testimonial-3.jpg" style="width: 50px; height: 50px;">
                    <div class="ps-3">
                        <h5 class="mb-1">Client Name</h5>
                        <small>Profession</small>
                    </div>
                </div>
            </div>
            <div class="testimonial-item bg-transparent border rounded p-4">
                <i class="fa fa-quote-left fa-2x text-primary mb-3"></i>
                <p>Dolor et eos labore, stet justo sed est sed. Diam sed sed dolor stet amet eirmod eos labore diam</p>
                <div class="d-flex align-items-center">
                    <img class="img-fluid flex-shrink-0 rounded-circle" src="resources/img/testimonial-4.jpg" style="width: 50px; height: 50px;">
                    <div class="ps-3">
                        <h5 class="mb-1">Client Name</h5>
                        <small>Profession</small>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Testimonial End -->
<script src="<c:url value="/js/menu.js" />"></script>
<script>
    <c:url value="/api/store" var="endpoint" />
    <c:url value="/storec/" var="idmenu" />


    window.onload = function () {
        loadMenu('${endpoint}', '${idmenu}');
    }
</script>

