<div>
springboot完整示例</br> 
springboot + mybatis + mysql + freemarker + swagger 应用示例</br>
一个完整可直接运行的springboot项目示例</br>
其中：</br>
	<ul>
	<li>一、使用swagger提供对外api描述</li>
	<li>二、springboot对jsp支持不够，使用freemarker做为view展示</li>
	<li>三、自实现springboot分页插件（party-build-common/src/main/java/com/tydic/traffic/page）</li>
		分页插件网上有很多示例但存在很多不足之处，这里做了以下强化：
		<ul>
		<li>1、启动分页查询使用@pageable注解（结合aspectJ），而不使用硬编码向ThreadLocal中容器中加分页参数</li>
		<li>2、查询分页信息时子查询不执行分页查询，某些实现会对子查询也进行分页显然是不对的</li>
		</ul>
	<li>四、yml配置文件中的敏感信息加密（比如数据库密码）处理————使用DES对称加密（party-build-common/src/main/java/com/tydic/traffic/encrypt）</li>
	<li>五、其他springboot相关参考，如：Guava本地缓存springboot插件、常量配置、mvc时间格式化、logback文件支持环境切换配置、多数据源配置、Druid监听等</li>
	</ul>
</div>	
		

