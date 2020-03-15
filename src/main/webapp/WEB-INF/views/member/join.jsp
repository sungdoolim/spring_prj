<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../include/header.jsp" %>

<%--서브메인 이미지--%>
<div id="sub_img_member"></div>

<%--서브메뉴--%>
<div id="sub_menu">
 <ul>
  <li><a href="join.jsp">Join us</a></li>
  <li><a href="#">Privacy policy</a></li> 
 </ul>
</div>

<%--본문내용 --%>
<div id="wel_cont">
  <h1>Join Us</h1>
  <form id="join">
   <fieldset><legend>Basic Info</legend>
   <%-- fieldset은 입력박스를 하나의 그룹으로 묶어준다.
   legend는 필드셋 제목을 정의하는 부분이다. --%>
   <label>User ID</label>
   <input type="text" class="id" />
   <input type="button" value="idcheck" class="dup" />
   <br/>
   <label>Password</label>
   <input type="password" class="pass" /><br/>
   <label>Retype Password</label>
   <input type="password" class="pass" /><br/>
   <label>Name</label>
   <input type="text" class="nick" /><br/>
   <label>E-Mail</label>
   <input type="email" class="email" /><br/>
   <label>Retype E-Mail</label>
   <input type="email" class="email" /><br/>  
  </fieldset>
   
   <fieldset>
    <legend>Optional</legend>
    <label>Address</label>
    <input type="text" class="address" /><br/>
    <label>Phone Number</label>
    <input type="tel" class="phone" /><br/>
    <label>Mobile Phone Number</label>
    <input type="tel" class="mobile" /><br/>
   </fieldset>
   
   <div class="clear"></div>
   <div id="buttons">
    <input type="button" value="Submit" class="submit" />
    <input type="button" value="Cancel" class="cancel" />
   </div>
  </form>
</div>

<jsp:include page="../include/footer.jsp" />
















