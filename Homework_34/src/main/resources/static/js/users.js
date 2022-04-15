$(function () {
    $('#createUser').click(function () {
        $.ajax({
            url: 'api/users',
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
    });//Event for button-create

    $('#refresh').click(function () {
        $.ajax({
            url: '/api/users',
            type: 'GET',
            success: function (result) {
                let users = result;
                let usersTab = $('#usersBody').html('');
                for (let i = 0; i < users.length; i++) {
                    usersTab.append('<tr>')
                        .append('<td>' + users[i].id + '</td>')
                        .append('<td>' + users[i].login + '</td>')
                        .append('</tr>')
                        .append('<br>')
                }
            }
        })
    })//Event for button-refresh

    $('#deleteUser').click(function () {
        let idValue = prompt("Введите ID или Login для удаления:");

        if (!isNaN(idValue)) {
            $.ajax({
                url: '/api/by-id/' + idValue,
                type: 'DELETE',
                success: function () {
                    alert('Удаление прошло успешно!');
                }
            });
        }
        if (isNaN(idValue)) {
            $.ajax({
                url: 'api/by-login/' + idValue,
                type: 'DELETE',
                success: function () {
                    alert('Удаление прошло успешно!');
                }
            });
        }


    });//Event for button-delete


    $('body').on('input', '#id', function () {
        this.value = this.value.replace(/[^0-9]/g, '');
    });//Constraint for id-input
})