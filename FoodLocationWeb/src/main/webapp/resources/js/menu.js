
function loadAdminMenu(endpoint, menudetail) {
    fetch(endpoint).then(function (res) {
        console.log("NGU");
        return res.json();
    }).then(function (data) {
        console.log("NGU");
        let msg = "";
        for (let i = 0; i < data.length; i++) {
            msg += `
            <tr>
                    <th scope="row">${i}</th>
                    <td>${data[i].idMenu}</td>
                    <td>${data[i].menuName}</td>
                    <td>${data[i].price}</td>
                    <td>${data[i].idStore}</td>
                    <td>${data[i].menuNote}</td>
                    <td>${data[i].menuFrom}</td>
                    <td>${data[i].menuTo}</td>
                    <td>${data[i].idType}</td>
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
        console.log("NGU");
        return res.json();
    }).then(function (data) {
        console.log("NGU");
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
