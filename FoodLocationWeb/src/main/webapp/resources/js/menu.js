
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
            <div class="col">
                <div class="card mb-5" style="width: 18rem;">
                    <a href="${idmenu}${data[i].idUser}">
                        <img class="card-img-top" src="${data[i].avatar}" alt="Card image cap">
                    </a>
                    <div class="card-body">
                        <a href="${idmenu}${data[i].idUser}">${data[i].nameStore}</a>
                        <p>${data[i].address}</p>
                        <a style="margin-right: 5px">
                            <i class="bi bi-chat-fill"></i>
                            <span>9</span>
                        </a>
                        <a style="margin-right: 5px">
                            <i class="bi bi-camera-fill"></i>
                            <span>12</span>
                        </a>
                        <a style="float: right">
                            <i class="bi bi-bookmark-fill"></i> Luu
                        </a>

                    </div>
                </div>
            </div>
            `;
        }
        let d = document.getElementById("listmenu");
        d.innerHTML = msg;
    })
}

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
    }).then(function(res) {
        return res.json();
    }).then(function(data) {
        let counter = document.getElementById("cartCounter").value = data
        counter.value = data
    })
}

function deleteCart(productId) {
    if (confirm("Ban chac chan xoa item nay khong?") == true) {
        fetch(`/FoodLocationWeb/api/cart/${productId}`, {
            method: "delete"
        }).then(function(res) {
            return res.json()
        }).then(function(data) {
            let counter = document.getElementById("cartCounter")
            counter.innerText = data.counter
            let amount = document.getElementById("amountCart")
            amount.innerText = data.amount
    //        location.reload()
            let row = document.getElementById(`product${productId}`)
            row.style.display = "none"
        }) 
    }
}

function updateCart(obj, productId) {
    fetch("/FoodLocationWeb/api/cart", {
        method: "put",
        body: JSON.stringify({
            "menuId": productId,
            "menuName": "",
            "price": 0,
            "quantity": obj.value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res) {
        return res.json()
    }).then(function(data) {
        let counter = document.getElementById("cartCounter")
        counter.innerText = data.counter
        let amount = document.getElementById("amountCart")
        amount.innerText = data.amount
    }) 
}
