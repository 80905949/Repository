package com.sise.internsystem.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.sise.internsystem.base.BaseAction;
import com.sise.internsystem.entity.Train;
import com.sise.internsystem.util.QueryHelper;

@Controller
@Scope("prototype")
public class TrainAction extends BaseAction<Train> {
	
	/** 列表 */
	public String list() throws Exception {
		new QueryHelper(Train.class, "u").preparePageBean(trainService, pageNum, 5);
		return "list";
	}
	
	/** 列表 */
	public String infos() throws Exception {
		new QueryHelper(Train.class, "u").preparePageBean(trainService, pageNum, 5);
		return "infos";
	}

	/** 删除 */
	public String delete() throws Exception {
		trainService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		return "saveUI";
	}

	/** 添加 */
	public String add() throws Exception {
		trainService.save(model);
		return "toList";
	}
	
	
	public String editUI() throws Exception {
		Train role = trainService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		return "editUI";
	}
	
	
	
	public String edit() throws Exception {
		Train role = trainService.getById(model.getId());
		role.setDriver(model.getDriver());
		role.setInfos(model.getInfos());
		role.setName(model.getName());
		role.setNo(model.getNo());
        trainService.update(role);
		return "toList";
	}

}
