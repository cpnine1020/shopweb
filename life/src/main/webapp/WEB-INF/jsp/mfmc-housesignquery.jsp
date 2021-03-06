<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-CN">
<jsp:include page="fragments/headTag.jsp" />
<body>
	<jsp:include page="fragments/header.jsp">
		<jsp:param name="active" value="mfmc" />
	</jsp:include>
	<div class="main">
		<div class="main_n">
			<div class="pagenav">
				<a href="http://www.xiangxiaole.com">首页</a> &gt; 买房买车 &gt; 北京存量房签约统计
			</div>
			<script type="text/javascript">
				
			</script>
			<div class="leftmenu">
				<h1>买房买车</h1>
				<ul>
					<li><a href="http://www.xiangxiaole.com/mfmc-housesignquery"
						class="curr">北京存量房签约统计</a></li>
					<li><a href="#">北京小汽车摇号查询</a></li>
				</ul>
			</div>
			<div class="right_m">
				<div class="right_m_banner">
					<img src="<c:url value='/pic/banner-mcmf.jpg' />">
				</div>
				<div class="right_m_n">
					<h1>北京存量房网上签约统计（每日更新，历史数据）</h1>
					<table class="tjInfo01" style="width:100%">
						<thead>
							<tr>
								<th>日期</th>
								<th>网上签约<br>套数</th>
								<th>网上签约<br>面积(m<sup>2</sup>)</th>
								<th style="color:red">住宅签约<br>套数</th>
								<th>住宅签约<br>面积(m<sup>2</sup>)</th>
								<th>核验房源<br>套数</th>
								<th>核验房源<br>面积(m<sup>2</sup>)</th>
								<th style="color:red">核验住宅<br>套数</th>
								<th>核验住宅<br>面积(m<sup>2</sup>)</th>	
							</tr>
						</thead>
						<tbody>
						<c:forEach var="houseSign" items="${houseSignList}" begin="0" end="7">  
  							<tr>
								<td>${houseSign.signDate}</td>
								<td>${houseSign.webSignNum}</td>
								<td>${houseSign.webSignSize}</td>
								<td style="color:red">${houseSign.houseSignNum}</td>
								<td>${houseSign.houseSignSize}</td>
								<td>${houseSign.webCheckNum}</td>
								<td>${houseSign.webCheckSize}</td>
								<td style="color:red">${houseSign.houseCheckNum}</td>
								<td>${houseSign.houseCheckSize}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					<p style="text-align:right;font-size:0.8em">更新时间：${houseSignList[0].updateTime}&#12288;数据来源：<a target="_blank" href="http://www.bjjs.gov.cn">北京市住建委网站</a></p>
					<hr/>
					<script>
						var categories = [];
						var houseSignNum= [];
						var houseCheckNum = [];
					</script>
					<c:forEach var="houseSign" items="${houseSignList}">  
  					<script>
  						categories.push("${houseSign.signDate}");
  						houseSignNum.push(parseInt("${houseSign.houseSignNum}"));
  						houseCheckNum.push(parseInt("${houseSign.houseCheckNum}"));
  					</script>
					</c:forEach>
					<div id="container" style="min-width:100%;height:400px"></div>
				</div>
				
				<div class="right_m_bottom"></div>
			</div>
		</div>
	</div>
	<jsp:include page="fragments/footer.jsp" />
<script>
$(function () {
	categories.reverse();//数组反转
	houseSignNum.reverse();
	houseCheckNum.reverse();
    $('#container').highcharts({
    	credits:{
    	    text:'www.xiangxiaole.com',
    	    href:'http://www.xiangxiaole.com'
    	},
        title: {
            text: '住宅签约和核验走势图',
            x: -20 //center
        },
        /* subtitle: {
            text: 'Source: WorldClimate.com',
            x: -20
        }, */
        xAxis: {
            categories: categories
        },
        yAxis: {
            title: {
                text: '套数'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '套'
        },
        legend: {
            layout: 'horizontal',
            align: 'center',
            borderWidth: 0
        },
        series: [{
            name: '住宅签约',
            data:houseSignNum
        }, {
            name: '住宅核验',
            data: houseCheckNum
        }]
    });
});
</script>
</body>
</html>