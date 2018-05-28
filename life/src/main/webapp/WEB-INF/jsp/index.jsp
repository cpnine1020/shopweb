<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-CN">
<jsp:include page="fragments/headTag.jsp" />
<body>
	<jsp:include page="fragments/header.jsp">
		<jsp:param name="active" value="news" />
	</jsp:include>
	<div class="main">
		<div class="main_n">
			<div class="main_left">
        		<div class="index_publish">
          			<h1>网站公告</h1>
          			<br>
      				<p>网站公告正文</p>
      				<br>
         		</div>
         		<br>
         		<div class="index_publish">
          			<h1>北京存量房签约和核验统计</h1>
          			<br>
      				<p>网站公告正文</p>
      				<br>
         		</div>
        		<div class="index_ad">
          			<a href="#"><img src="pic/index/left_ad1.jpg" /></a>
         			<a href="#"><img src="pic/index/left_ad2.jpg" /></a>
         			<a href="#"><img src="pic/index/left_ad3.jpg" /></a>
          			<a href="#"><img src="pic/index/left_ad4.jpg" /></a>
        		</div>

      		</div>
      		<div class="main_right">
        	<!--焦点图广告-->
        		<div class="index_banner">
            		<IMG alt=""  src="pic/index/banner1.jpg"> 
       			</div>
        	<!--焦点图广告end-->
       		<div class="index_dt">
	          	<h1></h1>
			    <div class="index_dt_focus">
	            	<img src="pic/index/dt_pic.jpg" />
	             	<p class="ldContent" align="left">　　《公开募集证券投资基金运作管理办法》已经2014年3月10日中国证ddddddd管理委员会第29次主席办公会议审议通过，现予公布，自2014年8月8日起施行。</p>
					<p/>
					<p class="ldContent"></p>[ <a target="_blank" href="#">详情</a> ]
	             </div>
	             <ul>
	             	<li><span>2014-12-16</span><a href="#" target="_blank">公开募集证券投资基金运作管理办法</a></li>
			 		<li><span>2014-12-16</span><a href="#" target="_blank">非银行金融机构开展证券投资基金托管业务暂行规定</a></li>
			 	 </ul>
			  	<span style="margin-left:550px;"><a  target="_blank" href="#">更多>></a></span>
        	</div>
       		<div class="index_ser">
         	 <h1>我们的服务</h1>
          <div class="index_ser_nle">
            <ul>
              <li><a href="#">销售运营</a></li>
              <li><a href="#">登记注册</a></li>
              <li><a href="#">估值核算</a></li>
              <li><a href="#">数据服务</a></li>
              <li><a href="#">绩效分析</a></li>
              <li><a href="#">增值服务</a></li>
            </ul>
          </div>
          <div class="index_ser_nle index_ser_nri">
            <ul>
              <li><a href="#">资产保管</a></li>
              <li><a href="#">投资监督</a></li>
              <li><a href="#">资金结算</a></li>
              <li><a href="#">信息披露</a></li>
              <li><a href="#">绩效评估</a></li>
              <li><a href="#">信息服务</a></li>
            </ul>
          </div>

        </div>

        <div class="index_client">
          <h1>我们的客户</h1>
          <div id="paintDiv">
          <br>
          <p>客户信息</p>
           <br>
        </div>
      </div>
    </div>
  </div>
 

			
		</div>
	</div>
	<jsp:include page="fragments/footer.jsp" />
</body>
</html>