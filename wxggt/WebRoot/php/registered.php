<?php
include('DBUtil.php');
$q = $_GET ['tno'];
$sql="SELECT COUNT(*) FROM teacherinfo WHERE tno='$q'";
	if ($result = mysqli_query ( $link, $sql )) {
		/* 将结果存在My_array中 */
		$My_array = array ();
		/* 返回查询的结果 */
		while ( $row = mysqli_fetch_assoc ( $result ) ) {
			/* 防止中文乱码 */
			$data = $row ['COUNT(*)'];
		}
		/* 结束查询释放内存 */
		mysqli_free_result ( $result );
	}

/*传值*/
   echo json_encode ( $data );
/* 关闭连接 */
mysqli_close ( $link );
?>
