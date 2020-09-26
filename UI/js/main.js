$('#form').submit(function (e) {
    e.preventDefault();
    const dataObj = $(this)
        .serializeArray()
        .reduce(function (a, x) {
            a[x.name] = x.value;
            return a;
        }, {});
    dataObj['created_at'] = new Date().toISOString();
    console.log(dataObj);

    dataObj[''];
    $.ajax({
        url: 'http://localhost:8000/api/coach-service/coach/',
        data: JSON.stringify(dataObj),
        cors: true,
        contentType: 'application/json',
        headers: {
            'Access-Control-Allow-Origin': '*',
        },
        type: 'post',
        success: function (result) {
            $('#result').html(result);
        },
    });
});

$('#findAll').on('click', function (e) {
    $.ajax({
        url: 'http://localhost:8000/api/coach-service/coach/',
        cors: true,
        contentType: 'application/json',
        headers: {
            'Access-Control-Allow-Origin': '*',
        },
        type: 'get',
        success: function (result) {
            console.log(result);
            const data = JSON.stringify(result);
            $('#resultFind').html(`<div>${data}</div>`);
        },
    });
});
