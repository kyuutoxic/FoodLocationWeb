<%-- 
    Document   : product
    Created on : Aug 11, 2022, 7:03:22 PM
    Author     : Copeoshihi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<div id="toast-container" class="position-fixed bottom-0 end-0 p-3" style="z-index: 1000"></div>
<div class="container-xxl" style="padding-top: 100px; position: relative;" data-spy="scroll" id="list-home">
    <div class="row" style="margin: 15px 0; height: 400px">
        <div class="col-5" style="text-align: center;height: 400px;">
            <img src="${store.avatar}" alt="alt" style="max-height: 100%;max-width: 100%;"/>
        </div>
        <div class="col-7">
            <div aria-label="breadcrumb" style="--bs-breadcrumb-divider: '>';">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="#">TP.HCM</a></li>
                    <li class="breadcrumb-item"><a href="#">Quận 5</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Khu vực cầu Nguyễn Tri Phương</li>
                </ol>
            </div>
            <h4>${store.nameStore}</h4>
            <div class="category">
                <div>Ăn chay</div>
                <div>- Món Việt</div>
                <div>- Gia đình</div>
            </div>
            <div class="point row">
                <div class="col">
                    <div>9.7</div>
                </div>
                <div class="col">
                    <div>10.0</div>
                    <div>Chất lượng</div>
                </div>
                <div class="col">
                    <div>10.0</div>
                    <div>Phục vụ</div>
                </div>
                <div class="col">
                    <div>10.0</div>
                    <div>Không gian</div>
                </div>
                <div class="col">
                    <div>10.0</div>
                    <div>Giá cả</div>
                </div>
                <div class="col">
                    <div>10.0</div>
                    <div>Vị trí</div>
                </div>
                <div class="col">
                    <div>10</div>
                    <div>Bình luận</div>
                </div>
            </div>
            <div class="info-store">
                <div>
                    <span class="fa fa-location-arrow locationicon"></span>
                    <span>${store.address}</span>
                    <span class="fa fa-map"></span>
                </div>
                <div>
                    <span class="bi bi-clock"></span>
                    <span>Chưa mở cửa  11:00 - 13:00</span>
                    <span class="fa fa-exclamation-circle opening-time-btn"></span>
                </div>
                <div>
                    <span class="fa fa-tag minmaxpriceicon"></span>
                    <span>15.000đ - 20.000đ</span>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-3">
            <div class="list-group store-info-scroll" id="list-tab">
                <a class="list-group-item list-group-item-action active" href="#list-home">Home</a>
                <a class="list-group-item list-group-item-action" href="#list-menu">Menu</a>
                <a class="list-group-item list-group-item-action" href="#list-pic">Picture & Video</a>
                <a class="list-group-item list-group-item-action" href="#list-cmt">Comment</a>
                <a class="list-group-item list-group-item-action" href="#list-map">Map</a>
            </div>
        </div>
        <div class="col-9">
            <div class="row store-info-contact">
                <div class="col-2">
                    <a href="#">
                        <span class="fa fa-phone-alt"></span>
                        <span>Gọi điện thoại</span>
                    </a>
                </div>
                <div class="col-4">
                    <a href="#">
                        <span class="fa fa-bookmark"></span>
                        <span>Lưu vào Bộ sưu tập (52)</span>
                    </a>
                </div>
                <div class="col-2">
                    <a href="#" class="showModal" datatarget="add-cmt-form">
                        <span class="fa fa-comment"></span>
                        <span>Bình luận</span>
                    </a>
                </div>
                <div class="myModal" id="add-cmt-form">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
                                <button type="button" class="btn-close" aria-label="Close" datatarget="add-cmt-form" dataaction="close"></button>
                            </div>
                            <div class="modal-body">
                                <form>
                                    <!--                                    <div class="mb-3" style="text-align: left">
                                                                            <label for="recipient-name">Nhan xet chung:</label>
                                                                            <input type="text" class="form-control" id="recipient-name">
                                                                        </div>-->
                                    <div class="mb-3" style="text-align: left">
                                        <label for="message-text">Nhan xet:</label>
                                        <textarea class="form-control" id="message-text"></textarea>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" datatarget="add-cmt-form" dataaction="close">Close</button>
                                        <button type="button" class="btn btn-primary" datatarget="add-cmt-form" dataaction="send" onclick="addComment(${store.idUser},${currentUser.idUser})">Send</button>
                                    </div>
                                </form>
                            </div>

                        </div>
                    </div>
                </div>

                <div class="col-2">
                    <a href="#">
                        <span class="fa fa-camera"></span>
                        <span>Hình ảnh</span>
                    </a>
                </div>
                <div class="col-2">
                    <a href="#">
                        <span class="fa fa-share-alt"></span>
                        <span>Chia sẻ</span>
                    </a>
                </div>
            </div>
            <div id="list-menu">
                <h1>Menu</h1>
                <div class="list-menu row">
                    <fmt:formatDate type="time" timeStyle="short" value="<%=new java.util.Date()%>" timeZone="GMT+7" pattern="HH:mm" var="now"/>
                    <c:forEach items="${menu}" var="m">
                        <div class="menu-list col-6 row">
                            <div class="col-3">
                                <img src="<c:url value="${m.image}"/>" alt="alt"/>
                            </div>
                            <div class="col-6">
                                <div class="menu-name">${m.menuName}</div>
                            </div>
                            <div class="col-3">
                                <c:choose>
                                    <c:when test="${m.menuStatus == true && m.menuFrom le now && m.menuTo ge now}">
                                        <div class="menu-cost">
                                            ${m.price}
                                            <button class="menu-order" onclick="addToCart(${m.idMenu}, '${m.menuName}', ${m.price});toast();">+</button>
                                        </div>
                                    </c:when>    
                                    <c:otherwise>
                                        <div class="menu-cost">
                                            ${m.price}
                                            <p>Served from ${m.menuFrom} to ${m.menuTo}</p>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div id="list-pic">
                <h1 style="display: contents;">Pictures & Videos</h1>
                <span style="float: right; margin: 10px;"><a href="#">Xem tất cả >></a></span>
                <div class="row">
                    <div class="col-2">
                        <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                    </div>
                    <div class="col-2">
                        <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                    </div>
                    <div class="col-2">
                        <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                    </div>
                    <div class="col-2">
                        <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                    </div>
                    <div class="col-2">
                        <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                    </div>
                    <div class="col-2">
                        <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                    </div>
                    <div class="col-2">
                        <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                    </div>
                    <div class="col-2">
                        <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                    </div>
                    <div class="col-2">
                        <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                    </div>
                    <div class="col-2">
                        <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                    </div>
                    <div class="col-2">
                        <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                    </div>
                    <div class="col-2">
                        <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                    </div>
                    <div class="col-2">
                        <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                    </div>
                    <div class="col-2">
                        <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                    </div>
                    <div class="col-2">
                        <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                    </div>
                    <div class="col-2">
                        <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                    </div>
                    <div class="col-2">
                        <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                    </div>
                    <div class="col-2">
                        <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                    </div>
                    <div class="col-2">
                        <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                    </div>
                    <div class="col-2">
                        <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                    </div>
                    <div class="col-2">
                        <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                    </div>
                    <div class="col-2">
                        <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                    </div>
                    <div class="col-2">
                        <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                    </div>
                    <div class="col-2">
                        <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                    </div>
                </div>
            </div>
            <div id="list-cmt" >
                <c:forEach items="${comments}" var="comment">

                    <div class="cmt-list">
                        <div class="info-comment">
                            <div class="info-comment-info">
                                <img src="<c:url value="${comment.idUser.avatar}"/>" alt="alt" class="avatar"/>
                                <div>
                                    <div style="font-weight: 500; color: black;">${comment.idUser.firstName} ${comment.idUser.lastName}</div>
                                    <div>${comment.createdDate}</div>
                                </div>
                            </div>
                            <div class="avg-point">9.3</div>
                        </div>
                        <div class="content-comment">
                            <div class="header-content">${comment.content}</div>
                            <!--                            <div class="body-content">
                                                            Cà phê brewing hand drip chuẩn vị Nhật nhưng hay hết món lắm, 2 loại bánh mà t thích cũng vậy (bánh bơ tỏi và việt quất). Dãy bàn ghế êm thích hợp học tập làm việc (thi thoảng có nhóm khách đi đông thì ồn). Máy cà thẻ đôi khi hay bị hư nên khá bất tiện cho người ko có Momo và tiền mặt (dạo này hình như đỡ rồi).
                                                            PS. Hình chụp em mèo ko biết của quán hay sao nữa
                                                        </div>-->
                            <div class="media-content">
                                <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                                <img src="<c:url value="/resources/img/menu-1.png"/>" alt="alt"/>
                            </div>
                        </div>
                        <div class="interaction-comment">
                            <i class="bi bi-heart-fill">Like</i>
                            <i class="bi bi-chat-fill">Comment</i>
                            <i class="bi bi-exclamation-triangle-fill">Report</i>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div id="list-map">
                <h1>Map</h1>
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.9356596756443!2d106.67562481485712!3d10.81623586141513!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317528e19559e523%3A0x8e4133bdb1373cc9!2zTmd1eeG7hW4gS2nhu4dtLCBQaMaw4budbmcgMywgR8OyIFbhuqVwLCBUaMOgbmggcGjhu5EgSOG7kyBDaMOtIE1pbmgsIFZp4buHdCBOYW0!5e0!3m2!1svi!2s!4v1660459258471!5m2!1svi!2s" 
                        width="700" height="450" style="border:0;" 
                        allowfullscreen="true" 
                        loading="lazy" 
                        referrerpolicy="no-referrer-when-downgrade">
                </iframe>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value="/js/menu.js" />"></script>
