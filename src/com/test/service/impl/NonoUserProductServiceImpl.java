package com.test.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javabase.base.app.LOG4jUtils;
import com.javabase.base.util.ContainerUtils;
import com.javabase.base.util.EnumCode;
import com.javabase.pulgin.mybatis.plugin.PageView;
import com.test.dao.NonoLimitProductDao;
import com.test.dao.NonoSystemAccountDao;
import com.test.dao.NonoTransDetailDao;
import com.test.dao.NonoUserProductDao;
import com.test.entity.NonoLimitProduct;
import com.test.entity.NonoSystemAccount;
import com.test.entity.NonoTransDetail;
import com.test.entity.NonoUserProduct;
import com.test.service.NonoUserProductService;

/**
 * 接口定义实现
 * 
 * @author bruce
 *
 */
 
@Transactional
@Service("nonoUserProductService")
public class NonoUserProductServiceImpl implements NonoUserProductService {

    @Autowired
    private NonoUserProductDao nonoUserProductDao;
	@Autowired
	private NonoTransDetailDao nonoTransDetailDao;
	@Autowired
	private NonoSystemAccountDao nonoSystemAccountDao;
	@Autowired
	private NonoLimitProductDao nonoLimitProductDao;
	
	/**
     * 通过主键查询
     * @param pk
     * @return
     */
    public NonoUserProduct findById( String pk ){
        try {
             return nonoUserProductDao.findById(pk);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过主键查找单个对象失败了",e);
            return null;
        }
    }
    
	/**
	 * 通过名字查询
	 * @param objName
	 * @return
	 */
	public NonoUserProduct findByName(String objName){
        try {
             return nonoUserProductDao.findByName(objName);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过名字查找单个对象失败了",e);
            return null;
        }
	}
	
	/**
	 * 通过对象查询对象.
	 * @param nonoUserProduct
	 * @return
	 */
	public NonoUserProduct findByProps(NonoUserProduct nonoUserProduct){
        try {
             return nonoUserProductDao.findByProps(nonoUserProduct);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过属性查找单个对象失败了",e);
            return null;
        }
	}
	
    /**
     * 返回分页后的数据
     * @param pageView
     * @param nonoUserProduct
     * @return
     */
    public PageView find(PageView pageView,NonoUserProduct nonoUserProduct ){
        try {
             List<NonoUserProduct> list = nonoUserProductDao.find(pageView, nonoUserProduct);
             pageView.setRecords(list);
             return pageView;
        }
        catch (Exception e) {
            LOG4jUtils.error("分页设置失败了",e);
            return null;
        }
    }
    
    /**
     * 返回分页后的数据
     * @param pageView
     * @param nonoUserProduct
     * @return
     */
	public PageView findPage(PageView pageView,Map<String, Object> params) {
		try {
			List<NonoUserProduct> list = nonoUserProductDao.findPages(params);
			pageView.setRecords(list);
			return pageView;
		}
		catch (Exception e) {
			LOG4jUtils.error("分页查找失败了", e);
			return null;
		}
	}

    /**
     * 返回所有数据
     * @return
     */
    public List<NonoUserProduct> findAll(){
        try {
             return nonoUserProductDao.findAll();
        }
        catch (Exception e) {
            LOG4jUtils.error("查找所有对象失败了",e);
            return null;
        }
    }

	/**
	 * 返回所有数据
	 * @param nonoUserProduct
	 * @return
	 */
	public List<NonoUserProduct> findAllByPros(NonoUserProduct nonoUserProduct){
        try {
             return nonoUserProductDao.findAllByPros(nonoUserProduct);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过属性查找集合对象失败了",e);
            return null;
        }
	}
	
	/**
     * 添加
     * @param nonoUserProduct
     */
    public int addOne(NonoUserProduct nonoUserProduct){
        try {
             return nonoUserProductDao.addOne(nonoUserProduct);
        }
        catch (Exception e) {
            LOG4jUtils.error("添加一个对象失败了",e);
            return -1;
        }
    }
    
