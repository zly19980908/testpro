<?php
include ('DBUtil.php');
$sql = "SELECT mNo,mName FROM majorinfo";
$json = "";
$data = array ();
class MajorInfo {
	public $mNo;
	public $mName;
}
if ($result = mysqli_query($conn, $sql)) {
	/* 返回查询的结果 */
	while ($row = mysqli_fetch_assoc($result)) {
		$majorInfo = new MajorInfo();
		$majorInfo->mNo = $row["mNo"];
		$majorInfo->mName = $row["mName"];
		$data[] = $majorInfo;
	}
	/* 结束查询释放内存 */
	mysqli_free_result($result);
	/*传值*/
	$json = json_encode($data); //把数据转换为JSON数据.
	echo $json;
} else {
	echo "查询失败";
}
/* 关闭连接 */
mysqli_close($conn);
?>
