<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container-xxl py-5">
    <section style="margin: 50px 0;">
        <h1>${usercustom}</h1>
        <c:url value="/account-user/${currentUser.idUser}" var="action"/>
        <form:form class="" action="${action}" method="post" modelAttribute="user">
            <div class="form-row">
                <div class="col-md-6" style="display: none">
                    <div class="position-relative form-group">
                        <form:input name="username" id="username" placeholder="with a placeholder" type="text" class="form-control" value="${user.username}" path="username"/>
                    </div>
                </div>
                <div class="col-md-6" style="display: none">
                    <div class="position-relative form-group">
                        <form:input name="password" id="password" placeholder="with a placeholder" type="text" class="form-control" value="${user.firstName}" path="password"/>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="position-relative form-group">
                        <label for="firstname" class="">First name</label>
                        <form:input name="firstname" id="firstname" placeholder="with a placeholder" type="text" class="form-control" value="${user.firstName}" path="firstName"/>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="position-relative form-group">
                        <label for="lastname" class="">Last name</label>
                        <form:input name="lastname" id="lastname" placeholder="with a placeholder" type="text" class="form-control" value="${user.lastName}" path="lastName"/>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="position-relative form-group">
                        <label for="examplePassword11" class="">Phone</label>
                        <form:input name="password" id="examplePassword11" placeholder="password placeholder" type="text" value="${user.phone}" path="phone" class="form-control"/>
                    </div>
                </div>
            </div>
            <div class="position-relative form-group">
                <label for="exampleAddress" class="">Address</label>
                <form:input name="address" id="exampleAddress" placeholder="1234 Main St" type="text" class="form-control" value="${user.address}" path="address" />
            </div>
            <div class="position-relative form-group">
                <label for="exampleAddress2" class="">Email</label>
                <form:input name="address2" id="exampleAddress2" placeholder="Apartment, studio, or floor" type="text" class="form-control" value="${user.email}" path="email" />
            </div>
            <div class="position-relative form-group">
                <label class="form-label" for="form1Example12356">Avatar</label>

                <form:input type="file" id="form1Example12356" class="form-control form-control-lg" path="file"/>
            </div>
            <div class="position-relative form-group">
                <img src="${user.avatar}" alt="alt" style="max-height: 25%;max-width: 25%" />
            </div>

            <button class="mt-2 btn btn-primary">Update</button>
        </form:form>
    </section>
</div>