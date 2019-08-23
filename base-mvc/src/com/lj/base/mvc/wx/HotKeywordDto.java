/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.base.mvc.wx;

import java.io.Serializable;

/**
 * 类说明：搜索关键字。
 * 
 * <p>
 *   
 * @Company: 扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年11月21日
 */
public class HotKeywordDto  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	/** code */
	private String code;
	/** 关键字 */
	private String keyword;
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}
	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}
