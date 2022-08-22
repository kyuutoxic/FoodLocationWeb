
function loadAdminMenu(endpoint, menudetail) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        console.log(data);
        let msg = "";
        for (let i = 0; i < data.length; i++) {
            msg += `
            <tr>
                    <th scope="row">${i}</th>
                    <td>${data[i].idMenu}</td>
                    <td>${data[i].menuName}</td>
                    <td>${data[i].price}</td>
                    <td>${data[i].idStore.nameStore}</td>
                    <td>${data[i].menuNote}</td>
                    <td>${data[i].menuFrom}</td>
                    <td>${data[i].menuTo}</td>
                    <td>${data[i].idType.name}</td>
                    <td>
                        <a href="${menudetail}${data[i].idMenu}"><button type="button" class="btn btn-primary">Detail</button></a>
                        <button type="button" class="btn btn-primary">Delete</button>
                    </td>
                </tr>
            `;
        }
        let d = document.getElementById("adminProd");
        d.innerHTML = msg;
    })
}

function loadMenu(endpoint, idmenu) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        console.log(data);
        let msg = "";
        for (let i = 0; i < data.length; i++) {
            msg += `
            <div class="col-3">
                <div class="card mb-5">
                    <a href="${idmenu}${data[i].idUser}">
                        <img class="card-img-top" src="${data[i].avatar}" alt="Card image cap">
                    </a>
                    <div class="card-body" style="height: 168px; max-height: 168px;">
                        <a href="${idmenu}${data[i].idUser}">${data[i].nameStore}</a>
                        <p>${data[i].address}</p>
                        <div style="position: absolute;bottom: 0;margin-bottom: 15px;width:100%;">
                            <a style="margin-right: 5px;float: left;">
                                <i class="bi bi-chat-fill"></i>
                                <span>9</span>
                            </a>
                            <a style="margin-right: 5px;float: left;">
                                <i class="bi bi-camera-fill"></i>
                                <span>12</span>
                            </a>
                            <a style="float: right; margin-right: 20px;">
                                <i class="bi bi-bookmark-fill"></i> Luu
                            </a>
                        </div>    
                    </div>
                </div>
            </div>
            `;
        }
        let d = document.getElementById("listmenu");
        d.innerHTML = msg;
    });
}

function loadStoreInCart() {
    fetch(`http://localhost:8080/FoodLocationWeb/api/storeInCart`).then(function (res) {
        return res.json();
    }).then(function (data) {
        console.log(data);
        data.forEach(function (e) {
            $('#store' + e.idUser).text(e.nameStore);
            let ship = document.getElementById('ship');
            ship.innerHTML += `
                <div>Store:&nbsp;${e.nameStore}</div>
                <span>${e.shipPrice}</span>
                <span>&nbsp;VNÐ</span>
            `;
        });
    });
}

function loadStoreByMenuId(id) {
    fetch(`http://localhost:8080/FoodLocationWeb/api/storeByMenuID/${id}`).then(function (res) {
        return res.json();
    }).then(function (data) {
        $('#store' + id).text(data[0].nameStore);
    });
}

function manageOrderDetail(idOrderDetail, type){
    $('#btn-orderDetail' + idOrderDetail).html(`
        <div class="spinner-border text-warning" role="status">
            <span class="visually-hidden"></span>
        </div>
    `);
    fetch(`http://localhost:8080/FoodLocationWeb/api/store/${type}/${idOrderDetail}`).then(function(res){
        return res;
    }).then(function(data){
        if(data.status == 200){
            loadOrderDetailByStoreId();
//            $('#orderDetail' + idOrderDetail).attr("style", "display: none !important");
        }
    });
}

