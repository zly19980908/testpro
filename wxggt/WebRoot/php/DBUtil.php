<?php
/* 连接数据库 */
$conn = mysqli_connect('120.79.92.84', 'root', 'root', 'xhxt?useSSL=false');
if (!$conn) {
	printf("Can't connect to MySQL Server. Errorcode: %s ", mysqli_connect_error());
	exit ();
}
mysqli_query($conn, 'set names utf8'); /* 解决中文乱码的问题 */
?>