<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to FunWeb</title>
<link rel="stylesheet" type="text/css" 
href="/resources/css/main.css" />
<%-- jsp주석문형태, jsp주석문은 웹브라우저 소스보기에서
안보인다. 외부 스타일(css)을 불러오는 방법. --%>
<script type="text/javascript" 
src="/resources/js/jquery.js"></script>
<%-- javascript(자바스크립트) 외부포함파일 불러오는
형식. type속성은 생략가능.  jQuery라이브러리를 읽어옴.--%>
<script src="/resources/js/s3Slider.js"></script>
<%-- jQuery 동적인 슬라이드 효과를 주는 외부파일을
불러옴. --%>
<script>
$(document).ready(function() { //$는 jQuery란 뜻이고,
//$대신 jQuery를 코딩해도 된다.	
   $('#s3slider').s3Slider({ 
	   //#아이디선택자 로 접근한다.
      timeOut: 4000 
   });
 });
</script>
</head>
<body>
 <div id="wrap">
  <header><%--header는 html5에 추가된 태그로 머릿상단영
  영역을 지정할 때 사용한다. --%>
  <div id="login">
   <a href="#">login</a> | <a href="member_join">Join</a>
  </div>
  <div class="clear"></div>
  <%--회사로고--%>
  <div id="logo">
  <a href="main">
   <img src="/resources/images/logo.gif" 
   width="265" height="62"
   alt="Fun Web" />   
  </a>
  </div>
  <nav><%--nav는 메뉴구성할 때 사용하는 html5에서 추가된
  태그명 --%>
   <ul>
    <li><a href="main">HOME</a></li>
    <li><a href="#">COMPANY</a></li>
    <li><a href="#">SOLUTION</a></li>
    <li><a href="bbs_write">CUSTOMER CENTER</a></li>
    <li><a href="#">CONTACT US</a></li>
   </ul>
  </nav>
  </header>
  
  <div class="clear"></div>
  
  <%--메인이미지 --%>
  <div id="main_img">
   <%--<img src="./images/main_img.jpg" width="971"
   height="282" />--%>
    <!--  s3Slider -->
            <div id="s3slider">
                    <ul id="s3sliderContent">
                       <li class="s3sliderImage">
                             <img src="/resources/images/main_img.jpg" width="971" height="282">
                           <span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam semper erat est. <br>
                                 Aliquam metus elit, blandit eu luctus vitae, dictum sit amet mauris. Integer ut facilisis eros. <br>
                                 Donec consectetur, velit id aliquam sagittis,</span>
                       </li>
                       <li class="s3sliderImage">
                           <img src="/resources/images/main_img1.jpg" width="971" height="282">
                                 <span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam semper erat est. <br>
                                 Aliquam metus elit, blandit eu luctus vitae, dictum sit amet mauris. Integer ut facilisis eros. <br>
                                 Donec consectetur, velit id aliquam sagittis,</span>
                       </li>
                       <li class="s3sliderImage">
                           <img src="/resources/images/main_img2.jpg" width="971" height="282">
                                  <span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam semper erat est. <br>
                                 Aliquam metus elit, blandit eu luctus vitae, dictum sit amet mauris. Integer ut facilisis eros. <br>
                                 Donec consectetur, velit id aliquam sagittis,</span>
                       </li>                       
                       <div class="clear s3sliderImage"></div>
                    </ul>
             </div> 
     <!--  s3Slider -->  
  </div>
  
  <%--본문영역--%>
  <article id="front"><%--article은 본문영역을 지정할때 사용하는
  html5에서 추가된 태그 --%>
    <div id="solution">
      <div id="hosting">
       <h3>Web Hosting Solution</h3>
       <p>Lorem ..Ut velest</p>
       <p>Lorem ..Ut velest</p>
       <p>Lorem ..Ut velest</p>
       <p>Lorem ..Ut velest</p>
      </div>
      <div id="security">
       <h3>Web Security Solution</h3>
       <p>Lorem ...Ut velest</p>
       <p>Lorem ..Ut velest</p>
       <p>Lorem ..Ut velest</p>
       <p>Lorem ..Ut velest</p>
      </div>
      <div id="payment">
       <h3>Web payment Solution</h3>
       <p>Lorem ..Ut velest</p>
       <p>Lorem ..Ut velest</p>
       <p>Lorem ..Ut velest</p>
       <p>Lorem ..Ut velest</p>
      </div>
    </div>
    
    <div class="clear"></div>
    
    <div id="sec_news">
      <h3><span class="orange">Security</span> News</h3>
      <dl><%--dl은 정의목록태그 --%>
       <dt><%--dt는 제목 --%>
        <a href="#">Vivamus id ligula...</a></dt>
        <dd><%-- dd는 내용 --%>
         <a href="#">Proin quis ante...</a></dd>        
        <dt><a href="#">Vivamus id ligula...</a></dt>
        <dd><a href="#">Proin quis ante ...</a></dd>
      </dl>
    </div>
    
    <div id="news_notice">
     <h3 class="brown">News &amp; Notice</h3><%-- &amp;특수문자기호는
     &로 화면에 표시 --%>
     <table>
      <tr>
       <td class="context">Vivamus ...</td>
       <td><a href="#">2017.10.16</a></td>
      </tr>
      <tr>
       <td class="context">Vivamus ...</td>
       <td>2017.10.16</td>
      </tr>
      <tr>
       <td class="context">Vivamus ...</td>
       <td>2017.10.16</td>
      </tr>
      <tr>
       <td class="context">Vivamus ...</td>
       <td>2017.10.16</td>
      </tr>
      <tr>
       <td class="context">Vivamus ...</td>
       <td>2017.10.16</td>
      </tr>
     </table>
    </div>    
  </article>
  
  <div class="clear"></div>
  
  <%--하단영역 --%>
  <footer><%--footer태그는 하단영역을 지정할때 사용하는
  html5에서 추가된 태그 --%>
   <hr/>
   <div id="copy">
    All contents Copyright 2017 FunWeb Inc. all rights
    reserved<br/>
    Contact mail : funweb@funwebbiz.com Tel: +82 64 123
    4315 Fax +82 64 123 4321    
   </div>
   <div id="social">
    <img src="/resources/images/facebook.gif" width="33"
    height="33" alt="Facebook" /> 
    <img src="/resources/images/twitter.gif" width="33"
    height="34" alt="Twitter" /> 
   </div>  
  </footer>
 </div>
</body>
</html>



















