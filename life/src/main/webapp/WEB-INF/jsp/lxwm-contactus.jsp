<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-CN">
<jsp:include page="fragments/headTag.jsp" />
<body>
	<jsp:include page="fragments/header.jsp">
		<jsp:param name="active" value="lxwm" />
	</jsp:include>
	<div class="main">
		<div class="main_n">
			<div class="pagenav">
				<a href="http://www.xiangxiaole.com">首页</a> &gt; 联系我们 &gt; 联系方式
			</div>
			<script type="text/javascript">
				
			</script>
			<div class="leftmenu">
				<h1>联系我们</h1>
				<ul>
					<li><a href="http://www.xiangxiaole.com/contactus"
						class="curr">联系方式</a></li>
				</ul>
			</div>
			<div class="right_m">
				<div class="right_m_banner">
					<img src="<c:url value='/pic/banner-contactus.jpg' />">
				</div>
				<div class="right_m_n">
					<h1>联系方式</h1>
         			<p><img src="<c:url value='/pic/mail.jpg' />" />&nbsp;&nbsp;xiangxiaole_site@foxmail.com</p>
				</div>
				<div class="right_m_bottom"></div>
			</div>
		</div>
	</div>
	<jsp:include page="fragments/footer.jsp" />
</body>
</html>