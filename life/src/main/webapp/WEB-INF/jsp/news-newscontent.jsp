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
				<a href="http://www.xiangxiaole.com">首页</a> &gt; 看帖读报 &gt; 文章内容
			</div>
			<div>
				<span style="float:left;padding-left:20px">上一篇：<a href="http://www.xiangxiaole.com/news-newscontent?id=${lastNews.id}">${lastNews.title}</a></span>
				<span style="float:right;padding-right:20px">下一篇：<a href="http://www.xiangxiaole.com/news-newscontent?id=${nextNews.id}">${nextNews.title}</a></span>
			</div>
			<div class="newsshowMain">
      			<h3>${news.title}</h3>
       			<div class="source">
       				
       				<span>来源：<strong>${news.sourceSite}</strong></span>
       				<span>日期：<strong>${news.publishTime}</strong></span>
       				<span>作者：<strong>${news.author}</strong></span>
       				<span>点击：<strong>${news.readNum}</strong></span>
       				<span>评论：<strong>${news.commentNum}</strong></span>
       				<span><a style="color:#a4a4a4" target="_blank" href="${news.url}">原文链接</a></span>
       			</div>
     	 		<ul>
        			<li class="text">${news.content}</li>
				</ul>
        		<a href="#" class="close" onclick="self.close();">关闭窗口</a>
      		</div>
		</div>
	</div>
	<jsp:include page="fragments/footer.jsp" />
</body>
</html>