package com.javabase.service;

import java.util.List;

import com.javabase.pulgin.mybatis.plugin.PageView;
import com.javabase.entity.SysLogs;

/**
 * service 的接口定义(实际使用中可以自行添加)
 * 
 * @author bruce
 *
 */
 
public interface SysLogsService {

	 /**
     * 通过主键查询
     * @param pk
     * @return
     */
    public SysLogs findById( String pk );
    
	/**
	 * 通过名字查询
	 * @param objName
	 * @return
	 */
	public SysLogs findByName( String objName );

	/**
	 * 通过属性查询对象.
	 * @param sysLogs
	 * @return
	 */
	public SysLogs findByProps(SysLogs sysLogs);

     /**
     * 返回分页后的数据
     * @param pageView
     * @param sysLogs
     * @return
     */
    public PageView find(PageView pageView,SysLogs sysLogs);
    
	/**
	 * 返回所有数据
	 * @return
	 */
	public List<SysLogs> findAll();

	/**
	 * 返回所有数据
	 * @param sysLogs
	 * @return
	 */
	public List<SysLogs> findAllByPros(SysLogs sysLogs);
	
	/**
	 * 添加一个
	 * @param sysLogs
	 */
	public int addOne(SysLogs sysLogs);
	
    /**
     * 添加多个
     * @param sysLogss
     */
    public boolean addAll(List<SysLogs> sysLogss);
    	
	/**
	 * 修改一个.
	 * @param sysLogs
	 */
	public int updateOne(SysLogs sysLogs);
	
	/**
	 * 修改所有.
	 * @param sysLogss
	 */
	public boolean updateAll(List<SysLogs> sysLogss);
	
	/**
	 * 删除一个
	 * @param pk
	 */
	public int deleteById(String pk);
	
	/**
	 * 删除所有
	 * @param pks
	 */
	public boolean deleteAll(List<String> pks);	

	/**
	 * 获得总条数.
	 * @return
	 */
	public int getObjsCount();	
	
    /**
     * 通过条件获得总条数.
     * @return
     */
    public int getObjsByProsCount(SysLogs sysLogs);  
    
}
