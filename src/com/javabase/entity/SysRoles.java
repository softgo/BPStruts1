package com.javabase.entity;

import java.util.*;
import java.io.*;

/**
 * 实体bean
 * 
 * @author bruce
 *
 */

@SuppressWarnings("serial")
public class SysRoles implements Serializable {

	private final long serialVersionUID = 1L;
	
	private Set<SysSources> resources = new HashSet<SysSources>(0);
	
}
