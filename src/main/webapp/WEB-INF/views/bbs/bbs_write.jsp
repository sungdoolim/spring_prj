<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../include/header.jsp" %>

<%--서브메인 이미지--%>
<div id="sub_img_center"></div>

<%--서브메뉴--%>
<div id="sub_menu">
 <ul>
  <li><a href="bbs_write">Bbs</a></li>
  <li><a href="#">Public News</a></li>
  <li><a href="#">Driver Download</a></li>
  <li><a href="#">Service Policy</a></li>
 </ul>
</div>

<%--본문내용 --%>
<div id="wel_cont">
   <div id="bsW_wrap">
  <h2 class="bsW_title">자료실 글쓰기</h2>
  <form method="post" action="bbs_write_ok"
  onsubmit="return write_check();"
  enctype="multipart/form-data">
  <%-- 자료실 기능을 만들려면 첫번째,method=post만 가능하다.
  두번째 폼태그내에 enctype속성을 꼭 지정해야 한다. 파일첨부해서
  서버로 전송되는 첨부된 파일을 포함한 일반문자를 바이너리 모드
  (binary mode) 즉 이진파일이라 부른다. 그렇지 않은 일반게시판에
  서 서버로 전송되는 데이터를 ascii mode(아스키 모드) 파일
  이라 한다. --%>
  <table id="bsW_t">
   <tr>
    <th>이름</th>
    <td><input name="bbs_name" id="bbs_name" size="14" /></td>
   </tr>
   <tr>
    <th>제목</th>
    <td><input name="bbs_title" id="bbs_title" size="33" />
    </td>
   </tr>
   <tr>
    <th>비밀번호</th>
    <td><input type="password" name="bbs_pwd" id="bbs_pwd"
    size="14" /></td>   
   </tr>
   <tr>
    <th>글내용</th>
    <td><textarea name="bbs_cont" id="bbs_cont" rows="8"
    cols="34"></textarea></td>
   </tr>
   <tr>
    <th>파일첨부</th>
    <td><input type="file" name="bbs_file" /></td>
   </tr>
  </table>
  <div id="bsW_menu">
   <input type="submit" value="저장" />
   <input type="reset" value="취소" 
   onclick="$('#bbs_name').focus();" >
   <input type="button" value="목록" 
   onclick="location='bbs_list?page=${page}';" >
  </div>
  </form>
 </div>
</div>

<jsp:include page="../include/footer.jsp" />









