<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<Html>
<head>
  <title>여행기록사이트</title>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="../css/style.css">
  <!--JQuery-->
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <!--Font Awesome-->
  <script src="https://kit.fontawesome.com/6c7d966087.js" crossorigin="anonymous"></script>
  <!--Slick Slide-->
  <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
  <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
  <!--GoogleFont-->
<link href="https://fonts.googleapis.com/css2?family=Sriracha&display=swap" rel="stylesheet">

</head>
<body>

  <!--Page Wrapper -->
  <div class="wrapper">
    <header>
      <nav class="navbar">
        <div class="menu-icon">
          <i class="fa fa-bars fa-2x"></i>
        </div>
        <div class="logo">
          <a href="../main/main.jsp">TRAVLE</a>
        </div>
        <div class="menu">
          <ul>
            <li><a class="menuA" href="#">Home</a></li>
            <li><a class="menuA" href="#">About</a></li>
            <li><a class="menuA" href="#" onclick="moveContent()">Blog</a></li>
            <li><a class="menuA" href="#" onclick="moveInfo()">Contact</a></li>
          </ul>
        </div>
        <div class="user">
          <img class="userImg" src="../img/user.png" class="userImg" style="width:30px; " onclick="location.href='../member/loginForm.do'">
        </div>
      </nav>
     <!--  <div class="userManegement">
      	<ul>
      	<li>로그인</li>
      	<li>회원가입</li>
      	</ul>
      </div> -->
    </header>