function loadOrderDetailByStoreId(){
    fetch(`http://localhost:8080/FoodLocationWeb/api/store/order`).then(function (res) {
        return res.json();
    }).then(function (data) {
        let id = 0;
        $('#order-check-area').text('');
        data.forEach(e => {
            $('#order-check-area').append(
            `<tr id="orderDetail${e[0]}">
                <td class="text-center text-muted">${++id}</td>
                <td>${e[2].menuName}</td>
                <td class="text-center">${e[1].idUser.address}</td>
                <td class="text-center">${e[1].idUser.phone}</td>  
                <td class="text-center">Uncheck</td> 
                <td id="btn-orderDetail${e[0]}" class="text-center">
                    <button class="btn btn-success" onclick="manageOrderDetail(${e[0]}, 'accept')">Accept Order</button>
                    <button class="btn btn-danger" onclick="manageOrderDetail(${e[0]}, 'deny')">Deny Order</button>
                </td>
            </tr>`);
        });
    });
}

function comparison(currentVal, id) {
    if (currentVal <= $("#" + id).attr('min')) {
        $(".btn-number[data-type='minus'][data-field='" + id + "']").attr('disabled', true);
    } else {
        $(".btn-number[data-type='minus'][data-field='" + id + "']").attr('disabled', false);
    }

    if (currentVal >= $("#" + id).attr('max')) {
        $(".btn-number[data-type='plus'][data-field='" + id + "']").attr('disabled', true);
    } else {
        $(".btn-number[data-type='plus'][data-field='" + id + "']").attr('disabled', false);
    }
}

