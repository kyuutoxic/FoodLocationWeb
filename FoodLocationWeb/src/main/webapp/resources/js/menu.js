
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
            toast('Follow success', 'You can manage your follow in your page', '');
            return res;
        });
    }
}

function changeDelete(idMenu) {
    event.preventDefault();
    $(`#btndelete${idMenu}`).html(
        `<div class="spinner-border text-primary" role="status">
            <span class="visually-hidden"></span>
        </div>`
    );

    fetch(`/FoodLocationWeb/api/change-delete/${idMenu}`, {
        method: 'post'
    }).then(function (res) {
        $(`#btndelete${idMenu}`).html('');
        let a = $('#btndelete' + idMenu).text();
        if (a == 'Delete') {
            $('#btndelete' + idMenu).text('Undelete');
            $('#delete' + idMenu).text('true');

        } else {
            $('#btndelete' + idMenu).text('Delete');
            $('#delete' + idMenu).text('false');

        }
        return res;
    });
}

function deleteStoreMenu(idMenu) {
    event.preventDefault();
    $(`#btndelete${idMenu}`).html(`<div class="spinner-border text-primary" role="status">
                <span class="visually-hidden"></span>
            </div>`)

    fetch(`/FoodLocationWeb/api/change-delete/${idMenu}`, {
        method: 'post'
    }).then(function (res) {
        if (res.ok) {
            $('#storeMenu' + idMenu).remove();
        }
    });
}

function changeDeleteUser(idUser) {
    event.preventDefault();

    fetch(`/FoodLocationWeb/api/change-delete-user/${idUser}`, {
        method: 'post'
    }).then(function (res) {
        let a = $('#btndeleteuser' + idUser).text();
        if (a == 'Delete') {
            $('#btndeleteuser' + idUser).text('Undelete');
            $('#deleteuser' + idUser).text('true');

        } else {
            $('#btndeleteuser' + idUser).text('Delete');
            $('#deleteuser' + idUser).text('false');

        }
        return res;
    });
}

function changeDeleteStore(idUser) {
    event.preventDefault();

    fetch(`/FoodLocationWeb/api/change-delete-user/${idUser}`, {
        method: 'post'
    }).then(function (res) {
        let a = $('#btndeletestore' + idUser).text();
        if (a == 'Delete') {
            $('#btndeletestore' + idUser).text('Undelete');
            $('#deletestore' + idUser).text('true');

        } else {
            $('#btndeletestore' + idUser).text('Delete');
            $('#deletestore' + idUser).text('false');

        }
        return res;
    });
}

function changeActiveStore(idUser) {
    event.preventDefault();

    fetch(`/FoodLocationWeb/api/change-active-store/${idUser}`, {
        method: 'post'
    }).then(function (res) {
        let a = $('#btn-active-store' + idUser).text();
        if (a == 'Unactive') {
            $('#btn-active-store' + idUser).text('Active');
            $('#active-store' + idUser).text('false');

        } else {
            $('#btn-active-store' + idUser).text('Unactive');
            $('#active-store' + idUser).text('true');

        }
        return res;
    });
}

function loadAdminMenu(endpoint, menudetail) {
    $('#adminProd').append(`
        <div class="loading-page" style="display: flex; justify-content: center; align-items: center; width: 100%; height: 100%; background-color: white;">
            <h1>loading...</h1>
            <div class="spinner-border text-primary" role="status">
                <span class="visually-hidden"></span>
            </div>
        </div>
    `);
    fetch(endpoint).then(function (res) {
        setTimeout(function () {
            $('.loading-page').remove();
        }, 3000);
        return res.json();
    }).then(function (data) {
        console.log(data);
        let msg = "";
        for (let i = 0; i < data.length; i++) {
            let msg1 = `<td>
                        <button id="btndelete${data[i].idMenu}" type="button" class="btn btn-primary" onclick="changeDelete(${data[i].idMenu})" >Delete</button>
                    </td>
                </tr>`
            let msg2 = `<td>
                        <button id="btndelete${data[i].idMenu}" type="button" class="btn btn-primary" onclick="changeDelete(${data[i].idMenu})" >Undelete</button>
                    </td>
                </tr>`
            msg += `
            <tr>
                    <th scope="row">${i}</th>
                    <td>${data[i].idMenu}</td>
                    <td>${data[i].menuName}</td>
                    <td>${data[i].price}</td>
                    <td>${data[i].idStore.nameStore}</td>
                    <td>${data[i].menuFrom}</td>
                    <td>${data[i].menuTo}</td>
                    <td id="delete${data[i].idMenu}">${data[i].isDelete}</td>
                    <td>
                        <a href="${menudetail}${data[i].idMenu}"><button type="button" class="btn btn-primary">Detail</button></a>
                    </td>
                    
                    
            `;
            if (data[i].isDelete == true) {
                msg += msg2
            } else {
                msg += msg1
            }

        }
        let d = document.getElementById("adminProd");
        d.innerHTML = msg;
    })
}

