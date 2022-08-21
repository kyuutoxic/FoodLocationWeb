<%-- 
    Document   : menu
    Created on : Aug 19, 2022, 11:36:56 PM
    Author     : Copeoshihi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<c:url value="resources/img/hero.png"/>--%>
<!--style="background: url('');"-->
<div id="toast-container" class="position-fixed bottom-0 end-0 p-3" style="z-index: 1000"></div>
<div >
    <div class="row g-4" style="padding: 120px 20px; margin: 0.5px 0;">
        <div>
            <div class="card w-xxl-75" style="">
                <div class="card-body row">
                    <h1 class="col-4" style="margin: 0; padding: 15px 0 0 30px; text-align: center;">MENU PAGE</h1>
                    <div class="tab-content mt-3 col-5" id="nav-tabContent">
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
        <c:forEach var="p" items="${products}">
            <div class="col-lg-2 col-sm-6 col-md-4 mb-5">
                <div class="card card-span rounded-3"><img class="img-fluid rounded-3 " src="${p.image}" alt="...">
                    <div class="card-body ps-0" style="min-height: 130px">
                        <h5 class="fw-bold text-1000 text-truncate mb-1">${p.menuName}</h5>
                        <a href="<c:url value="/storec/${p.idStore.idUser}" />"><div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">${p.idStore.nameStore}</span></div><span class="text-1000 fw-bold">${p.price}</span></a>
                    </div>
                </div>
                <div class="d-grid gap-2">
                    <a class="btn btn-lg btn-danger menu-order" href="#!" role="button">Order now</a>
                </div>
            </div>
        </c:forEach>



    </div>
</div>