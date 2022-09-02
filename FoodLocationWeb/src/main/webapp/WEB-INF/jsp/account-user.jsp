<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container-xxl py-5" >
    <div style="margin: 50px 0;">
        <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item" role="presentation">
                <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">Profile</button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link" id="contact-tab" data-bs-toggle="tab" data-bs-target="#follow" type="button" role="tab" aria-controls="contact" aria-selected="false">Follow</button>
            </li>
        </ul>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade show active" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                <section >
                    <c:url value="/account-user/" var="action"/>
                    <form:form class="" action="${action}" method="post" modelAttribute="user" enctype="multipart/form-data">
                        <div class="form-row">
                            <div class="col-md-6">
                                <div class="position-relative form-group">
                                    <label for="firstname" class="">First name</label>
                                    <form:input id="firstname" type="text" class="form-control" value="${user.firstName}" path="firstName"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="position-relative form-group">
                                    <label for="lastname" class="">Last name</label>
                                    <form:input id="lastname" type="text" class="form-control" value="${user.lastName}" path="lastName"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="position-relative form-group">
                                    <label for="phone" class="">Phone</label>
                                    <form:input id="phone" class="form-control" type="text" value="${user.phone}" path="phone"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="position-relative form-group">
                                    <label for="address" class="">Address</label>
                                    <form:input id="address" class="form-control" placeholder="1234 Main St" type="text" value="${user.address}" path="address" />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="position-relative form-group">
                                    <label for="email" class="">Email</label>
                                    <form:input id="email" class="form-control" placeholder="Apartment, studio, or floor" type="text" value="${user.email}" path="email" />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="position-relative form-group">
                                    <label class="form-label" for="file">Avatar</label>
                                    <form:input type="file" id="file" class="form-control form-control-lg" path="file"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="position-relative form-group">
                                    <img src="${user.avatar}" alt="alt" style="max-height: 25%;max-width: 25%" />
                                </div>
                            </div>
                        </div>
                        <button type="submit" class="mt-2 btn btn-primary">Update</button>
                    </form:form>
                </section>
            </div>
            <div class="tab-pane fade" id="follow" role="tabpanel" aria-labelledby="contact-tab">
                <div id="listfollow">

                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value="/js/menu.js" />"></script>
<script>
    <c:url value="/storec/" var="idmenu" />

    window.onload = function () {
        loadFollowByUser('${idmenu}', '${currentUser.idUser}');
    }
</script>