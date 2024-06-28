<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="include/header.jsp"%>

<script type="text/javascript">
	
	var cnt =1;
	function addFile(){
		//alert("파일 추가 버튼 클릭!")
		$(".fileDiv").append("<input type='file' name='file"+cnt+"' id='exampleInputFile'>");
		cnt++;
	}
</script>


<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">form.jsp(파일업로드)</h3>
	</div>


	<form role="form" action="/upload" method="post" enctype="multipart/form-data">
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">아이디</label> 
					<input type="text" name="userid" class="form-control" 
					id="exampleInputEmail1" placeholder="아이디를 입력하세요">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">이름</label> 
					<input type="text" name="username" class="form-control"
					id="exampleInputPassword1" placeholder="이름을 입력하여라">
			</div>
			<div class="form-group fileDiv">
				<label for="exampleInputFile">File input</label> 
				<input type="button" value="파일 추가" onclick="addFile();">
				
				<!-- <input type="file" name="file" id="exampleInputFile"> -->
			</div>
		</div>

		<div class="box-footer">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>
</div>


<%@ include file="include/footer.jsp"%>