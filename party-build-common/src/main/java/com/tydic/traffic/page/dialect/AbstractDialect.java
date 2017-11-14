package com.tydic.traffic.page.dialect;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.RowBounds;

import com.tydic.traffic.page.Page;
import com.tydic.traffic.page.parser.CountSqlParser;

public abstract class AbstractDialect {
	
	//处理SQL
    protected CountSqlParser countSqlParser = new CountSqlParser();

	public abstract String getPageSql(String sql, Page<Object> page);

	public String getCountSql(MappedStatement ms, BoundSql boundSql, Object parameterObject, RowBounds rowBounds, CacheKey countKey) {
		return countSqlParser.getSmartCountSql(boundSql.getSql());
	}
}
