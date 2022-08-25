<%-- 
    Document   : login
    Created on : Jul 22, 2022, 3:31:15 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>
            Register Store
        </title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
        <link href="resources/css/login.css" rel="stylesheet">
    </head>
    <body>
        <section class="vh-100">
            <div class="container py-5 h-100">
                <div class="row d-flex align-items-center justify-content-center h-100">
                    <div class="col-md-8 col-lg-7 col-xl-6">
                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg"
                             class="img-fluid" alt="Phone image">
                    </div>
                    <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">


                        <c:url value="/register-store" var="action" />

                        <form:form method="post" action="${action}" modelAttribute="user" enctype="multipart/form-data">
                            <form:errors path="*" cssClass="alert alert-danger" element="div" />

                            <div class="form-outline mb-4">
                                <label class="form-label" for="form1Example1234">First name</label>

                                <form:input type="text" id="form1Example1234" class="form-control form-control-lg" path="firstName"/>
                                <form:errors path="firstName" cssClass="alert alert-danger" element="div" />

                            </div>

                            <div class="form-outline mb-4">
                                <label class="form-label" for="form1Example1235">Last name</label>

                                <form:input type="text" id="form1Example1235" class="form-control form-control-lg" path="lastName"/>
                                <form:errors path="lastName" cssClass="alert alert-danger" element="div" />

                            </div>

                            <div class="form-outline mb-4">
                                <label class="form-label" for="namestore">Name Store</label>

                                <form:input type="text" id="namestore" class="form-control form-control-lg" path="nameStore"/>
                                <form:errors path="nameStore" cssClass="alert alert-danger" element="div" />

                            </div>

                            <div class="form-outline mb-4">
                                <label class="form-label" for="form1Example13">User name</label>

                                <form:input type="text" id="form1Example13" class="form-control form-control-lg" path="username"/>
                                <form:errors path="username" cssClass="alert alert-danger" element="div" />

                            </div>

                            <div class="form-outline mb-4">
                                <label class="form-label" for="form1Example23">Password</label>

                                <form:input type="password" id="form1Example23" class="form-control form-control-lg" path="password"/>
                                <form:errors path="password" cssClass="alert alert-danger" element="div" />

                            </div>

                            <div class="form-outline mb-4">
                                <label class="form-label" for="form1Example123">Confirm Password</label>

                                <form:input type="password" id="form1Example123" class="form-control form-control-lg" path="confirmPassword"/>
                                <form:errors path="confirmPassword" cssClass="alert alert-danger" element="div" />
                                <c:if test="${errMsg != null}">
                                    <div class="alert alert-danger">
                                        ${errMsg}
                                    </div>
                                </c:if>
                            </div>



                            <div class="form-outline mb-4">
                                <label class="form-label" for="email">Email</label>

                                <form:input type="text" id="email" class="form-control form-control-lg" path="email"/>
                                <form:errors path="email" cssClass="alert alert-danger" element="div" />

                            </div>

                            <div class="form-outline mb-4">
                                <label class="form-label" for="phone">Phone</label>

                                <form:input type="text" id="phone" class="form-control form-control-lg" path="phone"/>
                                <form:errors path="phone" cssClass="alert alert-danger" element="div" />

                            </div>

                            <div class="form-outline mb-4">
                                <label class="form-label" for="address">Address</label>

                                <form:input type="text" id="address" class="form-control form-control-lg" path="address"/>
                                <form:errors path="address" cssClass="alert alert-danger" element="div" />
                                <c:if test="${errMsgAddress != null}">
                                    <div class="alert alert-danger">
                                        ${errMsgAddress}
                                    </div>
                                </c:if>
                            </div>

                            <div class="form-outline mb-4">
                                <label class="form-label" for="form1Example12356">Avatar</label>

                                <form:input type="file" id="form1Example12356" class="form-control form-control-lg" path="file"/>
                                <form:errors path="file" cssClass="alert alert-danger" element="div" />

                            </div>

                            <button type="submit" class="btn btn-primary btn-lg btn-block btn-in-login">Register</button>

                        </form:form>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
