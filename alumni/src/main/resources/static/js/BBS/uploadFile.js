
$('#fileUpload').change(function (e) {

    if ($(this).val() != ""){
        //文件对象
        var file = e.currentTarget.files[0];

        var formFile = new FormData();

        formFile.append("file", file); //加入文件对象
        var data = formFile;
        $.ajax({
            url: "/upload",
            data: data,
            type: "Post",
            dataType: "text",
            cache: false,//上传文件无需缓存
            processData: false,//用于对data参数进行序列化处理 这里必须false
            contentType: false, //必须
            success: function (result) {

                var count = $('#img_url').children('span').length;


                $('#img_url').append('<span class="text-success">第'+(count+1)+'张图片地址：<font color="blue">'+result+'</font></span><br/>')


            }
        })
    }

})
