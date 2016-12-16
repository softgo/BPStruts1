package com.javabase.code.gengerate.mian;

import com.javabase.code.gengerate.def.FtlDef;
import com.javabase.code.gengerate.factory.CodeGenerateFactory;

/**
 * 代码生成工具.
 * 
 * @author bruce
 *
 */

public class CodeProductorUtil {
	
	/** 
	 * test it . 
	 * @param args  
	 */
	public static void main(String[] args) {
		
		String tableName = "nono_limit_product";
	    
		String codeName = "NN产品监控管理";
	    
	    String codePrefix = "NN产品监控列表";
	    
	    String entityPackage = "test\\"; //如果是目录就用"\\",否则就不用.
	    
	    CodeGenerateFactory.codeGenerate(tableName, codeName, entityPackage, FtlDef.KEY_TYPE_AUTO);
	    
	    //CodeGenerateFactory.codeGenerate(tableName, codeName, entityPackage, FtlDef.KEY_TYPE_MAN);
	    
	    CodeGenerateFactory.addMenus(tableName,codeName,codePrefix);
	    
	}
}
