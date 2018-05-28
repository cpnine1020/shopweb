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
			<div class="pagenav">
				<a href="http://www.xiangxiaole.com">首页</a> &gt; 旅游攻略 &gt; 日本旅游攻略
			</div>
			<script type="text/javascript">
				
			</script>
			<div class="leftmenu">
				<h1>旅游攻略</h1>
				<ul>
					<li><a href="http://www.xiangxiaole.com/travel-strategy"
						class="curr">日本旅游攻略</a></li>
				</ul>
			</div>
			<div class="right_m">
				<div class="right_m_banner">
					<img src="<c:url value='/pic/banner-travel.jpg' />">
				</div>
				<div class="right_m_n">
					<h1>日本旅游攻略</h1>
					<div class="rightdiv">
			        <div class="pblist">
			          <ul>
			          <c:forEach var="news" items="${newsList}">
						 	<li>
						 		<span>${news.type2}</span>
						 		<a target="_blank" href="http://www.xiangxiaole.com/news-newscontent?id=${news.id}">${news.title}</a>
						 	</li>
					  </c:forEach>
			          </ul>
			        </div>
			      </div>
			      <br>
					<%-- <hr>
					<p style="text-align:right;font-size:0.8em">更新时间：${newsList[0].updateTime}&#12288;数据来源：<a target="_blank" href="http://bbs.tianya.cn">天涯论坛</a></p> --%>
				</div>
				<div class="right_m_bottom"></div>
			</div>
		</div>
	</div>
	<jsp:include page="fragments/footer.jsp" />
</body>
</html>