$('.btn-number').click(function (e) {
    e.preventDefault();

    fieldName = $(this).attr('data-field');
    type = $(this).attr('data-type');
    let input = $("#" + fieldName);
    let currentVal = parseInt(input.val());

    if (!isNaN(currentVal)) {
        if (type == 'minus') {

            if (currentVal > input.attr('min')) {
                currentVal--;
                input.val(currentVal);
            }
            comparison(currentVal, fieldName);
        } else if (type == 'plus') {

            if (currentVal < input.attr('max')) {
                currentVal++;
                input.val(currentVal);
            }
            comparison(currentVal, fieldName);
        }

        console.log(currentVal);
        updateCart(fieldName);
    } else {
        input.val(0);
    }
});
$('.input-number').focusin(function () {
    $(this).data('oldValue', $(this).val());
});
$('.input-number').change(function () {

    minValue = parseInt($(this).attr('min'));
    maxValue = parseInt($(this).attr('max'));
    valueCurrent = parseInt($(this).val());

    name = $(this).attr('name');
    if (valueCurrent >= minValue) {
        $(".btn-number[data-type='minus'][data-field='" + name + "']").removeAttr('disabled')
    } else {
        alert('Sorry, the minimum value was reached');
        $(this).val($(this).data('oldValue'));
    }
    if (valueCurrent <= maxValue) {
        $(".btn-number[data-type='plus'][data-field='" + name + "']").removeAttr('disabled')
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

function addToCart(id, name, price) {
    event.preventDefault();
    console.log("hihi");
    fetch("/FoodLocationWeb/api/cart", {
        method: 'post',
        body: JSON.stringify({
            "menuId": id,
            "menuName": name,
            "price": price,
            "quantity": 1
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        $('#cartCounter1').attr('value', data);
        $('#cartCounter2').attr('value', data);
        loadMiniCart();
    });
}

function deleteCart(productId) {
    if (confirm("Ban chac chan xoa item nay khong?") == true) {
        fetch(`/FoodLocationWeb/api/cart/${productId}`, {
            method: "delete"
        }).then(function (res) {
            return res.json()
        }).then(function (data) {
            $('#cartCounter1').attr('value', data.counter);
            $('#cartCounter2').attr('value', data.counter);
            $("#amountCart").html(data.amount);
            $('#cart' + productId).attr('display', 'none');
            $('#product1' + productId).attr('display', 'none');
            $('#product2' + productId).attr('display', 'none');
            loadMiniCart();
        })
    }
}

function updateCart(productId) {
    fetch("/FoodLocationWeb/api/cart", {
        method: "put",
        body: JSON.stringify({
            "menuId": productId,
            "menuName": "",
            "price": 0,
            "quantity": $('#' + productId).val()
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json()
    }).then(function (data) {
        console.log(data)
        $('#cartCounter1').attr('value', data.counter);
        $('#cartCounter2').attr('value', data.counter);
        $("#amountCart").html(data.amount);
        loadMiniCart();
    })
}

function loadMiniCart() {
    fetch("/FoodLocationWeb/api/cart").then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.getElementById("minicart");
        let c = document.getElementById("minicart2");

        d.innerHTML = "";
        c.innerHTML = "";

        let msg = "";
        let result = [];
        for (var key in data) {
            result.push(data[key]);
        }
        for (let i = 0; i < result.length; i++) {
            console.log("NGU");
            msg += `
            <div class="card rounded-3 mb-4" id="product${result[i].menuId}">
                <div class="card-body p-4">
                    <div class="row d-flex justify-content-between align-items-center">
                        <div class="col-md-2 col-lg-2 col-xl-2 m-0 p-0">
                            <img
                                src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-shopping-carts/img1.webp"
                                class="img-fluid rounded-3" alt="Cotton T-shirt">
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 m-0 p-2">
                            <p class="lead mb-2" style="width: 100%">${result[i].menuName}</p>
                            <p><span class="text-muted">Quantity: </span>${result[i].quantity}</p>
                        </div>
                        <div class="col-md-4 col-lg-3 col-xl-3 offset-lg-1 m-0 p-0">
                            <span class="mb-0" style="width: 100%">${result[i].price}</span>
                        </div>
                        <div class="col-md-1 col-lg-1 col-xl-1 text-end m-0 p-0">
                            <a href="#!" class="text-danger"><i class="fas fa-trash fa-lg" onclick="deleteCart(${result[i].menuId})"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            `;
        }
        d.innerHTML += msg;
        c.innerHTML += msg;

    })
}

function pay() {
    if (confirm("Ban chac chan thanh toan?") == true) {
        let total = $('#total').text();
        total = total.slice(0, total.indexOf(' '));
        console.log(total);
        fetch(`/FoodLocationWeb/api/pay/${total}`, {
            method: "post"
        }).then(function (res) {
            return res.json();
        }).then(function (code) {
            location.reload();
        })
    }
}

function addComment(productId, userId) {
    if(userId == undefined)  {alert('Please sign in before comment!!')}  else {
    fetch("/FoodLocationWeb/api/add-comment", {
        method: 'post',
        body: JSON.stringify({
            "content": document.getElementById("message-text").value,
            "storeId": productId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        console.info(res)
        return res.json()
    }).then(function (data) {
        console.info(data);
        console.info("THANH CONG");

        let area = document.getElementById("list-cmt");
//        
        area.innerHTML = `
            <div class="cmt-list">
                        <div class="info-comment">
                            <div class="info-comment-info">
                                <img src="${data.idUser.avatar}" alt="alt" class="avatar"/>
                                <div>
                                    <div style="font-weight: 500; color: black;">${data.idUser.firstName} ${data.idUser.lastName}</div>
                                    <div>${data.createdDate}</div>
                                </div>
                            </div>
                            <div class="avg-point">9.3</div>
                        </div>
                        <div class="content-comment">
                            <div class="header-content">${data.content}</div>
<!--                            <div class="body-content">
                                Cà phê brewing hand drip chuẩn vị Nhật nhưng hay hết món lắm, 2 loại bánh mà t thích cũng vậy (bánh bơ tỏi và việt quất). Dãy bàn ghế êm thích hợp học tập làm việc (thi thoảng có nhóm khách đi đông thì ồn). Máy cà thẻ đôi khi hay bị hư nên khá bất tiện cho người ko có Momo và tiền mặt (dạo này hình như đỡ rồi).
                                PS. Hình chụp em mèo ko biết của quán hay sao nữa
                            </div>
                            
                        </div>
                        <div class="interaction-comment">
                            <i class="bi bi-heart-fill">Like</i>
                            <i class="bi bi-chat-fill">Comment</i>
                            <i class="bi bi-exclamation-triangle-fill">Report</i>
                        </div>
                    </div>  
        ` + area.innerHTML
    })};
}