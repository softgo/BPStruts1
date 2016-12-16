package com.test.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javabase.base.app.LOG4jUtils;
import com.javabase.pulgin.mybatis.plugin.PageView;

import com.test.entity.NonoUser;
import com.test.dao.NonoUserDao;
import com.test.service.NonoUserService;

/**
 * 接口定义实现
 * 
 * @author bruce
 *
 */
 
@Transactional
@Service("nonoUserService")
public class NonoUserServiceImpl implements NonoUserService {

	@Autowired
    private NonoUserDao  nonoUserDao;
		
	/**
     * 通过主键查询
     * @param pk
     * @return
     */
    public NonoUser findById( String pk ){
        try {
             return nonoUserDao.findById(pk);
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
	public NonoUser findByName(String objName){
        try {
             return nonoUserDao.findByName(objName);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过名字查找单个对象失败了",e);
            return null;
        }
	}
	
	/**
	 * 通过对象查询对象.
	 * @param nonoUser
	 * @return
	 */
	public NonoUser findByProps(NonoUser nonoUser){
        try {
             return nonoUserDao.findByProps(nonoUser);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过属性查找单个对象失败了",e);
            return null;
        }
	}
	
    /**
     * 返回分页后的数据
     * @param pageView
     * @param nonoUser
     * @return
     */
    public PageView find(PageView pageView,NonoUser nonoUser ){
        try {
             List<NonoUser> list = nonoUserDao.find(pageView, nonoUser);
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
     * @param nonoUser
     * @return
     */
	public PageView findPage(PageView pageView,Map<String, Object> params) {
		try {
			List<NonoUser> list = nonoUserDao.findPages(params);
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
    public List<NonoUser> findAll(){
        try {
             return nonoUserDao.findAll();
        }
        catch (Exception e) {
            LOG4jUtils.error("查找所有对象失败了",e);
            return null;
        }
    }

	/**
	 * 返回所有数据
	 * @param nonoUser
	 * @return
	 */
	public List<NonoUser> findAllByPros(NonoUser nonoUser){
        try {
             return nonoUserDao.findAllByPros(nonoUser);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过属性查找集合对象失败了",e);
            return null;
        }
	}
	
	/**
     * 添加
     * @param nonoUser
     */
    public int addOne(NonoUser nonoUser){
        try {
             return nonoUserDao.addOne(nonoUser);
        }
        catch (Exception e) {
            LOG4jUtils.error("添加一个对象失败了",e);
            return -1;
        }
    }
    
	/**
     * 添加
     * @param nonoUsers
     */
    public boolean addAll(List<NonoUser> nonoUsers){
        try {
             return nonoUserDao.addAll(nonoUsers);
        }
        catch (Exception e) {
            LOG4jUtils.error("添加所有对象失败了",e);
            return false;
        }
    }
    
	/**
     * 修改一个
     * @param nonoUser
     */
    public int updateOne(NonoUser nonoUser){
        try {
             return nonoUserDao.updateOne(nonoUser);
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
    public boolean updateAll(List<NonoUser> pks){
        try {
             return nonoUserDao.updateAll(pks);
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
             return nonoUserDao.deleteById(pk);
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
             return nonoUserDao.deleteAll(pks);
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
             return nonoUserDao.getObjsCount();
        }
        catch (Exception e) {
            LOG4jUtils.error("查找全表数据失败了",e);
            return -1;
        }
	}
	
    /**
     * 获得条数
     * @param nonoUser
     */
    public int getObjsByProsCount(NonoUser nonoUser){
        try {
             return nonoUserDao.getObjsByProsCount(nonoUser);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过属性查找数据失败了",e);
            return -1;
        }
    }


}
