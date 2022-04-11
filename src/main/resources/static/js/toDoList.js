$(document).ready(function () {

    $('.rowInfo > #noteText').blur(function () {
        let textNote = $(this).text();
        let textOrder = this.previousElementSibling.textContent;
        let numberOrder = Number(textOrder);
        if (textNote === "") {
            $.ajax({
                url: '/notes/update/' + numberOrder,
                type: 'DELETE',
                success: function () {
                    alert('Пустая заметка удалена!');
                    location.href = '/notes';
                }
            });
        } else {
            $.ajax({
                url: '/notes/update/' + textNote + '/' + numberOrder,
                type: 'POST',
                success: function () {
                    alert('Заметка обновлена!');
                }
            });
        }
    })//скриипт обрабатывает текстовое поле заметки

    $('.rowInfo').on('change', '#statusNoteSelector', function () {
        let val = $(this).val();
        let parent = $(this).parent().parent().parent();
        let textOrder = parent[0].firstElementChild.childNodes[0].textContent;
        let numberNoteOrder = Number(textOrder);
        // alert(val)
        // alert(numberNoteOrder)
        if (val === "0") {
            let response = String(false);
            $.ajax({
                url: '/notes/progress/' + numberNoteOrder + "/" + response,
                type: 'POST',
                success: function () {
                    alert('Заметка в процессе выполнения');
                }
            });
        }
        if (val === "1") {
            let response = String(true);
            $.ajax({
                url: '/notes/progress/' + numberNoteOrder + "/" + response,
                type: 'POST',
                success: function () {
                    alert('Заметка завершена!');
                }
            });
        }
    })//скрипт для обработки статуса заметки

    // $('.complete').click(function (){
    //     $('#onlyOneRow').css('background-color','darkseagreen');
    // })//скрипт для визуализации выполненной задачи
    //
    // $('.inProgress').click(function (){
    //     $('#onlyOneRow').css('background-color','darkgrey');
    // })//скрипт для визуализации задачи которая выполняется

});