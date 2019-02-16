<?php
<<<<<<< HEAD
/* è¿žæŽ¥æ•°æ®åº“ */
$link = mysqli_connect('120.79.92.84', 'root', 'root', 'xhxt?useSSL=false');
if (!$link) {
	printf("Can't connect to MySQL Server. Errorcode: %s ", mysqli_connect_error());
	exit ();
}
mysqli_query($link, 'set names gb2312'); /* è§£å†³ä¸­æ–‡ä¹±ç çš„é—®é¢˜ */
=======
/* Á¬½ÓÊý¾Ý¿â */
$link = mysqli_connect ( '120.79.92.84', 'root', 'root', 'xhxt?useSSL=false' );
if (! $link) {
	printf ( "Can't connect to MySQL Server. Errorcode: %s ", mysqli_connect_error () );
	exit ();
}
mysqli_query ( $link, 'set names gb2312' ); /* ½â¾öÖÐÎÄÂÒÂëµÄÎÊÌâ */
>>>>>>> branch 'alway_beach' of https://github.com/zly19980908/testpro.git
?>
