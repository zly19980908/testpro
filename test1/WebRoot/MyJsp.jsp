<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 
<html>
    <head>
        <meta name="viewport" content="width=device-width" />
        <title></title>
 
        <script type="text/javascript">
            function getFileUrl(sourceId) {
                var url;
                if (navigator.userAgent.indexOf("MSIE")>=1) { // IE
                    url = document.getElementById(sourceId).value;
                } else if(navigator.userAgent.indexOf("Firefox")>0) { // Firefox
                    url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
                } else if(navigator.userAgent.indexOf("Chrome")>0) { // Chrome
                    url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
                }
                return url;
            }
            function preImg(sourceId, targetId) { 
                var url = getFileUrl(sourceId); 
                var imgPre = document.getElementById(targetId); 
                imgPre.src = url; 
            } 
        </script> 
 
    </head>
    <body>
        <div>
                <br />
                <br />
                <a>上传者：<input type="text" /></a>
                <br />
                <br />
                <form action="">
                    <input type="file" name="imgOne" id="imgOne" onchange="preImg(this.id,'photo');" />
                    <br />
                    <br />
                    <img id="photo" src="" width="300px" height="300px" style="display: block;" />
                </form> 
        </div>
    </body>
</html>
