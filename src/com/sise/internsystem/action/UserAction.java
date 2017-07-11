package com.sise.internsystem.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.sise.internsystem.base.BaseAction;
import com.sise.internsystem.entity.User;
import com.sise.internsystem.util.QueryHelper;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	/**�鿴�б�*/
	public String list() throws Exception {
		new QueryHelper(User.class, "u").preparePageBean(userService, pageNum, 10);
		return "list";
	}

	/** ���*/
	public String saveUI() throws Exception {
		return "saveUI";
	}
	public String add() throws Exception {
		HttpServletResponse response=ServletActionContext.getResponse(); 
		response.setCharacterEncoding("utf-8"); 
		model.setPwd("123456");
		model.setRole("teacher");
		boolean  f= userService.checkNo(model.getName());
		if (f) {
			userService.save(model);
		}else{
			 response.setContentType("text/html;charset=utf-8");    
			 response.getWriter().write("<script>alert('�˻��Ѵ���');</script>");  
			 response.getWriter().write("<script> window.location='user_list.action' ;window.close();</script>");  
			 response.getWriter().flush(); 
		}
		return "toList";
	}

	public String editUI() throws Exception {
		User user = userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		return "editUI";
	}

	/** �޸�*/
	public String edit() throws Exception {
		User user = userService.getById(model.getId());
		user.setGender(model.getGender());
		user.setName(model.getName());
		user.setTel(model.getTel());
		userService.update(user);
		return "toList";
	}
	/**ɾ��*/
	public String delete() throws Exception {
		userService.delete(model.getId());
		return "toList";
	}
	
	
		
	
	
	
	
	
	
	
	
	
	
	


	/** ��ʼ������*/
	public String initPassword() throws Exception {
		User user = userService.getById(model.getId());
		user.setPwd("123456");

		userService.update(user);
		return "toList";
	}
	public String changeUI() throws Exception {
		User user= (User) ActionContext.getContext().getSession().get("user");
		ActionContext.getContext().getValueStack().push(user);
		return "changeUI";
	}
	/** �޸�*/
	public String change() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		user.setGender(model.getGender());
		user.setName(model.getName());
		user.setTel(model.getTel());
		userService.update(user);
		return "change";
	}
	public String pwdUI() throws Exception {
		return "pwdUI";
	}
	public String pwd() throws Exception {
		HttpServletResponse response=ServletActionContext.getResponse(); 
		response.setCharacterEncoding("utf-8"); 
		String pwd= ServletActionContext.getRequest().getParameter("password");
		User user= (User) ActionContext.getContext().getSession().get("user");
		user.setPwd(pwd);
		userService.update(user);
		response.setContentType("text/html;charset=utf-8");    
		response.getWriter().write(        "<script>alert('�޸ĳɹ�');</script>");  
		return "change";
	}
	
	public String search() throws Exception {
		String value= ServletActionContext.getRequest().getParameter("value");
		QueryHelper q=new QueryHelper(User.class, "u");
		if (value!=null) {
			q.addCondition(true, "u.name=?",value );
		}
		q.preparePageBean(userService, pageNum, 10);
		return "search";
	}


}