function loadStoreMenu(endpoint, menudetail) {
    $('#storeProd').append(`
        <div class="loading-page" style="display: flex; justify-content: center; align-items: center; width: 100%; height: 100%; background-color: white;">
            <h1>loading...</h1>
            <div class="spinner-border text-primary" role="status">
                <span class="visually-hidden"></span>
            </div>
        </div>
    `);
    fetch(endpoint).then(function (res) {
        setTimeout(function () {
            $('.loading-page').remove();
        }, 3000);
        return res.json();
    }).then(function (data) {
        let msg = "";
        for (let i = 0; i < data.length; i++) {
            msg += `
            <tr id="storeMenu${data[i].idMenu}">
                    <th scope="row">${i}</th>
                    <td>${data[i].idMenu}</td>
                    <td>${data[i].menuName}</td>
                    <td>${data[i].price}</td>
                    <td>${data[i].idStore.nameStore}</td>
                    <td>${data[i].menuFrom}</td>
                    <td>${data[i].menuTo}</td>
                    <td id="delete${data[i].idMenu}">${data[i].menuStatus}</td>
                    <td>
                        <a href="${menudetail}${data[i].idMenu}"><button type="button" class="btn btn-primary">Detail</button></a>
                    </td>
                    <td>
                        <button id="btndelete${data[i].idMenu}" type="button" class="btn btn-primary" onclick="deleteStoreMenu(${data[i].idMenu})" >Delete</button>
                    </td>
            </tr>
            `;
        }
        let d = document.getElementById("storeProd");
        d.innerHTML = msg;
    })
}

function loadAdminOrderDetail() {
    $('#adminOrderDetail').append(`
        <div class="loading-page" style="display: flex; justify-content: center; align-items: center; width: 100%; height: 100%; background-color: white;">
            <h1>loading...</h1>
            <div class="spinner-border text-primary" role="status">
                <span class="visually-hidden"></span>
            </div>
        </div>
    `);
    fetch("/FoodLocationWeb/api/admin/orderdetail/").then(function (res) {
        return res.json();
    }).then(function (data) {
        setTimeout(function () {
            $('.loading-page').remove();
        }, 3000);
        let msg = "";
        for (let i = 0; i < data.length; i++) {
            msg += `
            <tr>
                    <th scope="row">${i}</th>
                    <td>${data[i].idOrderDetail}</td>
                    <td>${data[i].quantity}</td>
                    <td>${data[i].unitPrice}</td>
                    <td>${data[i].idMenu.menuName}</td>
                    <td>${data[i].idOrder.idOrder}</td>
             </tr>       
            `;
        }
        let d = document.getElementById("adminOrderDetail");
        d.innerHTML = msg;
    })
}

function loadAdminOrder() {
    $('#adminOrder').append(`
        <div class="loading-page" style="display: flex; justify-content: center; align-items: center; width: 100%; height: 100%; background-color: white;">
            <h1>loading...</h1>
            <div class="spinner-border text-primary" role="status">
                <span class="visually-hidden"></span>
            </div>
        </div>
    `);
    fetch("/FoodLocationWeb/api/admin/order/").then(function (res) {
        return res.json();
    }).then(function (data) {
        setTimeout(function () {
            $('.loading-page').remove();
        }, 3000);
        let msg = "";
        for (let i = 0; i < data.length; i++) {
            msg += `
            <tr>
                    <th scope="row">${i}</th>
                    <td>${data[i].idOrder}</td>
                    <td>${data[i].total}</td>
                    <td>${data[i].note}</td>
                    <td>${data[i].typePayment}</td>
                    <td>${data[i].idUser.firstName} ${data[i].idUser.lastName}</td>
             </tr>       
            `;
        }
        let d = document.getElementById("adminOrder");
        d.innerHTML = msg;
        $('.loading-page').remove();
    })
}

