package com.test.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javabase.base.app.LOG4jUtils;
import com.javabase.pulgin.mybatis.plugin.PageView;
import com.test.dao.NonoDebtAllocateErrDao;
import com.test.entity.NonoDebtAllocateErr;
import com.test.service.NonoDebtAllocateErrService;

/**
 * 接口定义实现
 * 
 * @author bruce
 *
 */
 
@Transactional
@Service("nonoDebtAllocateErrService")
public class NonoDebtAllocateErrServiceImpl implements NonoDebtAllocateErrService {

	@Autowired
    private NonoDebtAllocateErrDao  nonoDebtAllocateErrDao;
		
	/**
     * 通过主键查询
     * @param pk
     * @return
     */
    public NonoDebtAllocateErr findById( String pk ){
        try {
             return nonoDebtAllocateErrDao.findById(pk);
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
	public NonoDebtAllocateErr findByName(String objName){
        try {
             return nonoDebtAllocateErrDao.findByName(objName);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过名字查找单个对象失败了",e);
            return null;
        }
	}
	
	/**
	 * 通过对象查询对象.
	 * @param nonoDebtAllocateErr
	 * @return
	 */
	public NonoDebtAllocateErr findByProps(NonoDebtAllocateErr nonoDebtAllocateErr){
        try {
             return nonoDebtAllocateErrDao.findByProps(nonoDebtAllocateErr);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过属性查找单个对象失败了",e);
            return null;
        }
	}
	
    /**
     * 返回分页后的数据
     * @param pageView
     * @param nonoDebtAllocateErr
     * @return
     */
    public PageView find(PageView pageView,NonoDebtAllocateErr nonoDebtAllocateErr ){
        try {
             List<NonoDebtAllocateErr> list = nonoDebtAllocateErrDao.find(pageView, nonoDebtAllocateErr);
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
     * @param nonoDebtAllocateErr
     * @return
     */
	public PageView findPage(PageView pageView,Map<String, Object> params) {
		try {
			List<NonoDebtAllocateErr> list = nonoDebtAllocateErrDao.findPages(params);
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
    public List<NonoDebtAllocateErr> findAll(){
        try {
             return nonoDebtAllocateErrDao.findAll();
        }
        catch (Exception e) {
            LOG4jUtils.error("查找所有对象失败了",e);
            return null;
        }
    }

	/**
	 * 返回所有数据
	 * @param nonoDebtAllocateErr
	 * @return
	 */
	public List<NonoDebtAllocateErr> findAllByPros(NonoDebtAllocateErr nonoDebtAllocateErr){
        try {
             return nonoDebtAllocateErrDao.findAllByPros(nonoDebtAllocateErr);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过属性查找集合对象失败了",e);
            return null;
        }
	}
	
	/**
     * 添加
     * @param nonoDebtAllocateErr
     */
    public int addOne(NonoDebtAllocateErr nonoDebtAllocateErr){
        try {
             return nonoDebtAllocateErrDao.addOne(nonoDebtAllocateErr);
        }
        catch (Exception e) {
            LOG4jUtils.error("添加一个对象失败了",e);
            return -1;
        }
    }
    
	/**
     * 添加
     * @param nonoDebtAllocateErrs
     */
    public boolean addAll(List<NonoDebtAllocateErr> nonoDebtAllocateErrs){
        try {
             return nonoDebtAllocateErrDao.addAll(nonoDebtAllocateErrs);
        }
        catch (Exception e) {
            LOG4jUtils.error("添加所有对象失败了",e);
            return false;
        }
    }
    
	/**
     * 修改一个
     * @param nonoDebtAllocateErr
     */
    public int updateOne(NonoDebtAllocateErr nonoDebtAllocateErr){
        try {
             return nonoDebtAllocateErrDao.updateOne(nonoDebtAllocateErr);
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
    public boolean updateAll(List<NonoDebtAllocateErr> pks){
        try {
             return nonoDebtAllocateErrDao.updateAll(pks);
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
             return nonoDebtAllocateErrDao.deleteById(pk);
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
             return nonoDebtAllocateErrDao.deleteAll(pks);
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
             return nonoDebtAllocateErrDao.getObjsCount();
        }
        catch (Exception e) {
            LOG4jUtils.error("查找全表数据失败了",e);
            return -1;
        }
	}
	
    /**
     * 获得条数
     * @param nonoDebtAllocateErr
     */
    public int getObjsByProsCount(NonoDebtAllocateErr nonoDebtAllocateErr){
        try {
             return nonoDebtAllocateErrDao.getObjsByProsCount(nonoDebtAllocateErr);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过属性查找数据失败了",e);
            return -1;
        }
    }

}
