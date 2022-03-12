$(document).ready(function () {

    alert("Welcome!")

    $('#searchButton').click(function (){
        console.log('Отработал щелчок по кнопке!')

        var text = $('#inputString').val();
        console.log('В поле поиска введён: ' + text)

        console.log('URL-запрос сформирован! Сейчас откроется ссылка...')

        if($('#srhApply1').is(':checked')){
            let url = new URL('https://www.google.com/search?q=' + text);
            open(url)
        }
        if($('#srhApply2').is(':checked')){
            let url = new URL('https://search.yahoo.com/search?p=' + text);
            open(url)
        }
        if($('#srhApply3').is(':checked')){
            let url = new URL('https://www.bing.com/search?q=' + text);
            open(url)
        }
        else{
            alert('Переключатель не выбран!')
            console.log('Переключатель не выбран!')
        }

    })

})