function loadAdminUser() {
    $('#adminUsers').append(`
        <div class="loading-page" style="display: flex; justify-content: center; align-items: center; width: 100%; height: 100%; background-color: white;">
            <h1>loading...</h1>
            <div class="spinner-border text-primary" role="status">
                <span class="visually-hidden"></span>
            </div>
        </div>
    `);
    fetch("/FoodLocationWeb/api/admin/users/").then(function (res) {
        return res.json();
    }).then(function (data) {
        setTimeout(function () {
            $('.loading-page').remove();
        }, 3000);
        let msg = "";
        for (let i = 0; i < data.length; i++) {
            let msg1 = `<td>
                        <button id="btndeleteuser${data[i].idUser}" type="button" class="btn btn-primary" onclick="changeDeleteUser(${data[i].idUser})" >Delete</button>
                    </td>
                </tr>`
            let msg2 = `<td>
                        <button id="btndeleteuser${data[i].idUser}" type="button" class="btn btn-primary" onclick="changeDeleteUser(${data[i].idUser})" >Undelete</button>
                    </td>
                </tr>`
            msg += `
            <tr>
                    <th scope="row">${i}</th>
                    <td>${data[i].idUser}</td>
                    <td>${data[i].username}</td>
                    <td>${data[i].firstName} ${data[i].lastName}</td>
                    <td>${data[i].phone}</td>
                    <td>${data[i].email}</td>
                    <td id="deleteuser${data[i].idUser}">${data[i].isDelete}</td>
                    
                    
            `;
            if (data[i].isDelete == true) {
                msg += msg2
            } else {
                msg += msg1
            }

        }
        let d = document.getElementById("adminUsers");
        d.innerHTML = msg;
        $('.loading-page').remove();
    })
}

function loadAdminStore() {
    $('#adminStore').append(`
        <div class="loading-page" style="display: flex; justify-content: center; align-items: center; width: 100%; height: 100%; background-color: white;">
            <h1>loading...</h1>
            <div class="spinner-border text-primary" role="status">
                <span class="visually-hidden"></span>
            </div>
        </div>
    `);
    fetch("/FoodLocationWeb/api/admin/store/").then(function (res) {
        return res.json();
    }).then(function (data) {
        setTimeout(function () {
            $('.loading-page').remove();
        }, 3000);
        let msg = "";
        for (let i = 0; i < data.length; i++) {
            let msg1 = null;
            if (data[i].isDelete == true) {
                msg1 += `<td>
                        <button id="btndeletestore${data[i].idUser}" type="button" class="btn btn-primary" onclick="changeDeleteStore(${data[i].idUser})" >Undelete</button>
                    </td>
                </tr>`
            } else {
                msg1 += `<td>
                        <button id="btndeletestore${data[i].idUser}" type="button" class="btn btn-primary" onclick="changeDeleteStore(${data[i].idUser})" >Delete</button>
                    </td>
                </tr>`
            }
            let msg2 = null;
            if (data[i].active == true) {
                msg2 += `<td>
                        <button id="btn-active-store${data[i].idUser}" type="button" class="btn btn-primary" onclick="changeActiveStore(${data[i].idUser})" >Unactive</button>
                    </td>`
            } else {
                msg2 += `<td>
                        <button id="btn-active-store${data[i].idUser}" type="button" class="btn btn-primary" onclick="changeActiveStore(${data[i].idUser})" >Active</button>
                    </td>`
            }
            msg += `
            <tr>
                    <th scope="row">${i}</th>
                    <td>${data[i].idUser}</td>
                    <td>${data[i].username}</td>
                    <td>${data[i].nameStore}</td>
                    <td>${data[i].phone}</td>
                    <td>${data[i].email}</td>
                    <td>${data[i].address}</td>
                    <td id="active-store${data[i].idUser}">${data[i].active}</td>
                    <td id="deletestore${data[i].idUser}">${data[i].isDelete}</td>
            ` + msg2 + msg1;
        }
        let d = document.getElementById("adminStore");
        d.innerHTML = msg;
        $('.loading-page').remove();
    })
}

