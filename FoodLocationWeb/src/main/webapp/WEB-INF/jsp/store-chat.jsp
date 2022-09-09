<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="app-main__outer">
    <div class="app-main__inner">
        <div class="row table-chat-container">
            <div class="col-2 table-chat-list" style="height: 90vh">
                <!--<div class="list-chat"><img src="${currentUser.avatar}" alt="hihi"></div>-->
            </div>
            <div class="col-10 table-chat-content" style="height: 90vh">
                <div class="table-content-chat" style="height: 90%"></div>
                <div class="table-box-chat" style="height: 50px">
                    <input type="text" id="box-chat" style="width: 85%; height: 100%">
                    <button class="btn btn-primary" type="button" id="btn-send-chat" style="width: 10%; height: 100%">Send</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value="/js/menu.js" />"></script>
<script>
    $(document).ready(function () {
        initPage('${currentUser.username}',${currentUser.idUser});
    });
</script>
