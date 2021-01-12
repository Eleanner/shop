package cn.cdcas.edu.product.action;


import cn.cdcas.edu.category.service.CategoryService;
import cn.cdcas.edu.product.service.ProductService;
import cn.cdcas.edu.product.vo.Product;
import cn.cdcas.edu.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 商品的Action对象
 * 
 */
public class ProductAction extends ActionSupport implements
		ModelDriven<Product> {
	// 用于接收数据的模型驱动.
	private Product product = new Product();
	// 注入商品的Service
	private ProductService productService;
	// 接收分类cid
	private Integer cid;
	private Integer csid;

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	private CategoryService categoryService;
	private int page;

	public void setPage(int page) {
		this.page = page;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public Product getModel() {
		return product;
	}

	public String findByPid() {
		product = productService.findByPid(product.getPid());
		return "findByPid";
	}

	public String findByCid() {
		PageBean<Product> pageBean = productService.findByPageCid(cid, page);// 根据一级分类查询商品,带分页查询
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCid";
	}

	public String findByCsid() {
		PageBean<Product> pageBean = productService.findByPageCsid(csid, page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCsid";
	}
}
