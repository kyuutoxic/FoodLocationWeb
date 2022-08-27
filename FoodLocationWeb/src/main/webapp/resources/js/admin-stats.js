function checkMonth(){
    if ($(`#monthRevenue`).val() !== '0') {
        $(`#quarterRevenue option[value=0]`).attr('selected', 'selected');
        $(`#quarterRevenue`).attr('style', 'pointer-events: none;');
        $(`.quarterRevenue`).attr('style', 'cursor: not-allowed;');
    } else {
        $(`#quarterRevenue`).attr('style', '');
        $(`.quarterRevenue`).attr('style', '');
    }
    if ($(`#quarterRevenue`).val() !== '0') {
        $(`#monthRevenue option[value=0]`).attr('selected', 'selected');
        $(`#monthRevenue`).attr('style', 'pointer-events: none;');
        $(`.monthRevenue`).attr('style', 'cursor: not-allowed;');
    } else {
        $(`#monthRevenue`).attr('style', '');
        $(`.monthRevenue`).attr('style', '');
    }
}

var urlParams = new URLSearchParams(window.location.search);
$(document).ready(function () {
    $('#resetAll').click(function(){
        $(`#quarterRevenue option[value=0]`).attr('selected', 'selected');
        $(`#monthRevenue option[value=0]`).attr('selected', 'selected');
        $(`#idStoreRevenue option[value=0]`).attr('selected', 'selected');
        window.location.replace("/admin/stats");
    });
    $(`#idStoreRevenue option[value=${urlParams.get('idStore')}]`).attr('selected', 'selected');
    $(`#monthRevenue option[value=${urlParams.get('month')}]`).attr('selected', 'selected');
    $(`#quarterRevenue option[value=${urlParams.get('quarter')}]`).attr('selected', 'selected');
    if(`${urlParams.get('year')}` !== 'null'){
        $(`#yearStoreRevenue`).val(`${urlParams.get('year')}`);
    }else{
        $(`#yearStoreRevenue`).val(new Date().getFullYear());
    }
    checkMonth();
    $(`#monthRevenue, #quarterRevenue`).change(function(){checkMonth()});
});



function revenueStats(labels, data) {
    const ctx = document.getElementById('revenueChart').getContext('2d');
    const myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                    label: 'Thong ke doanh thu',
                    data: data,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}

