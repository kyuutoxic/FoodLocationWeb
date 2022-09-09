/* global bootstrap */
$(window).scroll(function () {
    if ($(this).scrollTop() > 50) {
        $('.navbar').addClass('sticky-top shadow-sm');
    } else {
        $('.navbar').removeClass('sticky-top shadow-sm');
    }
    if ($(this).scrollTop() > 400) {
        $('.store-info-contact').addClass('store-sticky');
        $('.store-info-scroll').addClass('store-sticky');
        $('#nav-cart').attr("style", "display: none !important");
        $('#banner-home').css('opacity', '0');
        $('#nav-nd').css('display', '');
        $('#brand-top').hide();
    } else {
        $('.store-info-contact').removeClass('store-sticky');
        $('.store-info-scroll').removeClass('store-sticky');
        $('#nav-cart').attr("style", "width: 10%");
        $('#banner-home').css('opacity', '1');
        $('#nav-nd').attr("style", "display: none !important");
        $('#brand-top').show();
    }
});

$(".cart").mouseenter(function () {
    $(".cart-detail").fadeIn();
});

$(".cart").mouseleave(function () {
    $(".cart-detail").fadeOut();
});

//$(document).ready(function () {
//    $(this).scrollTop(0);
//});

function toast(type, content, img) {
    const main = document.getElementById("toast-container");
    if (main) {
        const toast = document.createElement("div");

        // Auto remove toast
        const autoRemoveId = setTimeout(function () {
            main.removeChild(toast);
        }, 4000);

        // Remove toast when clicked
        toast.onclick = function () {
            main.removeChild(toast);
            clearTimeout(autoRemoveId);
        };
        const delay = (4000 / 1000).toFixed(2);

        toast.classList.add(`toast--success`);

        toast.style.animation = `slideInLeft ease .3s, fadeOut linear 1s ${delay}s forwards`;

        toast.style.marginBottom = `10px`;

        toast.style.cursor = `pointer`;

        toast.style.backgroundColor = `white`;
        
        let image;
        
        if(img === ''){
            image = `
                    <script src="https://cdn.lordicon.com/xdjxvujz.js"></script>
                    <lord-icon
                        src="https://cdn.lordicon.com/alnsmmtf.json"
                        trigger="loop"
                        colors="primary:#4be1ec,secondary:#cb5eee"
                        style="width:100px;height:100px">
                    </lord-icon>`
        }else{
            image = `<img src="${img}" class="rounded me-2" alt="...">`
        }

        toast.innerHTML = `
        <div class="toast-header">
            ${image}
            <strong class="me-auto">${type}</strong>
            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
            ${content}
        </div>`;
        main.appendChild(toast);
    }
}
;

//$('.btn-minus-quantity').click(function(){
//    let quantity = $('#quantity').val();
//    quantity--;
//    $('#quantity').val(quantity);
//});
//
//$('.btn-plus-quantity').click(function(){
//    console.log('NGU')
//    let quantity = $('#quantity').val();
//    quantity++;
//    $('#quantity').val(quantity);
//});

$('.showModal').click(function(event){
    event.preventDefault();
    let target = $(this).attr('datatarget');
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

$('button').click(function () {
    let target = $(this).attr('datatarget');
    let action = $(this).attr('dataaction');
    if (action === 'close') {
        $('#' + target).attr("style", "");
    } else {
        $('#' + target).attr("style", ""); //send do some ajax here
    }
});

function addPageParameter(value) {
    var searchParams = new URLSearchParams(window.location.search);
    searchParams.set("page", value);
    window.location.search = searchParams.toString();
    console.log(window.location.search);
}

function addSortParameter(value) {
    var searchParams = new URLSearchParams(window.location.search);
    searchParams.set("sort", value);
    window.location.search = searchParams.toString();
    console.log(window.location.search);
}

function addTypeParameter() {
    let value = $('input[name="type"]:checked').val();
    var searchParams = new URLSearchParams(window.location.search);
    searchParams.set("type", value);
    window.location.search = searchParams.toString();
    console.log(window.location.search);
}

var scrollSpy = new bootstrap.ScrollSpy(document.body, {
    target: '#list-tab', offset: 0, method: 'offset'
});