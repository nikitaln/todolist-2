$(function(){

    $('#btn-list-tasks').css('background-color', 'red');


     $('#btn-show-users').click(function(){
        $(window).prop("location", "/users");
        var btnClr = $('#btn-show-users').css('background-color', 'red');

     });


    $('#btn-show-form').click(function(){
        $('.task-form').css('display', 'flex');
    });


    $(document).mouseup(function (e){ // событие клика по странице
        if (!$('.task-form').is(e.target) && // если клик сделан не по элементу
            $('.task-form').has(e.target).length === 0) { // если клик сделан не по вложенным элементам
            $('.task-form').css('display', 'none');// скрываем блок
        }
    });


    $('#btn-list-tasks').click(function(){
        $(window).prop("location", "/tasks");
            $('#btn-list-tasks').css('background-color', 'red');
    });
});