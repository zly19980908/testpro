<?php
/* �������ݿ� */
$link = mysqli_connect ( '120.79.92.84', 'root', 'root', 'xhxt?useSSL=false' );
if (! $link) {
	printf ( "Can't connect to MySQL Server. Errorcode: %s ", mysqli_connect_error () );
	exit ();
}
mysqli_query ( $link, 'set names gb2312' ); /* ���������������� */
?>