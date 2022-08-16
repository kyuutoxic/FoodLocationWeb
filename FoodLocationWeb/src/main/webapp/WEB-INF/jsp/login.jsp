<%-- 
    Document   : login
    Created on : Jul 22, 2022, 3:31:15 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-w------------------------------------------------------------------------------------------------------------------------idth, initial-scale=1.0">
        <title>
            Login
        </title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
        <link href="../resources/css/login.css" rel="stylesheet">
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
                        <c:if test="${params.error != null}">
                            <div class="alert alert-danger">
                                Da co loi xay ra
                            </div>
                        </c:if>
                        <c:if test="${params.accessDenied != null}">
                            <div class="alert alert-danger">
                                Khong co quuyen truy cap
                            </div>
                        </c:if>
                        <c:url value="/login" var="action" />

                        <form action="${action}" method="post">
                            <!-- Email input -->
                            <div class="form-outline mb-4">
                                <input type="text" id="form1Example13" class="form-control form-control-lg" name="username"/>
                                <label class="form-label" for="form1Example13">User name</label>
                            </div>

                            <!-- Password input -->
                            <div class="form-outline mb-4">
                                <input type="password" id="form1Example23" class="form-control form-control-lg" name="password"/>
                                <label class="form-label" for="form1Example23">Password</label>
                            </div>

                            <div class="d-flex justify-content-around align-items-center mb-4">
                                <!--Checkbox--> 
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="form1Example3" checked />
                                    <label class="form-check-label" for="form1Example3"> Remember me </label>
                                </div>
                                <a href="#!">Forgot password?</a>
                            </div>

                            <!-- Submit button -->
                            <button type="submit" class="btn btn-primary btn-lg btn-block btn-in-login">Sign in</button>

                            <div class="divider d-flex align-items-center my-4">
                                <p class="text-center fw-bold mx-3 mb-0 text-muted">OR</p>
                            </div>

                            <a class="btn btn-primary btn-lg btn-block btn-in-login" style="background-color: #3b5998" href="#!"
                               role="button">
                                <i class="fab fa-facebook-f me-2"></i>Continue with Facebook
                            </a>
                            <a class="btn btn-primary btn-lg btn-block btn-in-login" style="background-color: #55acee" href="#!"
                               role="button">
                                <i class="fab fa-twitter me-2"></i>Continue with Twitter</a>

                            <div class="d-flex align-items-center justify-content-center pb-4 btn-in-login">
                                <p class="mb-0 me-2">Don't have an account?</p>
                                <a class="btn btn-outline-danger btn-block" href="<c:url value="/choose-register" />">Create new</a>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
