<?php
<<<<<<< HEAD
/* 连接数据库 */
$link = mysqli_connect('120.79.92.84', 'root', 'root', 'xhxt?useSSL=false');
if (!$link) {
	printf("Can't connect to MySQL Server. Errorcode: %s ", mysqli_connect_error());
	exit ();
}
mysqli_query($link, 'set names gb2312'); /* 解决中文乱码的问题 */
=======
/* �������ݿ� */
$link = mysqli_connect ( '120.79.92.84', 'root', 'root', 'xhxt?useSSL=false' );
if (! $link) {
	printf ( "Can't connect to MySQL Server. Errorcode: %s ", mysqli_connect_error () );
	exit ();
}
mysqli_query ( $link, 'set names gb2312' ); /* ���������������� */
>>>>>>> branch 'alway_beach' of https://github.com/zly19980908/testpro.git
?>
