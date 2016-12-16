package com.test.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javabase.base.app.LOG4jUtils;
import com.javabase.pulgin.mybatis.plugin.PageView;
import com.test.dao.NonoLimitProductDao;
import com.test.entity.NonoLimitProduct;
import com.test.service.NonoLimitProductService;

/**
 * 接口定义实现
 * 
 * @author bruce
 *
 */
 
@Transactional
@Service("nonoLimitProductService")
public class NonoLimitProductServiceImpl implements NonoLimitProductService {

	@Autowired
    private NonoLimitProductDao  nonoLimitProductDao;
		
	/**
     * 通过主键查询
     * @param pk
     * @return
     */
    public NonoLimitProduct findById( String pk ){
        try {
             return nonoLimitProductDao.findById(pk);
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
	public NonoLimitProduct findByName(String objName){
        try {
             return nonoLimitProductDao.findByName(objName);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过名字查找单个对象失败了",e);
            return null;
        }
	}
	
	/**
	 * 通过对象查询对象.
	 * @param nonoLimitProduct
	 * @return
	 */
	public NonoLimitProduct findByProps(NonoLimitProduct nonoLimitProduct){
        try {
             return nonoLimitProductDao.findByProps(nonoLimitProduct);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过属性查找单个对象失败了",e);
            return null;
        }
	}
	
    /**
     * 返回分页后的数据
     * @param pageView
     * @param nonoLimitProduct
     * @return
     */
    public PageView find(PageView pageView,NonoLimitProduct nonoLimitProduct ){
        try {
             List<NonoLimitProduct> list = nonoLimitProductDao.find(pageView, nonoLimitProduct);
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
     * @param nonoLimitProduct
     * @return
     */
	public PageView findPage(PageView pageView,Map<String, Object> params) {
		try {
			List<NonoLimitProduct> list = nonoLimitProductDao.findPages(params);
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
    public List<NonoLimitProduct> findAll(){
        try {
             return nonoLimitProductDao.findAll();
        }
        catch (Exception e) {
            LOG4jUtils.error("查找所有对象失败了",e);
            return null;
        }
    }

	/**
	 * 返回所有数据
	 * @param nonoLimitProduct
	 * @return
	 */
	public List<NonoLimitProduct> findAllByPros(NonoLimitProduct nonoLimitProduct){
        try {
             return nonoLimitProductDao.findAllByPros(nonoLimitProduct);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过属性查找集合对象失败了",e);
            return null;
        }
	}
	
	/**
     * 添加
     * @param nonoLimitProduct
     */
    public int addOne(NonoLimitProduct nonoLimitProduct){
        try {
             return nonoLimitProductDao.addOne(nonoLimitProduct);
        }
        catch (Exception e) {
            LOG4jUtils.error("添加一个对象失败了",e);
            return -1;
        }
    }
    
	/**
     * 添加
     * @param nonoLimitProducts
     */
    public boolean addAll(List<NonoLimitProduct> nonoLimitProducts){
        try {
             return nonoLimitProductDao.addAll(nonoLimitProducts);
        }
        catch (Exception e) {
            LOG4jUtils.error("添加所有对象失败了",e);
            return false;
        }
    }
    
	/**
     * 修改一个
     * @param nonoLimitProduct
     */
    public int updateOne(NonoLimitProduct nonoLimitProduct){
        try {
             return nonoLimitProductDao.updateOne(nonoLimitProduct);
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
    public boolean updateAll(List<NonoLimitProduct> pks){
        try {
             return nonoLimitProductDao.updateAll(pks);
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
             return nonoLimitProductDao.deleteById(pk);
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
             return nonoLimitProductDao.deleteAll(pks);
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
             return nonoLimitProductDao.getObjsCount();
        }
        catch (Exception e) {
            LOG4jUtils.error("查找全表数据失败了",e);
            return -1;
        }
	}
	
    /**
     * 获得条数
     * @param nonoLimitProduct
     */
    public int getObjsByProsCount(NonoLimitProduct nonoLimitProduct){
        try {
             return nonoLimitProductDao.getObjsByProsCount(nonoLimitProduct);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过属性查找数据失败了",e);
            return -1;
        }
    }

}