function showModal(type, target) {
    event.preventDefault();
    if (type === 'close') {
        $('#' + target).attr('style', 'display: none');
    } else {
        $('#' + target).attr('style', 'display: block !important');
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
    $('#btn-pay').attr('style', 'cursor: context-menu;').attr('disabled', 'disabled').click(false).html(`
            <div class="spinner-border text-warning" role="status">
                <span class="visually-hidden"></span>
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
            total += e.shipPrice;
        });
        total = new Intl.NumberFormat().format(total);
        $('#total').text(total);
        $('#btn-pay').attr('style', '').removeAttr('disabled').html('Pay');
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
    if (type === "deny") {
        if (confirm("Are you sure to deny this order?") == true) {
            fetch(`http://localhost:8080/FoodLocationWeb/api/store/${type}/${idOrderDetail}`).then(function (res) {
                loadOrderDetailByStoreId();
            });
        }
    }
    if (type === 'accept') {
        fetch(`http://localhost:8080/FoodLocationWeb/api/store/${type}/${idOrderDetail}`).then(function (res) {
            loadOrderDetailByStoreId();
        });
    }
}

function loadOrderDetailByStoreId() {
    $('#order-check-area').html(`
        <div class="loading-page" style="display: flex; justify-content: center; align-items: center; width: 100%; height: 100%; background-color: white;">
            <h1>loading...</h1>
            <div class="spinner-border text-primary" role="status">
                <span class="visually-hidden"></span>
            </div>
        </div>
    `);
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

function addToCart(id, name, price, image) {
    event.preventDefault();
    toast('Your cart is loading', 'Please a second', '');
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
        toast('Add to cart success', 'You can check your cart and manage cart', `${image}`);
    });
}

function deleteCart(productId) {
    toast('Your cart is loading', 'Please a second', '');
    if (confirm("Are you sure to delete this item?") == true) {
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
            toast('Delete item in cart success', 'You can check your cart and manage cart', ``);
        });
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
        $("#amountCart").html(Intl.NumberFormat().format(data.amount));
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
                            <span class="mb-0" style="width: 100%">${Intl.NumberFormat().format(result[i].price)}&nbsp;VND</span>
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
    if (confirm("Are you sure to continue pay this bill?") === true) {
        $('#btn-pay').attr('style', 'cursor: context-menu;').attr('disabled', 'disabled').click(false).html(`
            <div class="spinner-border text-warning" role="status">
                <span class="visually-hidden"></span>
            </div>
        `);
        let total = $('#total').text();
        total = total.replaceAll(",", "");
        total = total.replaceAll(".", "");

        let type = $('#type').text();
        if (type === "Momo") {
            fetch("/FoodLocationWeb/api/momo", {
                method: "post",
                body: JSON.stringify({
                    "total": total
                }),
                headers: {
                    "Content-Type": "application/json"
                }
            }).then(function (res) {
                return res.json();
            }).then(function (data) {
                window.location.replace(data.payUrl);
            });
        } else {
            fetch("/FoodLocationWeb/api/pay/", {
                method: "post",
                body: JSON.stringify({
                    "total": total,
                    "type": "Offline"
                }),
                headers: {
                    "Content-Type": "application/json"
                }
            }).then(function (res) {
                toast('Payment success', 'You can check your email for more detail', '');
                setTimeout(function () {
                    window.location.replace("/FoodLocationWeb/");
                }, 4000);
            });
        }
    }
}

