package cn.cdcas.edu.category.service;

import java.util.List;

import cn.cdcas.edu.category.dao.CategoryDao;
import cn.cdcas.edu.category.vo.Category;
import org.springframework.transaction.annotation.Transactional;


/**
 * 一级分类的业务层对象
 */
@Transactional
public class CategoryService {
	// 注入CategoryDao
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	// 业务层查询所有一级分类的方法
	public List<Category> findAll() {
		return categoryDao.findAll();
	}
	
}
