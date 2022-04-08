$(document).ready(function () {
    $('#deleteRow').click(function (){
        let number;
        $('.orderNumberHead').each(function (index, value){
            if($('.orderNumberHead').length <= 1){
                alert("Удалять нечего!")
                return;
            }
            console.log( index + ": " + value.textContent );
            let textContent = value.textContent;
            number=value.textContent
        })
        let resultNumber = Number(number);
        alert(number)
        $.ajax({
            url: '/notes/delete/' + resultNumber,
            type: 'DELETE',
            success: function () {
                location.href = '/notes';
                alert('Удаление прошло успешно!');
            }
        });
    })

});