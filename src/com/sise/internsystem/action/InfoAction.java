package com.sise.internsystem.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.sise.internsystem.base.BaseAction;
import com.sise.internsystem.entity.Infos;
import com.sise.internsystem.entity.Train;
import com.sise.internsystem.util.QueryHelper;

@Controller
@Scope("prototype")
public class InfoAction extends BaseAction<Infos> {
	
	/** 列表 */
	public String list() throws Exception {
		new QueryHelper(Infos.class, "u").preparePageBean(infoService, pageNum, 10);
		return "list";
	}
	
	/** 列表 */
	public String info() throws Exception {
		new QueryHelper(Infos.class, "u").preparePageBean(infoService, pageNum, 10);
		return "info";
	}

	/** 删除 */
	public String delete() throws Exception {
		infoService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		List<Train> plist =trainService.findAll();
		ActionContext.getContext().put("plist", plist);
		return "saveUI";
	}

	/** 添加 */
	public String add() throws Exception {
		infoService.save(model);
		return "toList";
	}
	
	
	public String editUI() throws Exception {
		List<Train> plist =trainService.findAll();
		ActionContext.getContext().put("plist", plist);
		Infos role = infoService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		return "editUI";
	}
	
	
	
	public String edit() throws Exception {
		Infos role = infoService.getById(model.getId());
		role.setNo(model.getNo());
		role.setInfos(model.getInfos());
		role.setTitle(model.getTitle());
        infoService.update(role);
		return "toList";
	}

}
