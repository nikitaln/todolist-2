$(function(){
    $('#btn-show-users').css('background-color', 'red');

        $('#btn-list-tasks').click(function(){
            $(window).prop("location", "/tasks");
            $('#btn-list-tasks').css('background-color', 'red');
        });

});