package com.sise.internsystem.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sise.internsystem.service.InfoService;
import com.sise.internsystem.service.TicketService;
import com.sise.internsystem.service.TrainService;
import com.sise.internsystem.service.TrainpathService;
import com.sise.internsystem.service.UserService;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	// =============== ModelDriven鐨勬敮鎸�==================

	protected T model;

	public BaseAction() {
		try {
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public T getModel() {
		return model;
	}
	// ============== 分页用的参数 =============

	protected int pageNum = 1; // 当前页
	protected int pageSize = 10; // 每页显示多少条记录

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Resource
	protected UserService userService;
	@Resource
	protected InfoService infoService;
	@Resource
	protected TicketService ticketService;
	@Resource
	protected TrainService trainService;
	@Resource
	protected TrainpathService trainpathService;
}
