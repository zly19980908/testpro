<?php
include ('DBUtil.php');
$part_title = $_GET['part_title'];
$cNo = $_GET['cNo'];
$sql = "SELECT sourceOrgin,sourceDesc,downloadDate FROM sourceinfo WHERE sourceName='$part_title' AND cNo='$cNo'";
$json = "";
$data = array ();
class PartInfo {
	public $partName;
	public $partDesc;
	public $uploadDate;
}
if ($result = mysqli_query($conn, $sql)) {
	while ($row = mysqli_fetch_row($result)) {
		$partInfo = new PartInfo();
		$partInfo->partName = $row[0];
		$partInfo->partDesc = $row[1];
		$partInfo->uploadDate = $row[2];
		$data[] = $partInfo;
	}
	mysqli_free_result($result);
	$json = json_encode($data);
	echo $json;
} else {
	echo "查询错误";
}
/* 关闭连接 */
mysqli_close($conn);
?>
