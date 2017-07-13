package com.itheima.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itheima.dao.ProductDao;
import com.itheima.dao.ProductListDao;
import com.itheima.domain.Product;
import com.itheima.vo.PageBean;

public class ProductListService {

	public List<Product> findAllProduct() throws SQLException {
		ProductListDao dao = new ProductListDao();
		return dao.findAllProduct();
	}

	//分页操作
	public PageBean<Product> findPageBean(int currentPage, int currentCount) throws SQLException {
		
		ProductDao dao = new ProductDao();
		
		// 目的，想办法封装一个PageBean返回
		PageBean pageBean = new PageBean();
		//当前页 private int currentPage;
		pageBean.setCurrentPage(currentPage);
		//当前页显示条数 private int currentCount;
		pageBean.setCurrentCount(currentCount);
		//总条数 private int totalCount;
		int totalCount = dao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		//总页数 private int totalPage;
		int totalPage = (int) Math.ceil(1.0 * totalCount/currentCount);
		pageBean.setTotalPage(totalPage);
		//每一页面显示的数据 private List<T> productList = new ArrayList<T>();
		int index = (currentPage -1 ) * currentCount;
		List<Product> productList = dao.findProductListForPageBead(index, currentCount);
		pageBean.setProductList(productList);
		return pageBean;
	}

}
