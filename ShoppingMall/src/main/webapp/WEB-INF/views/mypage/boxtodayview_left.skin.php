<?php
$tv_idx = get_session("ss_tv_idx");

$tv_div['top'] = 0;
$tv_div['img_width'] = 70;
$tv_div['img_height'] = 70;
$tv_div['img_length'] = 3; // 한번에 보여줄 이미지 수

// add_stylesheet('css 구문', 출력순서); 숫자가 작을 수록 먼저 출력됨
add_stylesheet('<link rel="stylesheet" href="'.G5_SHOP_SKIN_URL.'/style.css">', 0);
?>

<!-- 오늘 본 상품 시작 { -->
<aside id="stv2">
    <div id="stv2_list">
    <!-- 장바구니, 관심상품, 구매하기 -->
<div style="position:absolute;/*margin:0 0 25px;*/margin:0 0 0px;position:relative;/*top:45px;left:-375px;*/">
  <div class="hexagon2">
    <a href="<?php echo G5_SHOP_URL; ?>/cart.php"><span class="intext-text1"><img src="<?php echo G5_SHOP_URL; ?>/img/l_1.png"
	             style="opacity:0.5" onmouseover="this.style.opacity='0.9'" onmouseout="this.style.opacity='0.5'" alt="장바구니"></span>
    <span class="intext-text1-korean">장바구니</span></a>
  </div>

      <div class="hexagon2-line">&nbsp;</div>
  <div class="hexagon2">
    <a href="<?php echo G5_SHOP_URL; ?>/wishlist.php"><span class="intext-text2"><img src="<?php echo G5_SHOP_URL; ?>/img/l_2.png"
	             style="opacity:0.5" onmouseover="this.style.opacity='0.9'" onmouseout="this.style.opacity='0.5'" alt="위시리스트"></span>
    <span class="intext-text2-korean">관심상품</span></a>
	</a>
  </div>

      <div class="hexagon2-line2">&nbsp;</div>
  <div class="hexagon2">
    <a href="<?php echo G5_SHOP_URL; ?>/orderinquiry.php"><span class="intext-text3"><img src="<?php echo G5_SHOP_URL; ?>/img/l_3.png"
	             style="opacity:0.5" onmouseover="this.style.opacity='0.9'" onmouseout="this.style.opacity='0.5'" alt="주문/배송조회"></span>
    <span class="intext-text3-korean">주문/배송</span></a>
	</a>
  </div>
</div>
<!-- 장바구니, 관심상품, 구매하기 -->
    </div>
</aside>
<!-- } 오늘 본 상품 끝 -->


<style>
/* 오늘 본 상품(왼쪽) */
#stv2 {z-index:1001;
       position:relative;
       float:left;
	   width:100px;
       position: fixed; /*최상단으로 나오게 - 스크롤에 따라 위아래로 이동*/
	   margin:20px 0 0; 
       }
#stv2_list {position:absolute;left: -95px;/*오늘본 상품 왼쪽으로 빼기*/
            width:88px;
			border:0px solid #aaa;/*background:#fff*/
			}
#stv2_list h2 {margin:0px auto;
               padding:7px 0 5px;
               background:#05A8E8;
               border-bottom:0px /*solid*/dotted #aaa;
               width:100%;
               font-weight:bold;
               font-size:12px;
               font-family:Malgun Gothic;
               color:#fff;
               text-align:center;
               letter-spacing:-0.1em
			   }
			   
/* 육각도형 */
.hexagon2 {
  position: relative;
  width: 74px; 
  height: 43.30px;
  background-color: #ffffff;
  margin: 21.65px 0;
  border-left: solid 1px #bbb;
  border-right: solid 1px #bbb;
  float:left;
}

.hexagon2:before,
.hexagon2:after {
  content: "";
  position: absolute;
  z-index: 1;
  width: 53.03px;
  height: 53.03px;
  -webkit-transform: scaleY(0.5774) rotate(-45deg);
  -ms-transform: scaleY(0.5774) rotate(-45deg);
  transform: scaleY(0.5774) rotate(-45deg);
  background-color: inherit;
  left: 10px;
}

.hexagon2:before {
  top: -26.5165px;
    border-top: solid 1px #bbb;
    border-right: solid 1px #bbb;
}

.hexagon2:after {
  bottom: -26.5165px;
    border-bottom: solid 1px #bbb;
    border-left: solid 1px #bbb;
}

/* 육각형 연결라인 */
.hexagon2-line {
    float: left;
    width: 10px;
    height: 0px;
    background: #888;
    margin-top: 60px; margin-bottom: 30px;
}

/* 육각형 연결라인 */
.hexagon2-line2 {
    float: left;
    width: 10px;
    height: 0px;
    background: #888;
    margin-top: 60px; margin-bottom: 30px;
}

/* 텍스트 - text1 */
.intext-text1 {
    float: left;
	position:absolute;
    z-index: 11;
    margin-top: -3px;
    margin-left: 26px;
    font-size: 22px;
    color:#696969;
}
.intext-text1:hover {color:#FF6173;}

/* 텍스트 - text1 */
.intext-text1-korean {
    float: left;
	position:absolute;
    z-index: 11;
    margin-top: 25px;
    margin-left: 13px;
    font-size:12px;
    font-family: Malgun Gothic,'맑은 고딕',dotum, 돋움, sans-serif;
    font-weight:bold;
    color:#666;
}
.intext-text1-korean:hover {color:#FF6173;}

/* 텍스트 - text2 */
.intext-text2 {
    float: left;
	position:absolute;
    z-index: 11;
    margin-top: -4px;
    margin-left: 27px;
    font-size: 22px;
    color:#696969;
}
.intext-text2:hover {color:#FF6173;}

/* 텍스트 - text2 */
.intext-text2-korean {
    float: left;
	position:absolute;
    z-index: 11;
    margin-top: 24px;
    margin-left: 13px;
    font-size:12px;
    font-family: Malgun Gothic,'맑은 고딕',dotum, 돋움, sans-serif;
    font-weight:bold;
    color:#666;
}
.intext-text2-korean:hover {color:#FF6173;}

/* 텍스트 - text3 */
.intext-text3 {
    float: left;
	position:absolute;
    z-index: 11;
    margin-top: -4px;
    margin-left: 27px;
    font-size: 22px;
    color:#696969;
}
.intext-text3:hover {color:#FF6173;}

/* 텍스트 - 관심상품 */
.intext-text3-korean {
    float: left;
	position:absolute;
    z-index: 11;
    margin-top: 25px;
    margin-left: 11px;
    font-size:12px;
    font-family: Malgun Gothic,'맑은 고딕',dotum, 돋움, sans-serif;
    font-weight:bold;
    color:#666;
}
.intext-text3-korean:hover {color: #FF6173;}

.hexagon2:hover {
  position: relative;
  width: 74px; 
  height: 43.30px;
  background-color: #fff;
  margin: 21.65px 0;
    border-left: solid 1px #bbb; 
    border-right: solid 1px #bbb;
    float:left;
}
</style>