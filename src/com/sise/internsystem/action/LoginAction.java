package com.sise.internsystem.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.sise.internsystem.base.BaseAction;
import com.sise.internsystem.entity.User;

@Controller
@Scope("prototype")
public class LoginAction extends BaseAction<User> {
	public String login() throws Exception {
		String no= ServletActionContext.getRequest().getParameter("no");
		String password= ServletActionContext.getRequest().getParameter("password");
		String type=ServletActionContext.getRequest().getParameter("type");
		HttpServletResponse response=ServletActionContext.getResponse(); 
		response.setCharacterEncoding("utf-8"); 
		if (type.equals("admin")) {
			User  user = userService.findByLoginNameAndPassword(no, password,type);
			if (user!=null) {
				ServletActionContext.getRequest().getSession().setAttribute("lname",user.getName() );
				ActionContext.getContext().getSession().put("user", user);
				return "admin";
			}
		}
		if (type.equals("teacher")) {
			User  user = userService.findByLoginNameAndPassword(no, password,type);
			if (user!=null) {
				ServletActionContext.getRequest().getSession().setAttribute("lname",user.getName() );
				ActionContext.getContext().getSession().put("user", user);
				return "teacher";
			}
		}
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(        "<script>alert('ÕË»§Ãû»òÃÜÂë´íÎó');</script>");
		response.getWriter().flush();
		return "loginUI";
	}
	/**µÇÂ¼**/
	public String loginUI() throws Exception {
		return "loginUI";
	}
	public String head() throws Exception {
		return "head";
	}
	public String aleft() throws Exception {
		return "aleft";
	}
	public String tleft() throws Exception {
		return "tleft";
	}
	public String xyleft() throws Exception {
		return "xyleft";
	}
	public String sleft() throws Exception {
		return "sleft";
	}
	public String logout() throws Exception {
		ActionContext.getContext().getSession().remove("user");
		return "loginUI";
	}
}
