var MP={
  successAlert:function(str){ //调用成功的方法
    var html='<div class="alert alert-success mp-alert" >'
            +'<span class="mp-alert-text">'+str+'</span>';
             
    var obj=$(html);
    obj.appendTo(document.body);
    var w=obj.width();
    if(w>1) w=w/2;
    //提示框居中显示
    obj.css("margin-left", "-"+w+"px");
    //延时自动关闭
    setTimeout(function () {
       obj.remove();
    }, 600);            
     
  },
  errorAlert:function(str){ //调用失败的方法
    var html='<div class="alert alert-danger mp-alert" >'
            +'<span class="mp-alert-text">'+str+'</span>';    
             
    var obj=$(html);
    obj.appendTo(document.body);
    var w=obj.width();
    if(w>1) w=w/2;
    obj.css("margin-left", "-"+w+"px");
    setTimeout(function () {
       obj.remove();
    }, 3000);          
  },
  loadingAlert:function(str){
     $('<div class="alert alert-info mp-alert" >'+str+'</div>').appendTo(document.body);
  },
  removeAlert:function(obj){
    $(obj).remove();
  }
};
 
$(function(){
  $(document).on("click",".close",function(){
    var obj=$(this).parenmp(".mp-alert");
    obj.remove();
  });
   
});