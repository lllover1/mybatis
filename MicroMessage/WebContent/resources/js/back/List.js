/**
 * 提交批量删除数据
 */
function deleteMany(basePath) {
	$("#mainForm").attr("action",basePath+"DeleteMany.action");
	$("#mainForm").submit();
	}

function changePage(currentPage) {
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();
}
function jumpPage() {
	$("#currentPage").val($("#jump").val());
	$("#mainForm").submit();
}

function deleteOne(basePath,deleteId) {
	$("#mainForm").attr("action",basePath+"DeleteOne.action");
	$("#deleteId").val(deleteId);
	$("#mainForm").submit();
	}