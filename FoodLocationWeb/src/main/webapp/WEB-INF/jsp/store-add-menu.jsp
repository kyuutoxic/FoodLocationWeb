<%-- 
    Document   : admin-add-product
    Created on : Aug 12, 2022, 2:17:48 PM
    Author     : kyuut
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="app-main__outer">
    <div class="app-main__inner">
        <h5 class="card-title">Controls Types</h5>
        <c:url value="/store/add-menu" var="action" />
        <form:form method="post" action="${action}" modelAttribute="menu" enctype="multipart/form-data">
            <div class="position-relative form-group">
                <label for="name" class="">Name</label>
                <form:input id="name" type="text" class="form-control" path="menuName" />
                <form:errors path="menuName" cssClass="alert alert-danger" element="div" />
            </div>
            <div class="position-relative form-group">
                <label for="price" class="">Price</label>
                <form:input id="price" type="number" class="form-control" path="price" />
                <form:errors path="price" cssClass="alert alert-danger" element="div" />
            </div>  
            <div class="position-relative form-group">
                <label for="note" class="">Note</label>
                <form:textarea id="note" class="form-control" path="menuNote"/>
            </div>
            <div class="position-relative form-group">
                <label for="typeId" class="">Type Menu</label>
                <form:select class="form-control" path="typeId" id="typeId">
                    <c:forEach var="t" items="${type}">
                        <form:option value="${t.id}">${t.name}</form:option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="position-relative form-group">
                <label for="from" class="">From</label>
                <form:input id="from" type="time" class="form-control" path="menuFrom" />
            </div>
            <div class="position-relative form-group">
                <label for="to" class="">To</label>
                <form:input id="to" type="time" class="form-control" path="menuTo" />
            </div>
            <div class="position-relative form-group">
                <label for="file" class="">Image</label>
                <form:input type="file" class="form-control-file" path="file" />
                <form:errors path="file" cssClass="alert alert-danger" element="div" />
            </div>
            <button id="submit" type="submit" class="btn btn-primary btn-lg btn-block btn-in-login">Submit</button>

        </form:form>
    </div>
</div>
<script>
    function setTime(){
        let time = $('#typeId').find(":selected").val();
        console.log(time);
        switch(time) {
            case "1":
              $('#from').val("07:00");
              $('#to').val("23:00");
              break;
            case "2":
              $('#from').val("07:00");
              $('#to').val("11:00");
              break;
            case "3":
              $('#from').val("11:00");
              $('#to').val("14:00");
              break;
            case "4":
              $('#from').val("14:00");
              $('#to').val("18:00");
              break;
            case "5":
              $('#from').val("18:00");
              $('#to').val("23:00");
              break;
            case "6":
              $('#from').val("23:00");
              $('#to').val("04:00");
              break;
            case "7":
              $('#from').val("");
              $('#to').val("");
              break;
            default:
              console.log(time);
        }
    }
    
    $(document).ready(function(){
        setTime();
        $('#typeId').change(function(){
            setTime();
        });
        $('#submit').click(function(){
            $('body').append(`
                <div class="loading-page" style="display: flex; justify-content: center; align-items: center; position: fixed; z-index: 1100; width: 100%; height: 100%; top:0; left: 0; background-color: white; opacity: 0.8;">
                    <h1>loading...</h1>
                    <div class="spinner-border text-primary" role="status">
                        <span class="visually-hidden"></span>
                    </div>
                </div>
            `);
        });
    });    
</script>
