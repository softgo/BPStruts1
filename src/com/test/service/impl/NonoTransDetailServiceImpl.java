package com.test.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javabase.base.app.LOG4jUtils;
import com.javabase.pulgin.mybatis.plugin.PageView;
import com.test.dao.NonoTransDetailDao;
import com.test.entity.NonoTransDetail;
import com.test.service.NonoTransDetailService;

/**
 * 接口定义实现
 * 
 * @author bruce
 *
 */
 
@Transactional
@Service("nonoTransDetailService")
public class NonoTransDetailServiceImpl implements NonoTransDetailService {

	@Autowired
    private NonoTransDetailDao  nonoTransDetailDao;
		
	/**
     * 通过主键查询
     * @param pk
     * @return
     */
    public NonoTransDetail findById( String pk ){
        try {
             return nonoTransDetailDao.findById(pk);
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
	public NonoTransDetail findByName(String objName){
        try {
             return nonoTransDetailDao.findByName(objName);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过名字查找单个对象失败了",e);
            return null;
        }
	}
	
	/**
	 * 通过对象查询对象.
	 * @param nonoTransDetail
	 * @return
	 */
	public NonoTransDetail findByProps(NonoTransDetail nonoTransDetail){
        try {
             return nonoTransDetailDao.findByProps(nonoTransDetail);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过属性查找单个对象失败了",e);
            return null;
        }
	}
	
    /**
     * 返回分页后的数据
     * @param pageView
     * @param nonoTransDetail
     * @return
     */
    public PageView find(PageView pageView,NonoTransDetail nonoTransDetail ){
        try {
             List<NonoTransDetail> list = nonoTransDetailDao.find(pageView, nonoTransDetail);
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
     * @param nonoTransDetail
     * @return
     */
	public PageView findPage(PageView pageView,Map<String, Object> params) {
		try {
			List<NonoTransDetail> list = nonoTransDetailDao.findPages(params);
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
    public List<NonoTransDetail> findAll(){
        try {
             return nonoTransDetailDao.findAll();
        }
        catch (Exception e) {
            LOG4jUtils.error("查找所有对象失败了",e);
            return null;
        }
    }

	/**
	 * 返回所有数据
	 * @param nonoTransDetail
	 * @return
	 */
	public List<NonoTransDetail> findAllByPros(NonoTransDetail nonoTransDetail){
        try {
             return nonoTransDetailDao.findAllByPros(nonoTransDetail);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过属性查找集合对象失败了",e);
            return null;
        }
	}
	
	/**
     * 添加
     * @param nonoTransDetail
     */
    public int addOne(NonoTransDetail nonoTransDetail){
        try {
             return nonoTransDetailDao.addOne(nonoTransDetail);
        }
        catch (Exception e) {
            LOG4jUtils.error("添加一个对象失败了",e);
            return -1;
        }
    }
    
	/**
     * 添加
     * @param nonoTransDetails
     */
    public boolean addAll(List<NonoTransDetail> nonoTransDetails){
        try {
             return nonoTransDetailDao.addAll(nonoTransDetails);
        }
        catch (Exception e) {
            LOG4jUtils.error("添加所有对象失败了",e);
            return false;
        }
    }
    
	/**
     * 修改一个
     * @param nonoTransDetail
     */
    public int updateOne(NonoTransDetail nonoTransDetail){
        try {
             return nonoTransDetailDao.updateOne(nonoTransDetail);
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
    public boolean updateAll(List<NonoTransDetail> pks){
        try {
             return nonoTransDetailDao.updateAll(pks);
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
             return nonoTransDetailDao.deleteById(pk);
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
             return nonoTransDetailDao.deleteAll(pks);
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
             return nonoTransDetailDao.getObjsCount();
        }
        catch (Exception e) {
            LOG4jUtils.error("查找全表数据失败了",e);
            return -1;
        }
	}
	
    /**
     * 获得条数
     * @param nonoTransDetail
     */
    public int getObjsByProsCount(NonoTransDetail nonoTransDetail){
        try {
             return nonoTransDetailDao.getObjsByProsCount(nonoTransDetail);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过属性查找数据失败了",e);
            return -1;
        }
    }

}
