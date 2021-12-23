//展开二级评论
function collapse(e) {
    var id = parseInt(e.getAttribute("data-id"));

    var collClass = $('#collapseExample'+id).attr("class");
    if (collClass == 'collapse'){
        //获取评论方法
        getComment(id);

        $('#comment_button'+id).attr("class","btn btn-info pull-right");
        $('#collapseExample'+id).attr("class","collapse in");
    }else{
        $('#comment_button'+id).attr("class","btn btn-default pull-right");
        $('#collapseExample'+id).attr("class","collapse");
    }
    //console.log(id);
}
//回复评论    二级评论
function replyComment(id){
    var input = document.getElementById("replycontent"+id).value;
    console.log(input)
    if ($('#replycontent'+id).val().length > 0){
    var commId = id;
        $.ajax({
            url: '/createComment',
            type: 'post',
            dataType: 'text',
            data: {
                parentId: commId,
                type:1,
                content:$('#replycontent'+id).val(),
                questionId:$('#questionIdSpan').attr("data-id")
            },
            success: function (data) {
                var count = parseInt(data);
                if (count > 0){
                    $('#replycontent'+id).val("")
                    //获取评论方法
                    getComment(commId);

                }else{
                    alert("回复失败，服务器错误")
                    console.log("回复失败，服务器错误")

                }
            }

        })
    } else {
        alert("不可为空")
    }

}
//获取评论
function getComment(id) {
    $.ajax({
        url: '/getSecondComment',
        type: 'post',
        dataType: 'json',
        data: {
            parentId:id
        },
        success:function (data) {
            if (data.length > 0){
                var commentHtml = '';


                for (var i =0; i<data.length;i++) {
                    var dateTime = new Date(data[i].createTime);
                    commentHtml+= '<h6>' +
                        '<img class="img-circle" src="'+data[i].user.uimage+'" alt="头像" style="width: 30px; height: 30px;">' +
                        '<a href="#" style="margin-left: 10px;">'+data[i].user.name+'</a>•' +
                        '<span class="text-muted">'+dateTime.getFullYear() + '-' + (dateTime.getMonth() + 1) + '-' + dateTime.getDate()+' '+dateTime.getHours()+'点</span>' +
                        '<a href="#" class="pull-right">回复</a>' +
                        '<p style="margin-top: 10px;margin-left:42px;">'+data[i].content+'</p>' +
                        '</h6>';
                }
                $('#secondComment'+id).html(commentHtml);
            }else{
                $('#secondComment'+id).html('<p class="text-muted">还没有一条回复噢！</p>');
            }



        }
    })
}

//点赞
function like(e) {

    $.ajax({
        url: '/getSessionUser',
        type: 'post',
        dataType: 'text',
        data: {
        },
        success:function (data) {
            data = parseInt(data);

            if (data > 0){

                var id = parseInt(e.getAttribute("data-id"));
                if ($('#like_button'+id).attr("class") == "btn btn-default pull-right"){
                    var likeCount = parseInt($('#com_like'+id).html().split(';')[1]);

                    likeComment(id,1,likeCount);
                    $('#like_button'+id).attr("class","btn btn-info pull-right")

                    likeCount = likeCount+1;
                    $('#com_like'+id).html('&nbsp;'+likeCount)
                }else{
                    var likeCount = parseInt($('#com_like'+id).html().split(';')[1]);

                    if (likeCount > 0){

                        likeComment(id,0,likeCount)

                        $('#like_button'+id).attr("class","btn btn-default pull-right")

                        likeCount = likeCount-1;
                        $('#com_like'+id).html('&nbsp;'+likeCount)

                    }



                }

            } else{

                alert("去登录就可以点赞了哟")
            }

        }
    })











}


function likeComment(id,of,likeCount) {
    $.ajax({
        url: '/likeComm',
        type: 'post',
        dataType: 'text',
        data: {
            commentId:id,
            likeOrOff:of,
            likeCount:likeCount
        },
        success:function (data) {
            data = parseInt(data);



        },error: function (xhr) {
            // 隐藏 loading
            // 只有请求不正常（状态码不为200）才会执行
            console.log('error', xhr)
        }
    })
}

//判断session的用户是否存在
function sessionUser(){
    var count = 0;


}
