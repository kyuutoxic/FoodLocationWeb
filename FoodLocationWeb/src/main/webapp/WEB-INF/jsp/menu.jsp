<%-- 
    Document   : menu
    Created on : Aug 19, 2022, 11:36:56 PM
    Author     : Copeoshihi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<c:url value="resources/img/hero.png"/>--%>
<!--style="background: url('');"-->
<div id="toast-container" class="position-fixed bottom-0 end-0 p-3" style="z-index: 1000"></div>
<div >
    <div class="row g-4" style="padding: 120px 20px; margin: 0.5px 0;">
        <div class="card w-xxl-75" style="">
            <div class="card-body row">
                <h1 class="col-4" style="margin: 0; padding: 15px 0 0 30px; text-align: center;">MENU PAGE</h1>
                <div class="tab-content mt-3 col-8" id="nav-tabContent">
                    <div class="tab-pane fade active show" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                        <form class="d-flex bg-white p-0  w-75" action="<c:url value="/menu" />">
                            <input name="kw" class="form-control me-2" type="text" placeholder="Search" aria-label="Search"
                                   style="border: none;">
                            <button class="btn btn-danger" type="submit">Search</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div>
            <span style="display: flex; justify-content: space-around; position: relative; float: right; width: 25%;">
                <a href onclick="addSortParameter('desc'); return false;"><p>Price<i class="bi bi-arrow-bar-down"></i></p></a>
                <a href onclick="addSortParameter('asc'); return false;"><p>Price<i class="bi bi-arrow-bar-up"></i></p></a>
                <a href class="showModal" datatarget="add-type-form">Type</a>
            </span>
        </div>
        <div class="myModal" id="add-type-form">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
                        <button type="button" class="btn-close" aria-label="Close" datatarget="add-type-form" dataaction="close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" value="All day" name="type" id="All day" checked>
                            <label class="form-check-label" for="All day">
                                All day
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" value="Morning" name="type" id="Morning">
                            <label class="form-check-label" for="Morning">
                                Morning
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" value="Noon" name="type" id="Noon">
                            <label class="form-check-label" for="Noon">
                                Noon
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" value="Afternoon" name="type" id="Afternoon">
                            <label class="form-check-label" for="Afternoon">
                                Afternoon
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" value="Evening" name="type" id="Evening">
                            <label class="form-check-label" for="Evening">
                                Evening
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" value="Night" name="type" id="Night">
                            <label class="form-check-label" for="Night">
                                Night
                            </label>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" datatarget="add-type-form" dataaction="close">Close</button>
                        <button type="button" class="btn btn-primary" datatarget="add-type-form" dataaction="send" onclick="addTypeParameter()">Sort</button>
                    </div>
                </div>
            </div>
        </div>                
        <fmt:formatDate type="time" timeStyle="short" value="<%=new java.util.Date()%>" timeZone="GMT+7" pattern="HH:mm" var="now"/>                    
        <c:forEach var="p" items="${products}">
            <div class="col-lg-2 col-sm-6 col-md-4 mb-5">
                <div class="card card-span rounded-3"><img class="img-fluid rounded-3 " src="${p.image}" alt="...">
                    <div class="card-body ps-0" style="min-height: 130px">
                        <h5 class="fw-bold text-1000 text-truncate mb-1" title="${p.menuName}">${p.menuName}</h5>
                        <a href="<c:url value="/storec/${p.idStore.idUser}" />">
                            <div>
                                <span class="text-warning me-2">
                                    <i class="fas fa-map-marker-alt"></i>
                                </span>
                                <span class="text-primary">${p.idStore.nameStore}
                                </span>
                            </div>
                            <span class="text-1000 fw-bold">
                                <fmt:formatNumber type="number" value="${p.price}" maxFractionDigits="2" />
                            </span>
                            <span>&nbsp;VND</span>
                        </a>
                    </div>
                </div>
                <c:choose>
                    <c:when test="${p.menuStatus == true && p.menuFrom le now && p.menuTo ge now}">
                        <div class="d-grid gap-2">
                            <a class="btn btn-lg btn-danger menu-order" href="#" role="button" onclick="addToCart(${p.idMenu}, '${p.menuName}', ${p.price}, '${p.image}');">Order now</a>
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="d-grid gap-2" style="text-align: center">
                            <h5>Served from ${p.menuFrom} to ${p.menuTo}</h5>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </c:forEach>
        <ul class="pagination">
            <c:forEach begin="1" end="${Math.ceil(productCounter/9)}" var="page">
                <li class="page-item"><a class="page-link" href onclick="addPageParameter(${page}); return false;">${page}</a></li>
            </c:forEach>
        </ul>
    </div>
</div>
                        <!--href="<c:url value="/menu" />?page=${page}"-->