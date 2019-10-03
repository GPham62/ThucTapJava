jQuery(document).ready(function ($) {
    $('#btn-login').on('click', function (event) {
        
        $.ajax({
            type: "POST",
            url:"user/login",
            data: JSON.stringify(jData),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                $('.loading').hide();
                if (data.error_code === 0) {
                  
                }  else {
                    $(".modal-body").text("Đăng nhập thất bại");
                    $("#myModal").modal('show');
                }

            },
            failure: function (errMsg) {
                $('.loading').hide();
                $(".modal-body").text("Không kết nối được tới máy chủ");
                $("#myModal").modal('show');
            }
        });

    });
});


//credits https://css-tricks.com/snippets/jquery/move-cursor-to-end-of-textarea-or-input/
jQuery.fn.putCursorAtEnd = function () {
    return this.each(function () {
        // If this function exists...
        if (this.setSelectionRange) {
            // ... then use it (Doesn't work in IE)
            // Double the length because Opera is inconsistent about whether a carriage return is one character or two. Sigh.
            var len = $(this).val().length * 2;
            this.setSelectionRange(len, len);
        } else {
            // ... otherwise replace the contents with itself
            // (Doesn't work in Google Chrome)
            $(this).val($(this).val());
        }
    });
};