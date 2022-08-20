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



$(document).ready(function () {
    $(this).scrollTop(0);
});

function toast(){
    const main = document.getElementById("toast-container");
    if (main) {
        const toast = document.createElement("div");

        // Auto remove toast
        const autoRemoveId = setTimeout(function () {
            main.removeChild(toast);
        }, 6000);

        // Remove toast when clicked
        toast.onclick = function () {
                main.removeChild(toast);
                clearTimeout(autoRemoveId);
        };
        const delay = (6000 / 1000).toFixed(2);

        toast.classList.add(`toast--success`);
        
        toast.style.animation = `slideInLeft ease .3s, fadeOut linear 1s ${delay}s forwards`;
        
        toast.style.marginBottom = `10px`;
        
        toast.style.cursor = `pointer`;
        
       toast.style.backgroundColor = `white`;

        toast.innerHTML = `
        <div class="toast-header">
            <img src="..." class="rounded me-2" alt="...">
            <strong class="me-auto">Bootstrap</strong>
            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
            Hello, world! This is a toast message.
        </div>`;
        main.appendChild(toast);
    }
};

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

var scrollSpy = new bootstrap.ScrollSpy(document.body, {
    target: '#list-tab', offset: 0, method: 'offset'
});