function addComment(storeId, userId, id) {
    let content;
    if (id === undefined) {
        content = $("#message-text").val();
    } else {
        content = $('#' + id).val();
    }
    if (userId === undefined) {
        alert('Please sign in before comment!!')
    } else {
        fetch("/FoodLocationWeb/api/add-comment", {
            method: 'post',
            body: JSON.stringify({
                "content": content,
                "storeId": storeId
            }),
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function (res) {
            return res.json()
        }).then(function (data) {
            let createdDate = moment(data.createdDate).format("YYYY/MM/DD HH:MM:SS.S");
            $("#list-cmt").prepend(`  
            <div class="cmt-list">
                        <div class="info-comment">
                            <div class="info-comment-info">
                                <img src="${data.idUser.avatar}" alt="alt" class="avatar"/>
                                <div>
                                    <div style="font-weight: 500; color: black;">${data.idUser.firstName} ${data.idUser.lastName}</div>
                                    <div>${createdDate}</div>
                                </div>
                            </div>
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
            fetch(`/FoodLocationWeb/api/count-comments/${storeId}`).then(function (res) {
                return res.json()
            }).then(function (data) {
                $('#commentAmount').text(`${data[0]}`);
            })
        })
    }
    ;
}
function addRating(storeId, userId) {
    if (userId == null) {
        alert('ban chua dang nhap')
        window.location.replace("/FoodLocationWeb/login");
    } else {
        if (confirm('Are you sure to send this rating?') == true) {
            fetch("/FoodLocationWeb/api/add-rating", {
                method: 'post',
                body: JSON.stringify({
                    "rateQuality": $('input[name="rateQuality"]:checked').val(),
                    "rateService": $('input[name="rateService"]:checked').val(),
                    "rateSpace": $('input[name="rateSpace"]:checked').val(),
                    "ratePrice": $('input[name="ratePrice"]:checked').val(),
                    "rateLocation": $('input[name="rateLocation"]:checked').val(),
                    "storeId": storeId
                }),
                headers: {
                    "Content-Type": "application/json"
                }
            }).then(function (res) {
                return res.json();
            }).then(function (data) {
                console.log(data);
                $('#ratingAmount').html(`${parseFloat(data[0][0])}<p>Ratings</p>`);
                $('#ratingsQuality').text(`${parseFloat(data[0][1])}`);
                $('#ratingsService').text(`${parseFloat(data[0][2])}`);
                $('#ratingsSpace').text(`${parseFloat(data[0][3])}`);
                $('#ratingsPrice').text(`${parseFloat(data[0][4])}`);
                $('#ratingsLocation').text(`${parseFloat(data[0][5])}`);
            })
        }
    }
}


function deleteFollow(idFollow) {
    if (confirm("Are you sure to unfollow this store?") == true) {
        fetch(`/FoodLocationWeb/api/follow/${idFollow}`, {
            method: "delete"
        }).then(function (res) {
            console.log(res);

            $('#followID' + idFollow).attr('style', 'display: none !important');
        })
    }
}

function loadFollowByUser(idmenu, userId) {
    fetch("/FoodLocationWeb/api/check-follow").then(function (res) {
        return res.json()
    }).then(function (data) {
        let msg = "";
        for (let i = 0; i < data.length; i++) {
            msg += `
            <div class="col-3" id="followID${data[i].idFollow}">
                <div class="card mb-5">
                    <a href="${idmenu}${data[i].idStore.idUser}">
                        <img class="card-img-top" src="${data[i].idStore.avatar}" alt="Card image cap">
                    </a>
                    <div class="card-body" style="height: 168px; max-height: 168px;">
                        <a href="${idmenu}${data[i].idStore.idUser}">${data[i].idStore.nameStore}</a>
                        <p>${data[i].idStore.address}</p>
                        <div style="position: absolute;bottom: 0;margin-bottom: 15px;width:100%;">
                            <a href="#" style="float: right; margin-right: 20px;" id="follow${data[i].idStore.idUser}" onclick="deleteFollow(${data[i].idFollow})">
                                UnFollow
                            </a>
                        </div>    
                    </div>
                </div>
            </div>
            `;
        }
        let d = document.getElementById("listfollow");
        d.innerHTML = msg;
    });
}

function checkRating(idStore) {
    $('#check-rating').attr('style', 'display: none !important');
    fetch(`/FoodLocationWeb/api/check-rating/${idStore}`).then(function (res) {
        if (res.ok || res.status === 400) {
            $('#check-rating').attr('style', '');
            return null;
        } else {
            return res.json();
        }
    }).then(function (data) {
        if (data !== null) {
            console.log(data.errMsg);
        }
    });
}

$(document).ready(function () {

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

    $("#closeChat").click(function () {
        $('.table-chat-list').html('');
        $('.table-content-chat').html('');
        $(".table-chat").attr('style', 'display: none');
        $(".table-chat-content").attr('style', '');
        $(".table-chat-list").attr('style', '');
        $("#unColapseChat").attr('style', 'display: none;');
        $("#colapseChat").attr('style', 'display: block;');
    });

    $("#colapseChat").click(function () {
        $(".table-chat-content").attr('style', 'right: -165px; position: absolute;');
        $(".table-chat").attr('style', 'width: 165px;  display: block;');
        $(".table-chat-list").attr('style', 'width: 165px;');
        $(".list-chat").attr('style', 'width: 50%');
        $(this).attr('style', 'display: none;');
        $("#unColapseChat").attr('style', 'display: block;');

    });

    $("#unColapseChat").click(function () {
        $(".table-chat-content").attr('style', '');
        $(".table-chat").attr('style', 'display: block');
        $(".table-chat-list").attr('style', '');
        $(".list-chat").attr('style', '');
        $(this).attr('style', 'display: none;');
        $("#colapseChat").attr('style', 'display: block;');
        $("#box-chat").focus();
    });
});

var firebaseConfig = {
    apiKey: "AIzaSyDrVn3SF-6T5DPh1tiyWCD3fhHWfCnIQwA",
    authDomain: "foodlocationweb.firebaseapp.com",
    databaseURL: "https://foodlocationweb-default-rtdb.firebaseio.com",
    projectId: "foodlocationweb",
    storageBucket: "foodlocationweb.appspot.com",
    messagingSenderId: "1020827400329",
    appId: "1:1020827400329:web:63c5c8c89780f3b179ee58",
    measurementId: "G-8ESHVMH06K"
};

if (!window.firebase.apps.length) {
    window.firebase.initializeApp(firebaseConfig);
    window.firebase.analytics();
} else {
    window.firebase.app(); // if already initialized, use that one
}

function createRoom(id1, id2, userName, otherName, avatar, imgStore) {
    event.preventDefault();
    $(".table-chat").attr('style', 'display: block');
    $("#box-chat").focus();

    let roomName = "";
    if (id1 < id2)
        roomName = id1 + "-" + id2;
    else
        roomName = id2 + "-" + id1;

    const listChats = window.firebase.database().ref('room/' + id2).orderByChild("name").equalTo(id1).on("value", function (snapshot) {
        if (snapshot.exists() === true) {
            joinRoom(roomName, userName, otherName, imgStore);
        } else {
            window.firebase.database().ref('room/' + id1).push().set({
                "avatar": imgStore,
                "name": id2,
                "roomName": roomName,
                "otherPersonName": otherName
            });
            window.firebase.database().ref('room/' + id2).push().set({
                "avatar": avatar,
                "name": id1,
                "roomName": roomName,
                "otherPersonName": userName
            });
        }
    });
}

function joinRoom(roomName, userName, otherName, imgStore) {
    window.firebase.database().ref('chats/').off("child_added");
    $('.table-content-chat').html('');
    if ($(`#${roomName}`).length > 0) {
        var mess = Array.from(document.getElementsByClassName('list-chat'));
        mess.forEach(e => {
            e.style = '';
        });
        $(`#${roomName}`).attr('style', 'background-color: rgba(30, 209, 185, 0.3);');
    } else {
        $('.table-chat-list').append(`
            <div class="list-chat" id="${roomName}" style="background-color: rgba(30, 209, 185, 0.3);"><img src="${imgStore}" alt="hihi"></div>
        `);
    }

    const db = window.firebase.database().ref('chats/' + roomName);
    let scrollValue = 0;
    db.on("child_added", (snapshot) => {
        const data = snapshot.val();
        if (data.from === userName)
            $('.table-content-chat').append(
                    `<div class="d-flex justify-content-end mb-4 msg">
                        <div class="msg_cotainer_send">
                          ${data.content}
                        </div>
                    </div>
                `);
        else
            $('.table-content-chat').append(
                    `<div class="d-flex justify-content-start mb-4 msg">
                        <div class="msg_cotainer">
                          ${data.content}
                        </div>
                    </div>
                `);
        scrollValue += 1000;
    });
    $('.table-content-chat').scrollTop(10000);
    console.log(roomName);
    $('#btn-send-chat').click(function () {
        sendMsg(`${userName}`, `${otherName}`, `${roomName}`);
    });
}

function sendMsg(yourName, otherName, roomName) {
    console.log(roomName);
    window.firebase.database().ref('chats/' + roomName).push().set({
        "content": $('#box-chat').val(),
        "from": yourName,
        "to": otherName
    });
    $('#box-chat').val('');
    $('#box-chat').focus();
}

function initPage(username, userId) {

    $('.table-chat-list').html('');
    $('.table-content-chat').html('');

    $(".table-chat").attr('style', 'display: block');
    $("#box-chat").focus();

    const listChats = firebase.database().ref('room/' + userId);

    listChats.on("child_added", (snapshot) => {
        const data = snapshot.val();
        $('.table-chat-list').append(`
            <div class="list-chat" id="${data.roomName}" onclick="joinRoom('${data.roomName}', '${username}', '${data.otherPersonName}', '${data.avatar}');"><img src="${data.avatar}" alt="hihi"></div>
        `);
    });
    $('.table-chat-list').scrollTop();

}