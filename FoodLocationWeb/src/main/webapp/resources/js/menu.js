function addFollow(idStore, idUser) {
    $(`#follow${idStore}`).html(`
        <div class="spinner-border text-primary" role="status">
            <span class="visually-hidden"></span>
        </div>
    `);
    event.preventDefault();
    if (idUser == null) {
        alert('ban chua dang nhap')
        window.location.replace("/FoodLocationWeb/login");
    } else {
        fetch("/FoodLocationWeb/api/follow", {
            method: 'post',
            body: JSON.stringify({
                "storeId": idStore
            }),
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function (res) {
            $(`#follow${idStore}`).remove();
            $('.loading-page').remove();
            toast('Follow success', 'You can manage your follow in your page','');
            return res;
        });
    }
}

function loadAdminMenu(endpoint, menudetail) {
    $('body').append(`
        <div class="loading-page" style="display: flex; justify-content: center; align-items: center; position: fixed; z-index: 1100; width: 100%; height: 100%; top:0; left: 0; background-color: white; opacity: 0.8;">
            <h1>loading...</h1>
            <div class="spinner-border text-primary" role="status">
                <span class="visually-hidden"></span>
            </div>
        </div>
    `);
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
                    <td>${data[i].menuFrom}</td>
                    <td>${data[i].menuTo}</td>
                    <td>${data[i].idType.name}</td>
                    <td>
                        <a href="${menudetail}${data[i].idMenu}"><button type="button" class="btn btn-primary">Detail</button></a>
                    </td>
                    <td>
                        <button type="button" class="btn btn-primary">Delete</button>
                    </td>
                </tr>
            `;
        }
        let d = document.getElementById("adminProd");
        d.innerHTML = msg;
        $('.loading-page').remove();
    })
}

function showModal(type, target){
    event.preventDefault();
    if(type === 'close'){
        $('#'+target).attr('style', 'display: none');
    }else{
        $('#'+target).attr('style', 'display: block !important');
    }
}

function loadMenu(endpoint, idmenu, userId) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
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
                            <a href="#" onclick="showModal('','cmt-store${data[i].idUser}')" style="margin-right: 5px;float: left;">
                                <i class="bi bi-chat-fill"></i>
                                <span>9</span>
                            </a>
                            <a style="margin-right: 5px;float: left;">
                                <i class="bi bi-camera-fill"></i>
                                <span>12</span>
                            </a>
                            <a href="#" style="float: right; margin-right: 20px;" id="follow${data[i].idUser}" onclick="addFollow(${data[i].idUser}, ${userId})">
                                Follow Store
                            </a>
                        </div>    
                    </div>
                </div>
            </div>
            <div class="myModal" id="cmt-store${data[i].idUser}">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
                            <button type="button" class="btn-close" aria-label="Close" onclick="showModal('close','cmt-store${data[i].idUser}')"></button>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="mb-3" style="text-align: left">
                                    <label for="message-text">Nhan xet:</label>
                                    <textarea class="form-control" id="message-text${data[i].idUser}"></textarea>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" onclick="showModal('close','cmt-store${data[i].idUser}')">Close</button>
                                    <button type="button" class="btn btn-primary" onclick="addComment(${data[i].idUser}, ${userId}, 'message-text${data[i].idUser}'),showModal('close','cmt-store${data[i].idUser}')">Send</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            `;
        }
        let d = document.getElementById("listmenu");
        d.innerHTML = msg;
        loadFollowed();
    });
}

function loadFollowed() {
    fetch("/FoodLocationWeb/api/check-follow").then(function (res) {
        return res.json();
    }).then(function (data) {
        for (let i = 0; i < data.length; i++) {
            $(`#follow${data[i].idStore.idUser}`).remove();
        }
    })
}

function loadStoreInCart() {
    $('body').append(`
        <div class="loading-page" style="display: flex; justify-content: center; align-items: center; position: fixed; z-index: 1100; width: 100%; height: 100%; top:0; left: 0; background-color: white; opacity: 0.8;">
            <h1>loading...</h1>
            <div class="spinner-border text-warning" role="status">
                <span class="visually-hidden"></span>
            </div>
        </div>
    `);
    fetch(`http://localhost:8080/FoodLocationWeb/api/storeInCart`).then(function (res) {
        return res.json();
    }).then(function (data) {
        console.log(data);
        let total = parseInt($('#total').text());
        data.forEach(function (e) {
            $('#store' + e.idUser).text(e.nameStore);
            let ship = document.getElementById('ship');
            let shipPrice = e.shipPrice;
            shipPrice = new Intl.NumberFormat().format(shipPrice);
            ship.innerHTML += `
                <div>Store:&nbsp;${e.nameStore}</div>
                <span>${shipPrice}</span>
                <span>&nbsp;VND</span>
            `;
            $('.loading-page').remove();
            total += e.shipPrice;
        });
        total = new Intl.NumberFormat().format(total);
        $('#total').text(total);
    });
}

function loadStoreByMenuId(id) {
    fetch(`http://localhost:8080/FoodLocationWeb/api/storeByMenuID/${id}`).then(function (res) {
        return res.json();
    }).then(function (data) {
        $('#store' + id).text(data[0].nameStore);
    });
}

