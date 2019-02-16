<?php
<<<<<<< HEAD
include ('DBUtil.php');
$q = $_GET['tno'];
$sql = "SELECT COUNT(*) FROM teacherinfo WHERE tno='$q'";
if ($result = mysqli_query($link, $sql)) {
	/* å°†ç»“æžœå­˜åœ¨My_arrayä¸­ */
	$My_array = array ();
	/* è¿”å›žæŸ¥è¯¢çš„ç»“æžœ */
	while ($row = mysqli_fetch_assoc($result)) {
		/* é˜²æ­¢ä¸­æ–‡ä¹±ç  */
		$data = $row['COUNT(*)'];
	}
	/* ç»“æŸæŸ¥è¯¢é‡Šæ”¾å†…å­˜ */
	mysqli_free_result($result);
}

/*ä¼ å€¼*/
echo json_encode($data);
/* å…³é—­è¿žæŽ¥ */
mysqli_close($link);
=======
include('DBUtil.php');
$q = $_GET ['tno'];
$sql="SELECT COUNT(*) FROM teacherinfo WHERE tno='$q'";
	if ($result = mysqli_query ( $link, $sql )) {
		/* ½«½á¹û´æÔÚMy_arrayÖÐ */
		$My_array = array ();
		/* ·µ»Ø²éÑ¯µÄ½á¹û */
		while ( $row = mysqli_fetch_assoc ( $result ) ) {
			/* ·ÀÖ¹ÖÐÎÄÂÒÂë */
			$data = $row ['COUNT(*)'];
		}
		/* ½áÊø²éÑ¯ÊÍ·ÅÄÚ´æ */
		mysqli_free_result ( $result );
	}

/*´«Öµ*/
   echo json_encode ( $data );
/* ¹Ø±ÕÁ¬½Ó */
mysqli_close ( $link );
>>>>>>> branch 'alway_beach' of https://github.com/zly19980908/testpro.git
?>
