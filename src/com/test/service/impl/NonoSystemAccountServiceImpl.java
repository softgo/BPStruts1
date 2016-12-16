package com.test.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javabase.base.app.LOG4jUtils;
import com.javabase.pulgin.mybatis.plugin.PageView;
import com.test.dao.NonoSystemAccountDao;
import com.test.entity.NonoSystemAccount;
import com.test.service.NonoSystemAccountService;

/**
 * 接口定义实现
 * 
 * @author bruce
 *
 */
 
@Transactional
@Service("nonoSystemAccountService")
public class NonoSystemAccountServiceImpl implements NonoSystemAccountService {

	@Autowired
    private NonoSystemAccountDao  nonoSystemAccountDao;
		
	/**
     * 通过主键查询
     * @param pk
     * @return
     */
    public NonoSystemAccount findById( String pk ){
        try {
             return nonoSystemAccountDao.findById(pk);
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
	public NonoSystemAccount findByName(String objName){
        try {
             return nonoSystemAccountDao.findByName(objName);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过名字查找单个对象失败了",e);
            return null;
        }
	}
	
	/**
	 * 通过对象查询对象.
	 * @param nonoSystemAccount
	 * @return
	 */
	public NonoSystemAccount findByProps(NonoSystemAccount nonoSystemAccount){
        try {
             return nonoSystemAccountDao.findByProps(nonoSystemAccount);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过属性查找单个对象失败了",e);
            return null;
        }
	}
	
    /**
     * 返回分页后的数据
     * @param pageView
     * @param nonoSystemAccount
     * @return
     */
    public PageView find(PageView pageView,NonoSystemAccount nonoSystemAccount ){
        try {
             List<NonoSystemAccount> list = nonoSystemAccountDao.find(pageView, nonoSystemAccount);
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
     * @param nonoSystemAccount
     * @return
     */
	public PageView findPage(PageView pageView,Map<String, Object> params) {
		try {
			List<NonoSystemAccount> list = nonoSystemAccountDao.findPages(params);
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
    public List<NonoSystemAccount> findAll(){
        try {
             return nonoSystemAccountDao.findAll();
        }
        catch (Exception e) {
            LOG4jUtils.error("查找所有对象失败了",e);
            return null;
        }
    }

	/**
	 * 返回所有数据
	 * @param nonoSystemAccount
	 * @return
	 */
	public List<NonoSystemAccount> findAllByPros(NonoSystemAccount nonoSystemAccount){
        try {
             return nonoSystemAccountDao.findAllByPros(nonoSystemAccount);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过属性查找集合对象失败了",e);
            return null;
        }
	}
	
	/**
     * 添加
     * @param nonoSystemAccount
     */
    public int addOne(NonoSystemAccount nonoSystemAccount){
        try {
             return nonoSystemAccountDao.addOne(nonoSystemAccount);
        }
        catch (Exception e) {
            LOG4jUtils.error("添加一个对象失败了",e);
            return -1;
        }
    }
    
	/**
     * 添加
     * @param nonoSystemAccounts
     */
    public boolean addAll(List<NonoSystemAccount> nonoSystemAccounts){
        try {
             return nonoSystemAccountDao.addAll(nonoSystemAccounts);
        }
        catch (Exception e) {
            LOG4jUtils.error("添加所有对象失败了",e);
            return false;
        }
    }
    
	/**
     * 修改一个
     * @param nonoSystemAccount
     */
    public int updateOne(NonoSystemAccount nonoSystemAccount){
        try {
             return nonoSystemAccountDao.updateOne(nonoSystemAccount);
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
    public boolean updateAll(List<NonoSystemAccount> pks){
        try {
             return nonoSystemAccountDao.updateAll(pks);
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
             return nonoSystemAccountDao.deleteById(pk);
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
             return nonoSystemAccountDao.deleteAll(pks);
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
             return nonoSystemAccountDao.getObjsCount();
        }
        catch (Exception e) {
            LOG4jUtils.error("查找全表数据失败了",e);
            return -1;
        }
	}
	
    /**
     * 获得条数
     * @param nonoSystemAccount
     */
    public int getObjsByProsCount(NonoSystemAccount nonoSystemAccount){
        try {
             return nonoSystemAccountDao.getObjsByProsCount(nonoSystemAccount);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过属性查找数据失败了",e);
            return -1;
        }
    }

}
