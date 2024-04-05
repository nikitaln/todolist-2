$(function(){
    $('#btn-show-form').click(function(){
        $('.task-form').css('display', 'flex');
    });

    $(document).mouseup(function (e){ // событие клика по странице
        if (!$('.task-form').is(e.target) && // если клик сделан не по элементу
            $('.task-form').has(e.target).length === 0) { // если клик сделан не по вложенным элементам
            $('.task-form').css('display', 'none');// скрываем блок
        }
    });
});