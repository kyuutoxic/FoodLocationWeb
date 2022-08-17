/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */



$('.showModal').click((event)=>{
    event.preventDefault();
    console.log('hihi');
    let target = $('.showModal').attr('datatarget');
    $('#' + target).attr("style", "display: block !important");
});

//example showModal
//focus class="showModal" datatarget and dataaction
`<div class="col-2">
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
                    <div class="mb-3" style="text-align: left">
                        <label for="recipient-name">Nhan xet chung:</label>
                        <input type="text" class="form-control" id="recipient-name">
                    </div>
                    <div class="mb-3" style="text-align: left">
                        <label for="message-text">Nhan xet:</label>
                        <textarea class="form-control" id="message-text"></textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" datatarget="add-cmt-form" dataaction="close">Close</button>
                <button type="button" class="btn btn-primary" datatarget="add-cmt-form" dataaction="send">Send</button>
            </div>
        </div>
    </div>
</div>`;

$('button').click(function(){
    let target = $(this).attr('datatarget');
    let action = $(this).attr('dataaction');
    console.log(target);
    if (action === 'close'){
        $('#' + target).attr("style", "");
    }else{
        $('#' + target).attr("style", ""); //send do some ajax here
    }
});