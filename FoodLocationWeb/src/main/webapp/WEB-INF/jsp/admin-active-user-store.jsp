<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="app-main__outer">
    <div class="app-main__inner">
        <div class="tab-content">
            <div class="tab-pane tabs-animation fade show active" id="tab-content-0" role="tabpanel">
                <div class="main-card mb-3 card">
                    <div class="card-body"><h5 class="card-title">Grid Rows</h5>
                        <c:url value="/admin/active-user-store/${idUser}" var="action"/>
                        <form:form class="" action="${action}" method="post" modelAttribute="userStoreNotActive">
                            <input type="hidden" name="_method" value="PUT">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <div class="position-relative form-group"><label for="exampleEmail11" class="">Name Store</label><form:input name="email" id="exampleEmail11" placeholder="with a placeholder" type="text" class="form-control" value="${userStore.nameStore}" path="nameStore"/></div>
                                </div>
                                <div class="col-md-6">
                                    <div class="position-relative form-group"><label for="examplePassword11" class="">Phone</label><form:input name="password" id="examplePassword11" placeholder="password placeholder" type="text" value="${userStore.phone}" path="phone"
                                                                                                                                             class="form-control"/></div>
                                </div>
                            </div>
                                    <div class="position-relative form-group"><label for="exampleAddress" class="">Address</label><form:input name="address" id="exampleAddress" placeholder="1234 Main St" type="text" class="form-control" value="${userStore.address}" path="address" /></div>
                                    <div class="position-relative form-group"><label for="exampleAddress2" class="">Email</label><form:input name="address2" id="exampleAddress2" placeholder="Apartment, studio, or floor" type="text" class="form-control" value="${userStore.email}" path="email" />
                            </div>
                            <button class="mt-2 btn btn-primary">Sign in</button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>