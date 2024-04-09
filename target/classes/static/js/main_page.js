$(function(){
     $('#btn-show-users').click(function(){
            $(window).prop("location", "/users");
//                        $('#btn-list-tasks').css('background-color', '#49926E');
                        $('#btn-show-users').css('background-color', 'red');


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
//                $('#btn-show-users').css('background-color', '#49926E');
                $('#btn-list-tasks').css('background-color', 'red');

//        $('.list-all-users').css('display', 'none');
//        $('.main-list-tasks').css('display', 'flex');
//        $('#btn-list-tasks').css('background-color', 'red');
//        $('#btn-show-users').css('background-color', '#f0f0f0');
    });
//
//    $('#btn-show-users').click(function(){
//        $('.main-list-tasks').css('display', 'none');
//        $('.list-all-users').css('display', 'flex');
//        $('#btn-list-tasks').css('background-color', '#f0f0f0');
//        $('#btn-show-users').css('background-color', 'red');
//    });
});