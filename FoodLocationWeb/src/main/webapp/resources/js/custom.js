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

var toastID = 0;

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

//        toast.classList.add("toast", `toast--${type}`);
        toast.style.animation = `slideInLeft ease .3s, fadeOut linear 1s ${delay}s forwards`;
        
        toast.style.backgroundColor = `white`;
        
        toast.style.marginBottom = `10px`;
        
        toast.style.cursor = `pointer`;

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

$('.btn-minus-quantity').click(function(){
    let quantity = $('#quantity').val();
    quantity--;
    $('#quantity').val(quantity);
});

$('.btn-plus-quantity').click(function(){
    console.log('NGU')
    let quantity = $('#quantity').val();
    quantity++;
    $('#quantity').val(quantity);
});

//plugin bootstrap minus and plus
//http://jsfiddle.net/laelitenetwork/puJ6G/
$('.btn-number').click(function(e){
    e.preventDefault();
    
    fieldName = $(this).attr('data-field');
    type      = $(this).attr('data-type');
    var input = $("input[name='"+fieldName+"']");
    var currentVal = parseInt(input.val());
    if (!isNaN(currentVal)) {
        if(type == 'minus') {
            
            if(currentVal > input.attr('min')) {
                input.val(currentVal - 1).change();
            } 
            if(parseInt(input.val()) == input.attr('min')) {
                $(this).attr('disabled', true);
            }

        } else if(type == 'plus') {

            if(currentVal < input.attr('max')) {
                input.val(currentVal + 1).change();
            }
            if(parseInt(input.val()) == input.attr('max')) {
                $(this).attr('disabled', true);
            }

        }
    } else {
        input.val(0);
    }
});
$('.input-number').focusin(function(){
   $(this).data('oldValue', $(this).val());
});
$('.input-number').change(function() {
    
    minValue =  parseInt($(this).attr('min'));
    maxValue =  parseInt($(this).attr('max'));
    valueCurrent = parseInt($(this).val());
    
    name = $(this).attr('name');
    if(valueCurrent >= minValue) {
        $(".btn-number[data-type='minus'][data-field='"+name+"']").removeAttr('disabled')
    } else {
        alert('Sorry, the minimum value was reached');
        $(this).val($(this).data('oldValue'));
    }
    if(valueCurrent <= maxValue) {
        $(".btn-number[data-type='plus'][data-field='"+name+"']").removeAttr('disabled')
    } else {
        alert('Sorry, the maximum value was reached');
        $(this).val($(this).data('oldValue'));
    }
    
    
});
$(".input-number").keydown(function (e) {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 190]) !== -1 ||
             // Allow: Ctrl+A
            (e.keyCode == 65 && e.ctrlKey === true) || 
             // Allow: home, end, left, right
            (e.keyCode >= 35 && e.keyCode <= 39)) {
                 // let it happen, don't do anything
                 return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
        }
    });












var scrollSpy = new bootstrap.ScrollSpy(document.body, {
    target: '#list-tab', offset: 0, method: 'offset'
});