package ${bussPackage}.${basePackage}.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javabase.base.app.LOG4jUtils;
import com.javabase.pulgin.mybatis.plugin.PageView;

import ${bussPackage}.${basePackage}.entity.${className};
import ${bussPackage}.${basePackage}.dao.${className}Dao;
import ${bussPackage}.${basePackage}.service.${className}Service;

/**
 * 接口定义实现
 * 
 * @author bruce
 *
 */
 
@Transactional
@Service("${lowerName}Service")
public class ${className}ServiceImpl implements ${className}Service {

	@Autowired
    private ${className}Dao  ${lowerName}Dao;
		
	/**
     * 通过主键查询
     * @param pk
     * @return
     */
    public ${className} findById( String pk ){
        try {
             return ${lowerName}Dao.findById(pk);
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
	public ${className} findByName(String objName){
        try {
             return ${lowerName}Dao.findByName(objName);
        }
        catch (Exception e) {
            LOG4jUtils.error("通过名字查找单个对象失败了",e);
            return null;
        }
	}
	
	/**
	 * 通过对象查询对象.
	 * @param ${lowerName}
	 * @return
	 */
	public ${className} findByProps(${className} ${lowerName}){
        try {
             return ${lowerName}Dao.findByProps(${lowerName});
        }
        catch (Exception e) {
            LOG4jUtils.error("通过属性查找单个对象失败了",e);
            return null;
        }
	}
	
    /**
     * 返回分页后的数据
     * @param pageView
     * @param ${lowerName}
     * @return
     */
    public PageView find(PageView pageView,${className} ${lowerName} ){
        try {
             List<${className}> list = ${lowerName}Dao.find(pageView, ${lowerName});
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
     * @param ${lowerName}
     * @return
     */
	public PageView findPage(PageView pageView,Map<String, Object> params) {
		try {
			List<${className}> list = ${lowerName}Dao.findPages(params);
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
    public List<${className}> findAll(){
        try {
             return ${lowerName}Dao.findAll();
        }
        catch (Exception e) {
            LOG4jUtils.error("查找所有对象失败了",e);
            return null;
        }
    }

	/**
	 * 返回所有数据
	 * @param ${lowerName}
	 * @return
	 */
	public List<${className}> findAllByPros(${className} ${lowerName}){
        try {
             return ${lowerName}Dao.findAllByPros(${lowerName});
        }
        catch (Exception e) {
            LOG4jUtils.error("通过属性查找集合对象失败了",e);
            return null;
        }
	}
	
	/**
     * 添加
     * @param ${lowerName}
     */
    public int addOne(${className} ${lowerName}){
        try {
             return ${lowerName}Dao.addOne(${lowerName});
        }
        catch (Exception e) {
            LOG4jUtils.error("添加一个对象失败了",e);
            return -1;
        }
    }
    
	/**
     * 添加
     * @param ${lowerName}s
     */
    public boolean addAll(List<${className}> ${lowerName}s){
        try {
             return ${lowerName}Dao.addAll(${lowerName}s);
        }
        catch (Exception e) {
            LOG4jUtils.error("添加所有对象失败了",e);
            return false;
        }
    }
    
	/**
     * 修改一个
     * @param ${lowerName}
     */
    public int updateOne(${className} ${lowerName}){
        try {
             return ${lowerName}Dao.updateOne(${lowerName});
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
    public boolean updateAll(List<${className}> pks){
        try {
             return ${lowerName}Dao.updateAll(pks);
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
             return ${lowerName}Dao.deleteById(pk);
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
             return ${lowerName}Dao.deleteAll(pks);
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
             return ${lowerName}Dao.getObjsCount();
        }
        catch (Exception e) {
            LOG4jUtils.error("查找全表数据失败了",e);
            return -1;
        }
	}
	
    /**
     * 获得条数
     * @param ${lowerName}
     */
    public int getObjsByProsCount(${className} ${lowerName}){
        try {
             return ${lowerName}Dao.getObjsByProsCount(${lowerName});
        }
        catch (Exception e) {
            LOG4jUtils.error("通过属性查找数据失败了",e);
            return -1;
        }
    }

}
