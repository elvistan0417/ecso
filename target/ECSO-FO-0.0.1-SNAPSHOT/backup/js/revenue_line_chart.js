var MONTHS = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
var randomColorFactor = function () {
    return Math.round(Math.random() * 255);
};
var randomScalingFactor = function () {
    return Math.round(Math.random() * 250);
    //return 0;
};
var randomColor = function (opacity) {
    return 'rgba(' + randomColorFactor() + ',' + randomColorFactor() + ',' + randomColorFactor() + ',' + (opacity || '.3') + ')';
};
var firstData = $('.item_sorter').find('button.active').data('datas');
var config = {
    type: 'line',
    data: {
        labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
        datasets: [{
                label: ['2016 Revenue'],
                data: firstData,
                lineTension: 0,
                fill: true,
                backgroundColor: "rgba(255,76,21,0.1)",
                borderColor: "#ff4c15",
                borderWidth: 1
            }]
    },
    options: {
        responsive: true,
        maintainAspectRatio: false,
        legend: {
            position: 'bottom',
            display: true
        },
        hover: {
            mode: 'label'
        },
        scales: {
            xAxes: [{
                    display: true,
                    ticks: {
                        fontSize: 10
                    },
                    scaleLabel: {
                        display: false,
                        labelString: 'Month'

                    }
                }],
            yAxes: [{
                    display: true,
                    ticks: {
                        beginAtZero: true,
                        steps: 15,
                        fontSize: 10
                    },
                    scaleLabel: {
                        display: true,
                        labelString: 'Value (MYR)'
                    }
                }]
        },
        title: {
            display: true,
            text: '2016 Revenue',
            fontFamily: "'Source Sans Pro', 'sans-serif'",
            fontSize: 16,
            fontColor: "#ffffff"
        }
    }
};
$.each(config.data.datasets, function (i, dataset) {
    //var background = randomColor(0.5);
    //dataset.borderColor = "#ff4c15";
    //dataset.backgroundColor = background;
    dataset.pointBorderColor = "#ff4c15";
    dataset.pointBackgroundColor = "#ff4c15";
    dataset.pointBorderWidth = 2;
});
//window.onload = function () {
//    var ctx = document.getElementById("line_chart_canvas").getContext("2d");
//    window.myLine = new Chart(ctx, config);
//};

$('#randomizeData').click(function () {
    $.each(config.data.datasets, function (i, dataset) {
        dataset.data = dataset.data.map(function () {
            return randomScalingFactor();
        });
    });
    window.myLine.update();
});
$('#addDataset').click(function () {
    var newDataset = {
        label: 'Dataset ' + config.data.datasets.length,
        borderColor: randomColor(0.4),
        backgroundColor: randomColor(0.5),
        pointBorderColor: randomColor(0.7),
        pointBackgroundColor: randomColor(0.5),
        pointBorderWidth: 1,
        borderWidth: 1,
        data: [],
        lineTension: 0
    };

    for (var index = 0; index < config.data.labels.length; ++index) {
        newDataset.data.push(randomScalingFactor());
    }

    config.data.datasets.push(newDataset);
    window.myLine.update();
});
$('#addData').click(function () {
    if (config.data.datasets.length > 0) {
        var month = MONTHS[config.data.labels.length % MONTHS.length];
        config.data.labels.push(month);
        $.each(config.data.datasets, function (i, dataset) {
            dataset.data.push(randomScalingFactor());
        });
        window.myLine.update();
    }
});
$('#removeDataset').click(function () {
    config.data.datasets.splice(0, 1);
    window.myLine.update();
});
$('#removeData').click(function () {
    config.data.labels.splice(-1, 1); // remove the label first

    config.data.datasets.forEach(function (dataset, datasetIndex) {
        dataset.data.pop();
    });
    window.myLine.update();
});
var yearLabel = $('.item_sorter').find('button.active').text();
$('.item_sorter_label .year_holder').prepend(yearLabel);


$('.item_sorter button').click(function () {
    $('.item_sorter button').removeClass('active');
    $(this).addClass('active');
    myLine.destroy();
    var thisText = $(this).text();
    var titleText = $(this).data('title');
    var lineData = $(this).data('datas');
    $('.item_sorter_label .year_holder').text('').prepend(thisText + '<span class="dropdown_icon lnr lnr-chevron-down"></span>');
    var config = {
        type: 'line',
        data: {
            labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
            datasets: [{
                    label: [],
                    data: lineData,
                    lineTension: 0,
                    fill: true,
                    backgroundColor: "rgba(255,76,21,0.1)",
                    borderColor: "#ff4c15",
                    borderWidth: 1
                }]

        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            legend: {
                position: 'bottom',
                display: false
            },
            hover: {
                mode: 'label'
            },
            scales: {
                xAxes: [{
                        display: true,
                        ticks: {
                            fontSize: 10
                        },
                        scaleLabel: {
                            display: false,
                            labelString: 'Month'

                        }
                    }],
                yAxes: [{
                        display: true,
                        ticks: {
                            beginAtZero: true,
                            steps: 15,
                            fontSize: 10
                        },
                        scaleLabel: {
                            display: true,
                            labelString: 'Value (MYR)',
                        }
                    }]
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
    $.each(config.data.datasets, function (i, dataset) {
        //var background = randomColor(0.5);
        //dataset.borderColor = "#ff4c15";
        //dataset.backgroundColor = background;
        dataset.pointBorderColor = "#ff4c15";
        dataset.pointBackgroundColor = "#ff4c15";
        dataset.pointBorderWidth = 2;
    });

    $('#addDataset').click(function () {
        var newDataset = {
            label: 'Dataset ' + config.data.datasets.length,
            borderColor: randomColor(0.4),
            backgroundColor: randomColor(0.5),
            pointBorderColor: randomColor(0.7),
            pointBackgroundColor: randomColor(0.5),
            pointBorderWidth: 1,
            borderWidth: 1,
            data: [],
            lineTension: 0
        };

        for (var index = 0; index < config.data.labels.length; ++index) {
            newDataset.data.push(randomScalingFactor());
        }

        config.data.datasets.push(newDataset);
        window.myLine.update();
    });

    var ctx1 = document.getElementById("canvas_line").getContext("2d");
    window.myLine = new Chart(ctx1, config);
});