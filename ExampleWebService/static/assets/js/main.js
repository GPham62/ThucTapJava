jQuery(document).ready(function ($) {
    const input = document.getElementById("search-input");
    const searchBtn = document.getElementById("search-btn");
    function expand() {
        $(".search").toggleClass("close");
        $(".input").toggleClass("square");
        if ($('.search').hasClass('close')) {
            $('input').focus();
        } else {
            $('input').blur();
        }
    }
    $('button').on('click', expand);
    
    $('#content').submit(function(e){
        const input = document.getElementById("search-input");
        console.log(input.value);
        return false;
    })
});
