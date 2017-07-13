package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.domain.Product;
import com.itheima.utils.DataSourceUtils;

public class ProductDao {

	// 获得全部的商品条数
	public int getTotalCount() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource()); 
		String sql = "SELECT count(*) FROM product";
		Long totalCount = (Long)runner.query(sql, new ScalarHandler()); 
		return totalCount.intValue();
	}

	public List<Product> findProductListForPageBead(int index, int currentCount) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "SELECT * FROM product limit ?,?";
		return runner.query(sql, new BeanListHandler<Product>(Product.class), index, currentCount);
	}

}