	/**
     * 添加
     * @param nonoUserProducts
     */
    public boolean addAll(List<NonoUserProduct> nonoUserProducts){
        try {
             return nonoUserProductDao.addAll(nonoUserProducts);
        }
        catch (Exception e) {
            LOG4jUtils.error("添加所有对象失败了",e);
            return false;
        }
    }
    
	/**
     * 修改一个
     * @param nonoUserProduct
     */
    public int updateOne(NonoUserProduct nonoUserProduct){
        try {
             return nonoUserProductDao.updateOne(nonoUserProduct);
        }
        catch (Exception e) {
            LOG4jUtils.error("修改一个对象失败了",e);
            return -1;
        }
    }
    
    /**
     * 修改所有
     * @param pks
     */
    public boolean updateAll(List<NonoUserProduct> pks){
        try {
             return nonoUserProductDao.updateAll(pks);
        }
        catch (Exception e) {
            LOG4jUtils.error("修改所有对象失败了",e);
            return false;
        }
    }
	
	/**
	 * 删除一个
	 * @param pk
	 */
	public int deleteById(String pk){
        try {
             return nonoUserProductDao.deleteById(pk);
        }
        catch (Exception e) {
            LOG4jUtils.error("删除一个对象失败了",e);
            return -1;
        }
	}
	
	/**
	 * 删除所有
	 * @param pks
	 */
	public boolean deleteAll(List<String> pks){
        try {
             return nonoUserProductDao.deleteAll(pks);
        }
        catch (Exception e) {
            LOG4jUtils.error("删除所有对象失败了",e);
            return false;
        }
	}
	
	/**
	 * 获得条数
	 */
	public int getObjsCount(){
        try {
             return nonoUserProductDao.getObjsCount();
        }
        catch (Exception e) {
            LOG4jUtils.error("查找全表数据失败了",e);
            return -1;
        }
	}
	
    /**
     * 获得条数
     * @param nonoUserProduct
     */
    public int getObjsByProsCount(NonoUserProduct nonoUserProduct){
        try {
             return nonoUserProductDao.getObjsByProsCount(nonoUserProduct);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过属性查找数据失败了",e);
            return -1;
        }
    }
    
	@Override
	@Transactional
	public Map<String, Object> allocateDebts(String orderId, BigDecimal amount, String nonoCode, Integer userCode,
	        String productCode, String userType) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            //添加记录到 nono_user_product.
            NonoUserProduct nonoUserProduct = new NonoUserProduct(userCode,nonoCode,orderId,1,productCode,amount,amount,userType);
            int count = nonoUserProductDao.addOne(nonoUserProduct);
            if (count >0) {
                NonoTransDetail nonoTransDetail = new NonoTransDetail(userCode,nonoCode,orderId,productCode,1,amount,userType,1);
                int rows2 = nonoTransDetailDao.addOne(nonoTransDetail);
                NonoSystemAccount nonoSystemAccount = new NonoSystemAccount(userCode,nonoCode,userType,productCode,orderId,amount,BigDecimal.ZERO,amount,1);
                int rows4 = nonoSystemAccountDao.addOne(nonoSystemAccount);
                NonoLimitProduct nonoLimitProduct = new NonoLimitProduct(productCode, 1, amount, amount, amount, BigDecimal.ZERO, "2016-04-18");
                int rows5 = nonoLimitProductDao.addOne(nonoLimitProduct); 
                if (rows2>0 && rows4>0 && rows5>0) {
            		 if (true) {
                         //事物测试.
                        throw new RuntimeException();
					}
                    return ContainerUtils.buildHeadMap(resultMap, 1, "后台服务系统处理诺诺购买请求成功", EnumCode.NO0);
				}else {
	                return ContainerUtils.buildHeadMap(resultMap, 0, "后台服务系统处理诺诺购买请求异常", EnumCode.NO5);
				}
            }else{
                return ContainerUtils.buildHeadMap(resultMap, 0, "后台服务系统处理诺诺购买请求异常", EnumCode.NO5);
            }
        }
        catch (Exception e) {
            LOG4jUtils.error("匹配债权失败了",e);
            return ContainerUtils.buildHeadMap(resultMap, 0, "后台服务系统处理诺诺购买请求异常", EnumCode.NO5);
        }
    }

}
