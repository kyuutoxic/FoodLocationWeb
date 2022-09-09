<%-- 
    Document   : footer
    Created on : Sep 6, 2021, 8:35:52 AM
    Author     : duonghuuthanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Footer Start -->
<div class="container-fluid bg-dark text-light footer pt-5 mt-5 wow fadeIn" data-wow-delay="0.1s">
    <div class="container py-5">
        <div class="row g-5">
            <div class="col-lg-3 col-md-6">
                <h4 class="section-title ff-secondary text-start text-primary fw-normal mb-4">Company</h4>
                <a class="btn btn-link" href="">About Us</a>
                <a class="btn btn-link" href="">Contact Us</a>
                <a class="btn btn-link" href="">Reservation</a>
                <a class="btn btn-link" href="">Privacy Policy</a>
                <a class="btn btn-link" href="">Terms & Condition</a>
            </div>
            <div class="col-lg-3 col-md-6">
                <h4 class="section-title ff-secondary text-start text-primary fw-normal mb-4">Contact</h4>
                <p class="mb-2"><i class="fa fa-map-marker-alt me-3"></i>123 Street, New York, USA</p>
                <p class="mb-2"><i class="fa fa-phone-alt me-3"></i>+012 345 67890</p>
                <p class="mb-2"><i class="fa fa-envelope me-3"></i>info@example.com</p>
                <div class="d-flex pt-2">
                    <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-twitter"></i></a>
                    <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-facebook-f"></i></a>
                    <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-youtube"></i></a>
                    <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-linkedin-in"></i></a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <h4 class="section-title ff-secondary text-start text-primary fw-normal mb-4">Opening</h4>
                <h5 class="text-light fw-normal">Monday - Saturday</h5>
                <p>09AM - 09PM</p>
                <h5 class="text-light fw-normal">Sunday</h5>
                <p>10AM - 08PM</p>
            </div>
            <div class="col-lg-3 col-md-6">
                <h4 class="section-title ff-secondary text-start text-primary fw-normal mb-4">Newsletter</h4>
                <p>Dolor amet sit justo amet elitr clita ipsum elitr est.</p>
                <div class="position-relative mx-auto" style="max-width: 400px;">
                    <input class="form-control border-primary w-100 py-3 ps-4 pe-5" type="text" placeholder="Your email">
                    <button type="button" class="btn btn-primary py-2 position-absolute top-0 end-0 mt-2 me-2">SignUp</button>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="copyright">
            <div class="row">
                <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                    &copy; <a class="border-bottom" href="#">Your Site Name</a>, All Right Reserved. 

                    <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                    Designed By <a class="border-bottom" href="https://htmlcodex.com">HTML Codex</a><br><br>
                    Distributed By <a class="border-bottom" href="https://themewagon.com" target="_blank">ThemeWagon</a>
                </div>
                <div class="col-md-6 text-center text-md-end">
                    <div class="footer-menu">
                        <a href="">Home</a>
                        <a href="">Cookies</a>
                        <a href="">Help</a>
                        <a href="">FQAs</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer End -->
<!--Chat button-->
<div class="chat btn-chat chat-text pb-2" onclick="initPage('${currentUser.username}',${currentUser.idUser});"><i class="bi bi-chat-right-dots-fill"></i>&nbsp;Chat</div>
<div class="chat table-chat pb-2">
    <div class="d-flex bd-highlight chat-text">
        <div class="p-2 flex-grow-1 bd-highlight">Chat</div>
        <div class="p-2 bd-highlight" role="button" id="colapseChat"><i class="bi bi-arrow-right-square"></i></div>
        <div class="p-2 bd-highlight" role="button" id="unColapseChat" style="display: none;"><i class="bi bi-arrow-left-square"></i></div>
        <div class="p-2 bd-highlight" role="button" id="closeChat"><i class="bi bi-x-square"></i></div>
    </div>
    <div class="row table-chat-container">
        <div class="col-3 table-chat-list">
            <!--<div class="list-chat"><img src="${currentUser.avatar}" alt="hihi"></div>-->
        </div>
        <div class="col-9 table-chat-content">
            <div class="table-content-chat"></div>
            <div class="table-box-chat">
                <input type="text" id="box-chat">
                <button class="btn btn-primary" type="button" id="btn-send-chat">Send</button>
            </div>
        </div>
    </div>
</div>
<!-- Back to Top -->
<a href="#1" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
