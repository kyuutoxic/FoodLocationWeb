<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="app-main__outer">
    <div class="app-main__inner"> 
        <section style="margin: 50px 0;">
            <c:url value="/store/account-store/" var="action"/>
            <form:form class="" action="${action}" method="post" modelAttribute="user" enctype="multipart/form-data">
                <div class="form-row">
                    <div class="col-md-3">
                        <div class="position-relative form-group">
                            <label for="firstname" class="">First name</label>
                            <form:input id="firstname" type="text" class="form-control" value="${user.firstName}" path="firstName"/>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="position-relative form-group">
                            <label for="lastname" class="">Last name</label>
                            <form:input id="lastname" type="text" class="form-control" value="${user.lastName}" path="lastName"/>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="position-relative form-group">
                            <label for="namestore" class="">Name store</label>
                            <form:input id="namestore" type="text" class="form-control" value="${user.nameStore}" path="nameStore"/>
                        </div>
                    </div>    
                    <div class="col-md-6">
                        <div class="position-relative form-group">
                            <label for="shipprice" class="">Ship Price</label>
                            <form:input id="shipprice" type="text" class="form-control" value="${user.shipPrice}" path="shipPrice"/>
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
                            <label class="form-label" for="iframe">Iframe Google Maps</label>
                            <form:input type="text" id="iframe" class="form-control form-control-lg" path="userIframe"/>
                            <em>*Go to <a href="#" id="link-maps">https://www.google.com/maps</a> and follow this step. search your address</em>
                            <br>
                            <em>Step 1. Search your address</em>
                            <br>
                            <em>Step 2. Click the share button on the table on left side of the screen</em>
                            <br>
                            <em>Step 3. Choose Embed the map tab and copy the HTML</em>
                            <br>
                            <em>Step 4. After that, paste the HTML in this box</em>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="position-relative form-group">
                            <label class="form-label" for="file">
                                Avatar
                                <div class="position-relative form-group">
                                    <img src="${user.avatar}" alt="alt" style="max-height: 25%;max-width: 25%" />
                                </div>
                            </label>
                            <form:input type="file" id="file" class="form-control form-control-lg" path="file"/>
                        </div>
                    </div>
                </div>
                <button type="submit" class="mt-2 btn btn-primary">Update</button>
            </form:form>
        </section>
    </div>
</div>
<script>
    $('#link-maps').click(function (e) {
        e.preventDefault();
        window.open('https://www.google.com/maps', '_blank').focus();
    })
</script>
