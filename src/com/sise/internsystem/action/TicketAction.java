package com.sise.internsystem.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.sise.internsystem.base.BaseAction;
import com.sise.internsystem.entity.Ticket;
import com.sise.internsystem.util.QueryHelper;

@Controller
@Scope("prototype")
public class TicketAction extends BaseAction<Ticket> {
	
	/** 列表 */
	public String list() throws Exception {
		new QueryHelper(Ticket.class, "u").preparePageBean(ticketService, pageNum, 10);
		return "list";
	}
	
	/** 列表 */
	public String infos() throws Exception {
		new QueryHelper(Ticket.class, "u").preparePageBean(ticketService, pageNum, 10);
		return "infos";
	}

	/** 删除 */
	public String delete() throws Exception {
		ticketService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		return "saveUI";
	}

	/** 添加 */
	public String add() throws Exception {
		ticketService.save(model);
		return "toList";
	}
	
	
	public String editUI() throws Exception {
		Ticket role = ticketService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		return "editUI";
	}
	
	
	
	public String edit() throws Exception {
		Ticket role = ticketService.getById(model.getId());
		role.setInfos(model.getInfos());
		role.setName(model.getName());
		role.setPrice(model.getPrice());
        ticketService.update(role);
		return "toList";
	}

}
