package com.sise.internsystem.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.sise.internsystem.base.BaseAction;
import com.sise.internsystem.entity.Train;
import com.sise.internsystem.entity.Trainpath;
import com.sise.internsystem.util.QueryHelper;

@Controller
@Scope("prototype")
public class TrainpathAction extends BaseAction<Trainpath> {
	
	/** 列表 */
	public String list() throws Exception {
		new QueryHelper(Trainpath.class, "u").preparePageBean(trainpathService, pageNum, 10);
		return "list";
	}
	
	/** 列表 */
	public String infos() throws Exception {
		new QueryHelper(Trainpath.class, "u").preparePageBean(trainpathService, pageNum, 5);
		return "infos";
	}

	/** 删除 */
	public String delete() throws Exception {
		trainpathService.delete(model.getId());
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
		String date = ServletActionContext.getRequest().getParameter("date");
		String format1 = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format1);
		Date retValue = sdf.parse(date);
		model.setDate(retValue);
		trainpathService.save(model);
		return "toList";
	}
	
	
	public String editUI() throws Exception {
		List<Train> plist =trainService.findAll();
		ActionContext.getContext().put("plist", plist);
		Trainpath role = trainpathService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		return "editUI";
	}
	
	
	
	public String edit() throws Exception {
		Trainpath role = trainpathService.getById(model.getId());
		role.setEndtime(model.getEndtime());
		role.setFromplace(model.getFromplace());
		role.setTimes(model.getTimes());
		role.setToplace(model.getToplace());
		role.setTrain(model.getTrain());
        trainpathService.update(role);
		return "toList";
	}

}
