<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
<h1>/board/regist.jsp</h1>
<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">/board/regist.jsp</h3>
	</div>


	<form role="form" method="post">
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">제목</label> 
				<input type="text" name="title" class="form-control" id="exampleInputEmail1" placeholder="제목을 입력하세요">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">작성자</label> 
				<input type="text" name="writer" class="form-control" id="exampleInputEmail1" placeholder="작성자를 입력하세요">
			</div>
			<div class="form-group">
				<label>내용</label>
				<textarea class="form-control" name="content" rows="3" placeholder="Enter ..."></textarea>
			</div>

		</div>

		<div class="box-footer">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>
</div>
<%@ include file="../include/footer.jsp"%>