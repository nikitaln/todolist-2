$(function(){
    $('#btn-show-form').click(function(){
        $('.task-form').css('display', 'flex');
    });

    $('#btn-save').click(function(){
        $('.task-form').css('display', 'none');
    });

    $('#btn-list-tasks').click(function(){
        $('.task-form').css('display', 'none');
        $('.list-all-users').css('display', 'none');
        $('.main-list-tasks').css('display', 'flex');
    });

    $('#btn-show-users').click(function(){
        $('.task-form').css('display', 'none');
        $('.main-list-tasks').css('display', 'none');
        $('.list-all-users').css('display', 'flex');
    });
});