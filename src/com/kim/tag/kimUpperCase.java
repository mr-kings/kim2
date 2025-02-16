package com.kim.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
/**
 * 转大写标签
 * 类名: KimUpperCase.java
 * 创建人: kim 
 * 创建时间：2016年5月31日 下午12:57:21 
 * @version 1.0.0
 */
public class kimUpperCase extends BodyTagSupport{
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * 	TagSupport和BodyTagSupport它的区别在于
	 *  
	 *  TagSupport是没有办法去获取标签体的内容，
	 *  	1:是将数据放在作用域中，进行返回
	 *  BodyTagSupport:它可以在类获取标签体的内容。
	 *   	1:是将数据放在作用域中，进行返回
	 *      2:通过输出流 this.getPreviousOut()进行数据的返回
	 *      3:获取标签体的内容: this.getBodyContent()
	 *      
	 * */
	//次数
	private  int count = 3;
	
	@Override //IteratorTag类
	public int doAfterBody() throws JspException {
		
		if(count>0){
			try {
				//获取标题的内容
				String content = this.getBodyContent().getString();
				JspWriter out = this.getPreviousOut();
				out.print(content.toUpperCase());
				count--;
				//清楚缓存的标签的主题内容
				bodyContent.clearBody();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return EVAL_BODY_AGAIN;
		}else{
			count=1;
			return SKIP_BODY;
		}
	}

	@Override
	public void release() {
	}

	public void setCount(int count) {
		this.count = count;
	}
}
