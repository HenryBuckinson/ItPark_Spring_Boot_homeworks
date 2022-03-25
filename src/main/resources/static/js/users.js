$(function () {
    $('#createUser').click(function (){
        $.ajax({
            url: 'api/home/create',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: 'POST',
            data: JSON.stringify({
                'id': $('#id').val(),
                'login': $('#login').val(),
            }),
            success: function () {
                alert('Создание успешно!');
                $('#id').val('')
                $('#login').val('')
            }
        });
    });

})