function manageOrderDetail(idOrderDetail, type, idUser) {
    $(`#btn-${type}OrderDetail` + idOrderDetail).html(`
        <div class="spinner-border text-warning" role="status">
            <span class="visually-hidden"></span>
        </div>
    `);
    fetch(`http://localhost:8080/FoodLocationWeb/api/store/${type}/${idOrderDetail}`).then(function (res) {
        return res.json();
    }).then(function (data) {
        if (type === "deny") {
            fetch(`/FoodLocationWeb/sendmail`, {
                method: 'post',
                body: JSON.stringify({
                    "idUser": data[0].idUser.idUser,
                    "type": 2,
                    "idOrder": data[0].idOrder
                }),
                headers: {
                    "Content-Type": "application/json"
                }
            }).then(function () {
                loadOrderDetailByStoreId();
            });
        }
        loadOrderDetailByStoreId();
    });
}

function loadOrderDetailByStoreId() {
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
                <td id="btn-acceptOrderDetail${e[0]}" class="text-center">
                    <button class="btn btn-success" onclick="manageOrderDetail(${e[0]}, 'accept', ${e[1].idUser.idUser})">Accept Order</button>
                </td>
                <td id="btn-denyOrderDetail${e[0]}" class="text-center">
                    <button class="btn btn-danger" onclick="manageOrderDetail(${e[0]}, 'deny', ${e[1].idUser.idUser})">Deny Order</button>
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
function addToCart(id, name, price, image) {
    event.preventDefault();
    fetch("/FoodLocationWeb/api/cart", {
        method: 'post',
        body: JSON.stringify({
            "menuId": id,
            "menuName": name,
            "price": price,
            "quantity": 1,
            "image": image
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
            $('#cart' + productId).attr('style', 'display: none');
            $('#product1' + productId).attr('style', 'display: none');
            $('#product2' + productId).attr('style', 'display: none');
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
            "quantity": $('#' + productId).val(),
            "image": ""
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
            msg += `
            <div class="card rounded-3 mb-4" id="product${result[i].menuId}">
                <div class="card-body p-4">
                    <div class="row d-flex justify-content-between align-items-center">
                        <div class="col-md-2 col-lg-2 col-xl-2 m-0 p-0">
                            <img
                                src="${result[i].image}"
                                class="img-fluid rounded-3" alt="Cotton T-shirt">
                        </div>
                        <div class="col-md-4 col-lg-4 col-xl-4 m-0 p-2">
                            <p class="lead mb-2" style="width: 100%" title="${result[i].menuName}">${result[i].menuName}</p>
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
    if (confirm("Ban chac chan thanh toan?") === true) {
        $('body').append(`
            <div class="loading-page" style="display: flex; justify-content: center; align-items: center; position: fixed; z-index: 1100; width: 100%; height: 100%; top:0; left: 0; background-color: white; opacity: 0.8;">
                <h1>loading...</h1>
                <div class="spinner-border text-warning" role="status">
                    <span class="visually-hidden"></span>
                </div>
            </div>
//        `);
        let total = $('#total').text();
        total = total.replaceAll(",","");
        fetch(`/FoodLocationWeb/api/pay/${total}`, {
            method: "post"
        }).then(function (res) {
            return res.json();
        }).then(function (data) {
            fetch(`/FoodLocationWeb/sendmail`, {
                method: 'post',
                body: JSON.stringify({
                    "idUser": data[0].idUser.idUser,
                    "type": 1,
                    "idOrder": data[0].idOrder
                }),
                headers: {
                    "Content-Type": "application/json"
                }
            }).then(function () {
                $('.loading-page').html(`<h1 style="text-align: center">YOUR PURCHASE IS SUCCESS<br>PLEASE CHECK YOUR MAIL FOR DETAIL</h1>`);
                setTimeout(function () {
                    window.location.replace("/FoodLocationWeb/");
                }, 3000);
            });
        });
    }
}

function addComment(productId, userId, id) {
    let content;
    if(id === null){
        content = $("#message-text").val();
    }else{
        content = $('#'+id).val();
    }
    if (userId == undefined) {
        alert('Please sign in before comment!!')
    } else {
        fetch("/FoodLocationWeb/api/add-comment", {
            method: 'post',
            body: JSON.stringify({
                "content": content,
                "storeId": productId
            }),
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function (res) {
            return res.json()
        }).then(function (data) {
            let createdDate = moment(data.createdDate).format("YYYY/MM/DD HH:MM:SS.S");
            $("#list-cmt").append(`  
            <div class="cmt-list">
                        <div class="info-comment">
                            <div class="info-comment-info">
                                <img src="${data.idUser.avatar}" alt="alt" class="avatar"/>
                                <div>
                                    <div style="font-weight: 500; color: black;">${data.idUser.firstName} ${data.idUser.lastName}</div>
                                    <div>${createdDate}</div>
                                </div>
                            </div>
                            <div class="avg-point">9.3</div>
                        </div>
                        <div class="content-comment">
                            <div class="header-content">${data.content}</div>
                            <div class="media-content">
                                <img src="http://localhost:8080/FoodLocationWeb/resources/img/menu-1.png" alt="alt"/>
                                <img src="http://localhost:8080/FoodLocationWeb/resources/img/menu-1.png" alt="alt"/>
                            </div>
                            
                        </div>
                        <div class="interaction-comment">
                            <i class="bi bi-heart-fill">Like</i>
                            <i class="bi bi-chat-fill">Comment</i>
                            <i class="bi bi-exclamation-triangle-fill">Report</i>
                        </div>
                    </div>  
        `);
        })
    }
    ;
}
