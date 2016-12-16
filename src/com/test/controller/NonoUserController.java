package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.javabase.base.BaseController;
import com.javabase.pulgin.mybatis.plugin.PageView;
import com.javabase.entity.SysUsers;
import com.javabase.entity.SysLogs;
import com.javabase.base.util.Common;

import com.test.entity.NonoUser;
import com.test.service.NonoUserService;

/**
 * 
 * Controller
 *
 * @author bruce
 * 
 */
 
@Controller
@RequestMapping("/background/nonoUser/")
public class  NonoUserController extends BaseController {

	private final static Logger logger= Logger.getLogger(NonoUserController.class);
	
	// Servrice start
	@Autowired
	private NonoUserService  nonoUserService; 
    
    private SysUsers sysUsers;

	@RequestMapping("find")
	public String find(Model model, NonoUser nonoUser, String pageNow,String pageSize ) {
		PageView pageView = super.findPage(pageNow, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("t", nonoUser);
		pageView = nonoUserService.findPage(pageView, map);
		model.addAttribute("pageView", pageView);
		return "/background/nonoUser/list";
	}
	
	@RequestMapping("findByName")
	public void findByName(Model model, String objName ) {
		String data = null;
		try {
			NonoUser nonoUser = nonoUserService.findByName(objName);
			if (nonoUser != null) {
				data = "({msg:'Y',content:'按需求填写!'})";
			}else {
				data = "({msg:'N',content:'按需求填写!'})";
			}
			//返回.
			ajaxJson(data);
		} catch (Exception e) {
			logger.info("查找出错!"+e.getLocalizedMessage());
		}
	}
	
	@RequestMapping("findByProps")
	public void findByProps(Model model, NonoUser nonoUser) {
		String data = null;
		try {
			NonoUser object = nonoUserService.findByProps(nonoUser);
			if (object != null) {
				data = "({msg:'Y',content:'按需求填写!'})";
			}else {
				data = "({msg:'N',content:'按需求填写!'})";
			}
			//返回.
			ajaxJson(data);
		} catch (Exception e) {
			logger.info("查找出错!"+e.getLocalizedMessage());
		}
	}
	
    @RequestMapping("addUI")
    public String addUI() {
        return "/background/nonoUser/add";
    }
	
	@RequestMapping("addOne")
	public String addOne(Model model, NonoUser nonoUser) {
		nonoUserService.addOne(nonoUser);
		return "redirect:find.html";
	}
	
	@RequestMapping("findById")
	public String findById(Model model, String objId, int type) {
    	NonoUser nonoUser =nonoUserService.findById(objId);
    	model.addAttribute("object", nonoUser);
    	model.addAttribute("objId", objId);
    	if (type == 1) {
            return "/background/nonoUser/edit";
        } else {
            return "/background/nonoUser/show";
        }
	}
	
	@RequestMapping("deleteById")
	public void deleteById(Model model, String objId) {
		String data = null;
        try {
            int count = nonoUserService.deleteById(objId);
            if (count >0 ) {
                data = "({msg:'Y',content:'删除成功!'})";
            }else {
                data = "({msg:'N',content:'删除失败!'})";
            }
            //返回.
            ajaxJson(data);
        } catch (Exception e) {
            logger.info("查找出错!"+e.getLocalizedMessage());
        }
	}
	
	@RequestMapping("updateById")
	public String updateById(Model model, NonoUser nonoUser) {
		nonoUserService.updateOne(nonoUser);
		return "redirect:find.html";
	}
	
	public SysUsers getSysUsers(){
        if (sysUsers==null) {
            sysUsers = (SysUsers) request.getSession().getAttribute("userSession");
        }
        return sysUsers;
    }
    
    /**
     * 记录日志
     * @param tag:添加;修改;删除...
     */
    public void noteOperator(String tag){
        //记录日志
        SysLogs sysLogs = new SysLogs(); 
        SysUsers tUser = getSysUsers();
        sysLogs.setSysUserId(tUser.getSysUserId()+"");
        sysLogs.setSysUserName(tUser.getSysUserName());
        sysLogs.setModule("根据业务添加");
        sysLogs.setAction("根据业务添加——");
        sysLogs.setUserIp(Common.toIpAddr(request));
        noteOperator(sysLogs);
    }
}
