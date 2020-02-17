var titleText = $('tr.selected td:nth-of-type(3)').text();
var pieData1 = $('tr.selected td:nth-of-type(4)').text();
var pieData2 = $('tr.selected td:nth-of-type(5)').text();
var config1 = {
    type: 'pie',
    data: {
        datasets: [{
                data: [pieData1, pieData2],
                backgroundColor: [
                    "#2c2c2c",
                    "#ff4c15"
                ],
                borderWidth: "0",
                borderColor: "#202020"

            }],
        labels: [
            "Clicks",
            "Conversion"


        ]
    },
    options: {
        responsive: true,
        legend: {
            display: true,
            position: "bottom",
            onClick: function (e) {
                e.stopPropagation();
            }

        },
        tooltips: {
            enabled: true
        },
        title: {
            display: true,
            text: titleText,
            fontFamily: "'Source Sans Pro', 'sans-serif'",
            fontSize: 16,
            fontColor: "#ffffff"

        }
    }
};

//window.onload = function () {
//    var ctx1 = document.getElementById("canvas_pie").getContext("2d");
//    window.myPie = new Chart(ctx1, config);
//
//
//};

$('.clickable').click(function () {
    $('.clickable').removeClass('selected');
    $(this).addClass('selected');
    myPie.destroy();

    var NewTitleText = $('tr.selected td:nth-of-type(3)').text();
    var newPieData1 = $('tr.selected td:nth-of-type(4)').text();
    var newPieData2 = $('tr.selected td:nth-of-type(5)').text();


    var config1 = {
        type: 'pie',
        data: {
            datasets: [{
                    data: [newPieData1, newPieData2],
                    backgroundColor: [
                        "#2c2c2c",
                        "#ff4c15"
                    ],
                    borderWidth: "0",
                    borderColor: "#202020"

                }],
            labels: [
                "Clicks",
                "Conversion"


            ]
        },
        options: {
            responsive: true,
            legend: {
                display: true,
                position: "bottom",
                onClick: function (e) {
                    e.stopPropagation();
                }

            },
            tooltips: {
                enabled: true
            },
            title: {
                display: true,
                text: NewTitleText,
                fontFamily: "'Source Sans Pro', 'sans-serif'",
                fontSize: 16,
                fontColor: "#ffffff"

            }
        }
    };

    var ctx1 = document.getElementById("canvas_pie").getContext("2d");
    window.myPie = new Chart(ctx1, config1);
});
$('.clickable').each(function () {


    var frstCol = $(this).find('td:nth-of-type(5)').text();
    var seCol = $(this).find('td:nth-of-type(4)').text();
    //alert(frstCol);

    var result = (parseInt(frstCol) / parseInt(seCol)) * 100;
    console.log(result);
    if (isNaN(result))
        $(this).find('td:nth-of-type(6)').text(0);
    else
        $(this).find('td:nth-of-type(6)').text(result.toFixed(2) + '%');
});


