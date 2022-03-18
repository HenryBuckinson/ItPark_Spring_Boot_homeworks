$(document).ready(function () {
    $('#getInfo').click(function () {
        let val = $('#valute').val();

        $.ajax({
            url: '/getRubInfo/valute?valute=' + val,
            type: 'POST',
            success: function (result) {
                $('#resultId').text('ID валюты: ' + result.id);
                $('#resultName').text('Наименование валюты: ' + result.name);
                $('#resultValue').text('Значение валюты по отношению к RUB: ' + result.value);
            }
        });
    })
    $('body').on('input', '#firstValue', function () {
        this.value = this.value.replace(/[^0-9]/g, '');
    });
    $('body').on('input', '#secondValute', function () {
        this.value = this.value.toUpperCase();
    });
    $('body').on('input', '#valute', function () {
        this.value = this.value.toUpperCase();
    });
    $('#converter').click(function () {
        let selectedValute = $('#secondValute').val();
        let interestingValue = $('#firstValue').val();

        $.ajax({
            url: '/getRubInfo/converter?specValute=' + selectedValute,
            type: 'POST',
            success: function (result) {
                $('#secondValue').text(Math.round((result.nominalValue / result.value) * interestingValue * 100) / 100);
            }
        })
    })
})
