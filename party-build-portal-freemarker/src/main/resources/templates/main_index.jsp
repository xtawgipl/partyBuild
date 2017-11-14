<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>党建+大数据</title>
		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
        <link href="${basePath}static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <script src="${basePath}static/jQuery/jquery.min.js"></script>
        <script src="${basePath}static/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(function() {
				var height=document.documentElement.clientHeight;
				document.getElementById('iframe-page-content').style.height=height+'px';
			});
			
			var menuClick = function(menuUrl) {
				$("#iframe-page-content").attr('src',menuUrl);
			};
		</script>
	</head>

<body>
	<div style="width: 100%; height: 100%;">
		<!-- 左侧菜单栏 -->
		<div id="main-container">
			<div id="sidebar" class="col-md-2 column">				
				<!-- 创建菜单树 -->
				<div class="col-md-12">
                <ul id="main-nav" class="nav nav-tabs nav-stacked" style="">
                    <li>
                        <a href="#systemSetting" class="nav-header collapsed"  style="font-size: 20px;" data-toggle="collapse">
                            <i class="glyphicon glyphicon-cog"></i>数据管理
                               <span class="pull-right glyphicon glyphicon-chevron-down"></span>
                        </a>
                        <ul id="systemSetting" class="nav nav-list collapse secondmenu" style="height: 0px; padding-left: 20px;">
                            <li><a href="#" onclick="menuClick('${basePath}toViewInfo/1')"><i class="glyphicon glyphicon-user"></i>党员先锋指数</a></li>
                            <li><a href="#" onclick="menuClick('${basePath}partyCulture/manager/partyCultureView')"><i class="glyphicon glyphicon-th-list"></i>党组织生活情况</a></li>
                            <li><a href="#" onclick="menuClick('${basePath}partyFee/manager/partyFeeListView')"><i class="glyphicon glyphicon-th-list"></i>党费缴纳情况</a></li>
                            <li><a href="#" onclick="menuClick('${basePath}dailyLearning/manager/dailyLearningListView')"><i class="glyphicon glyphicon-th-list"></i>日常学习</a></li>
                            <li><a href="#" onclick="menuClick('${basePath}specialLearning/manager/specialLearningListView')"><i class="glyphicon glyphicon-th-list"></i>专项学习</a></li>
                            <li><a href="#" onclick="menuClick('${basePath}new/manager/newListView')"><i class="glyphicon glyphicon-th-list"></i>时政要闻</a></li>
                            <li><a href="#" onclick="menuClick('${basePath}talk/manager/talkNotesListView')"><i class="glyphicon glyphicon-th-list"></i>谈话记录</a></li>
                            <li><a href="#" onclick="menuClick('${basePath}partyModel/manager/partyModelListView')"><i class="glyphicon glyphicon-th-list"></i>党员先锋模范</a></li>
                            <li><a href="#" onclick="menuClick('${basePath}study/manager/studyGardenListView')"><i class="glyphicon glyphicon-th-list"></i>学习园地</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#systemSetting1" class="nav-header collapsed" style="font-size: 20px;"  data-toggle="collapse">
                            <i class="glyphicon glyphicon-cog"></i>系统设置
                               <span class="pull-right glyphicon glyphicon-chevron-down"></span>
                        </a>
                        <ul id="systemSetting1" class="nav nav-list collapse secondmenu" style="height: 0px; padding-left: 20px;">
                            <li><a href="#" onclick="menuClick('${basePath}user/userInfoListView')"><i class="glyphicon glyphicon-asterisk"></i>权限管理</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
		</div>
		<div class="col-md-10 column">
			<div>
				<iframe id="iframe-page-content" src="${basePath}data/manager/toPartMemberWorkView" width="100%" height="100%"  frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="yes" allowtransparency="yes"></iframe>
			</div>				
		</div>
		</div>
	</div>
</body>
</html>
