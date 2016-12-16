package com.test.service;

import java.math.BigDecimal;
import java.util.Map;

import com.javabase.base.BaseService;
import com.test.entity.NonoUserProduct;

/**
 * service 的接口定义(实际使用中可以自行添加)
 * 
 * @author bruce
 *
 */
 
public interface NonoUserProductService extends BaseService<NonoUserProduct> {

	//编写除过公共Service接口外的接口
	   /**
	    * 匹配债权操作.
	    * @return
	    */
	   public Map<String, Object> allocateDebts(String orderId,BigDecimal amount,String nonoCode,Integer userCode,String productCode,String userType);
}
