package com.test.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javabase.base.app.LOG4jUtils;
import com.javabase.pulgin.mybatis.plugin.PageView;
import com.test.dao.NonoUserProductDetailDao;
import com.test.entity.NonoUserProductDetail;
import com.test.service.NonoUserProductDetailService;

/**
 * 接口定义实现
 * 
 * @author bruce
 *
 */
 
@Transactional
@Service("nonoUserProductDetailService")
public class NonoUserProductDetailServiceImpl implements NonoUserProductDetailService {

	@Autowired
    private NonoUserProductDetailDao  nonoUserProductDetailDao;
		
	/**
     * 通过主键查询
     * @param pk
     * @return
     */
    public NonoUserProductDetail findById( String pk ){
        try {
             return nonoUserProductDetailDao.findById(pk);
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
	public NonoUserProductDetail findByName(String objName){
        try {
             return nonoUserProductDetailDao.findByName(objName);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过名字查找单个对象失败了",e);
            return null;
        }
	}
	
	/**
	 * 通过对象查询对象.
	 * @param nonoUserProductDetail
	 * @return
	 */
	public NonoUserProductDetail findByProps(NonoUserProductDetail nonoUserProductDetail){
        try {
             return nonoUserProductDetailDao.findByProps(nonoUserProductDetail);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过属性查找单个对象失败了",e);
            return null;
        }
	}
	
    /**
     * 返回分页后的数据
     * @param pageView
     * @param nonoUserProductDetail
     * @return
     */
    public PageView find(PageView pageView,NonoUserProductDetail nonoUserProductDetail ){
        try {
             List<NonoUserProductDetail> list = nonoUserProductDetailDao.find(pageView, nonoUserProductDetail);
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
     * @param nonoUserProductDetail
     * @return
     */
	public PageView findPage(PageView pageView,Map<String, Object> params) {
		try {
			List<NonoUserProductDetail> list = nonoUserProductDetailDao.findPages(params);
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
    public List<NonoUserProductDetail> findAll(){
        try {
             return nonoUserProductDetailDao.findAll();
        }
        catch (Exception e) {
            LOG4jUtils.error("查找所有对象失败了",e);
            return null;
        }
    }

	/**
	 * 返回所有数据
	 * @param nonoUserProductDetail
	 * @return
	 */
	public List<NonoUserProductDetail> findAllByPros(NonoUserProductDetail nonoUserProductDetail){
        try {
             return nonoUserProductDetailDao.findAllByPros(nonoUserProductDetail);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过属性查找集合对象失败了",e);
            return null;
        }
	}
	
	/**
     * 添加
     * @param nonoUserProductDetail
     */
    public int addOne(NonoUserProductDetail nonoUserProductDetail){
        try {
             return nonoUserProductDetailDao.addOne(nonoUserProductDetail);
        }
        catch (Exception e) {
            LOG4jUtils.error("添加一个对象失败了",e);
            return -1;
        }
    }
    
	/**
     * 添加
     * @param nonoUserProductDetails
     */
    public boolean addAll(List<NonoUserProductDetail> nonoUserProductDetails){
        try {
             return nonoUserProductDetailDao.addAll(nonoUserProductDetails);
        }
        catch (Exception e) {
            LOG4jUtils.error("添加所有对象失败了",e);
            return false;
        }
    }
    
	/**
     * 修改一个
     * @param nonoUserProductDetail
     */
    public int updateOne(NonoUserProductDetail nonoUserProductDetail){
        try {
             return nonoUserProductDetailDao.updateOne(nonoUserProductDetail);
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
    public boolean updateAll(List<NonoUserProductDetail> pks){
        try {
             return nonoUserProductDetailDao.updateAll(pks);
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
             return nonoUserProductDetailDao.deleteById(pk);
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
             return nonoUserProductDetailDao.deleteAll(pks);
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
             return nonoUserProductDetailDao.getObjsCount();
        }
        catch (Exception e) {
            LOG4jUtils.error("查找全表数据失败了",e);
            return -1;
        }
	}
	
    /**
     * 获得条数
     * @param nonoUserProductDetail
     */
    public int getObjsByProsCount(NonoUserProductDetail nonoUserProductDetail){
        try {
             return nonoUserProductDetailDao.getObjsByProsCount(nonoUserProductDetail);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过属性查找数据失败了",e);
            return -1;
        }
    }

}
