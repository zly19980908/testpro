<?php
include('DBUtil.php');
$q = $_GET ['tno'];
$sql="SELECT COUNT(*) FROM teacherinfo WHERE tno='$q'";
	if ($result = mysqli_query ( $link, $sql )) {
		/* ���������My_array�� */
		$My_array = array ();
		/* ���ز�ѯ�Ľ�� */
		while ( $row = mysqli_fetch_assoc ( $result ) ) {
			/* ��ֹ�������� */
			$data = $row ['COUNT(*)'];
		}
		/* ������ѯ�ͷ��ڴ� */
		mysqli_free_result ( $result );
	}

/*��ֵ*/
   echo json_encode ( $data );
/* �ر����� */
mysqli_close ( $link );
?>