</div>
<!--Page Wrapper -->
    <div class="page-wrapper" style="position:relative;">
      <!--page slider -->
      <div class="post-slider">
        <h1 class="silder-title">Trending Posts</h1>
        <i class="fas fa-chevron-left prev"></i>
        <i class="fas fa-chevron-right next"></i>
        <div class="post-wrapper">
          <div class="post">
            <img src="../img/paris.jpg" class="slider-image">
            <div class="post-info">
              <h4><a href="#" class="post-subject">Lorem ipsu eiusmod tempor incididunt ut </a></h4>
              <i class="far fa-user" style="height:10%;">Awa Melvine</i>
            </div>
          </div>
          <div class="post">
            <img src="../img/architecture.jpg" class="slider-image">
            <div class="post-info">
              <h4><a href="#"> Commodo odio aenean sed  </a></h4>
              <i class="far fa-user" style="height:10%;">Awa Melvine</i>
            </div>
          </div>
          <div class="post">
            <img src="../img/paris.jpg" class="slider-image">
            <div class="post-info">
              <h4><a href="#">Quis hendrerit dolor magna eget est lorem ipsum dolor sit. </a></h4>
              <i class="far fa-user" style="height:10%;">Awa Melvine</i>
            </div>
          </div>
          <div class="post">
            <img src="../img/gyungju.jpg" class="slider-image">
            <div class="post-info">
              <h4><a href="#">Elit at imperdiet dui accumsan sit.</a></h4>
              <i class="far fa-user" style="height:10%;">Awa Melvine</i>
            </div>
          </div>
        </div>
      </div>
      <!--post slider-->
    </div>


    <!--content -->
    <div class="content">
      <p>
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa. Commodo odio aenean sed adipiscing diam donec adipiscing tristique. Mi eget mauris pharetra et. Non tellus orci ac auctor augue. Elit at imperdiet dui accumsan sit. Ornare arcu dui vivamus arcu felis. Egestas integer eget aliquet nibh praesent. In hac habitasse platea dictumst quisque sagittis purus. Pulvinar elementum integer enim neque volutpat ac.
      </p>
      <p>
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa. Commodo odio aenean sed adipiscing diam donec adipiscing tristique. Mi eget mauris pharetra et. Non tellus orci ac auctor augue. Elit at imperdiet dui accumsan sit. Ornare arcu dui vivamus arcu felis. Egestas integer eget aliquet nibh praesent. In hac habitasse platea dictumst quisque sagittis purus. Pulvinar elementum integer enim neque volutpat ac.
      </p>
      <p>
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa. Commodo odio aenean sed adipiscing diam donec adipiscing tristique. Mi eget mauris pharetra et. Non tellus orci ac auctor augue. Elit at imperdiet dui accumsan sit. Ornare arcu dui vivamus arcu felis. Egestas integer eget aliquet nibh praesent. In hac habitasse platea dictumst quisque sagittis purus. Pulvinar elementum integer enim neque volutpat ac.
      </p>
      <p>
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa. Commodo odio aenean sed adipiscing diam donec adipiscing tristique. Mi eget mauris pharetra et. Non tellus orci ac auctor augue. Elit at imperdiet dui accumsan sit. Ornare arcu dui vivamus arcu felis. Egestas integer eget aliquet nibh praesent. In hac habitasse platea dictumst quisque sagittis purus. Pulvinar elementum integer enim neque volutpat ac.
      </p>
      <p>
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa. Commodo odio aenean sed adipiscing diam donec adipiscing tristique. Mi eget mauris pharetra et. Non tellus orci ac auctor augue. Elit at imperdiet dui accumsan sit. Ornare arcu dui vivamus arcu felis. Egestas integer eget aliquet nibh praesent. In hac habitasse platea dictumst quisque sagittis purus. Pulvinar elementum integer enim neque volutpat ac.
      </p>
    </div>

    <!--footer-->
    <div class="footer">
      <div class="logoFooter">
        <p style="font-size:20px; color:white;">TRAVLE</p>
        <p style="font-size:10px;">        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa. Commodo odio aenean sed adipiscing diam donec adipiscing tristique. Mi eget mauris pharetra et. Non tellus orci ac auctor augue. Elit at imperdiet dui accumsan sit. Ornare arcu dui vivamus arcu felis. Egestas integer eget aliquet nibh praesent. In hac habitasse platea dictumst quisque sagittis purus. Pulvinar elementum integer enim neque volutpat ac.</P>
      </div>
      <div class="follow">
        <p>FOLLOW US</p>
        <p style="font-size:10px;">Quis hendrerit dolor magna eget est lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa. Commodo odio aenean sed adipiscing diam donec adipiscing tristique. Mi eget mauris pharetra et. Non tellus orci ac auctor augue. Elit at imperdiet dui accumsan sit. Ornare arcu dui vivamus arcu felis. Egestas integer eget</p>
        <div style="display:flex; justify-content:center;"><img id="follow" src="../img/facebook.png">
        <img id="follow" src="../img/twitter.png">
        <img id="follow" src="../img/instargram.png">
        <img id="follow" src="../img/youtube.png">
      </div>
      </div>
      <div class="contact">
        <p>contact</p>
        <p style="font-size:10px;">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa. Commodo odio aenean sed adipiscing diam donec adipiscing tristique. Mi eget mauris pharetra et. Non tellus orci ac auctor augue. Elit at imperdiet dui accumsan sit. Ornare arcu dui vivamus arcu felis. Egestas integer eget aliquet nibh praesent. In hac habitasse platea dictumst quisque sagittis purus. Pulvinar elementum integer enim neque volutpat ac.</P>

      </div>
    </div>
    <div class="copyright">
      COPYRIGHT ⓒ JIENEM. All RIGHTS RESERVED.
    </div>
</body>
<script type="text/javascript">
$(document).ready(function(){
$(".menu-icon").on("click",function(){
  $("nav ul").toggleClass("showing");
  $(".userImg").toggleClass("showing");
  $(".user").addClass(function(){
    return userShow;
  });
});

});
$(window).on("scroll",function(){
  if($(window).scrollTop()){
    $('nav').addClass('black');
  } else {
    $('nav').removeClass('black');
  }
});

$('.post-wrapper').slick({
  slidesToShow: 3,
  slidesToScroll: 1,
  autoplay: true,
  autoplaySpeed: 2000,
  nextArrow:$('.next'),
  prevArrow:$('.prev'),
});
function moveContent(){
  var offset=$(".content").offset();
  $('html,body').animate({scrollTop:offset.top},500);
}
function moveInfo(){
  var offset=$(".footer").offset();
  $('html, body').animate({scrollTop:offset.top},500);
}


</script>


</html>
