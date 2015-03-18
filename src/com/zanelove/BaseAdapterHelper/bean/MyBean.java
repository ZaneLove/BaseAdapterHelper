package com.zanelove.BaseAdapterHelper.bean;

/**
 * 实体类
 * @author ZaneLove
 * 这个就不是通用的啦
 */
public class MyBean {
	public String img_url;
	public String user_name;
	public String time;
	public String content;
	public String from;
	public MyBean(String img_url, String user_name, String time, String content, String from) {
		this.img_url = img_url;
		this.user_name = user_name;
		this.time = time;
		this.content = content;
		this.from = from;
	}
}
