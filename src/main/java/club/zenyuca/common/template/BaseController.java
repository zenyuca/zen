package club.zenyuca.common.template;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import club.zenyuca.common.config.CondOrderLimit;
import club.zenyuca.common.config.Const;
import club.zenyuca.common.pojo.Action;
import club.zenyuca.common.pojo.Rights;
import club.zenyuca.common.pojo.User;
import club.zenyuca.common.service.ActionService;
import club.zenyuca.common.service.RightsService;
import club.zenyuca.common.util.OperationSession;
import club.zenyuca.common.util.RightsHelper;
import club.zenyuca.common.util.Tools;
import club.zenyuca.common.util.editor.DateEditor;
import club.zenyuca.common.util.editor.DoubleEditor;
import club.zenyuca.common.util.editor.IntegerEditor;
import club.zenyuca.common.util.editor.LongEditor;
import club.zenyuca.common.util.paging.Page;

public class BaseController {
	@Autowired
	protected HttpServletRequest request;

	@Autowired
	protected RightsService rightsService;

	@Autowired
	protected ActionService actionService;

	protected HttpServletResponse response;
	protected Model model;
	protected ModelAndView mv;
	protected CondOrderLimit col;
	protected Page paper;

	@ModelAttribute
	public void init(HttpServletRequest request, HttpServletResponse response, Model model, ModelAndView mv, Page paper) {
		this.request = request;
		this.response = response;
		this.model = model;
		this.mv = mv;
		this.paper = paper;
		buildCondOrderLimit();// 构造查询辅助类
	}

	// 初始化binder的回调函数. 默认以DateUtil中的日期格式设置DateEditor及允许Integer,Double的字符串为空.
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(int.class, new IntegerEditor());
		binder.registerCustomEditor(long.class, new LongEditor());
		binder.registerCustomEditor(double.class, new DoubleEditor());
		binder.registerCustomEditor(Date.class, new DateEditor());
	}

	private void buildCondOrderLimit() {
		col = new CondOrderLimit();
		col.setPaper(paper);
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			String[] parameterValues = request.getParameterValues(paramName);
			String paramValue = StringUtils.join(parameterValues, ",");
			if (Tools.notEmpty(paramValue)) {
				col.putCondition(paramName, paramValue);
			}
		}
	}

	// 销毁session
	public void removeSession(String sessionName) {
		OperationSession.remove(request, sessionName);
	}

	// 放置session对象
	public void setSessionObj(String name, Object obj) {
		OperationSession.putSession(request, name, obj);
	}

	// 得到session对象
	public Object getSessionObj(String name) {
		return OperationSession.getSession(request, name);
	}

	/**
	 * 不通过渲染 直接输出 文本/字符串/xml/JSON 等
	 * 
	 * @param response
	 * @param content
	 */
	public void render(Object obj) {
		response.reset();
		response.setContentType("text/plain;charset=UTF-8");
		try {
			response.getWriter().write(obj.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void renderJSON(Object object) {
		String jsonString = JSON.toJSONString(object);
		this.render(jsonString);
	}

	/**
	 * 输出 文本/字符串/xml/JSON 等
	 */
	public void toResposne(Object obj) {
		response.setContentType("text/plain;charset=UTF-8");
		try {
			response.getWriter().write(obj.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String toolbar(String url) {
		User user = (User) getSessionObj(Const.SESSION_USER);
		int roleSeq = user.getRole().getRoleSeq();

		StringBuilder toolbar = new StringBuilder();
		Rights rights = new Rights();
		rights.setRightsUrl(url);
		rights.setRightsRole(roleSeq);
		rights = rightsService.load(rights);
		List<Action> list = actionService.findByUrl(url);
		if (rights != null && rights.getRights() != null) {
			for (Action action : list) {
				if (RightsHelper.testRights(rights.getRights(), action.getActionSeq())) {
					toolbar.append("<button class='btn btn-sm " + action.getActionClass() + "' onclick='" + action.getActionFunc() + "'>" + "<i class='" + action.getActionIcon() + "'></i>" + action.getActionTitle() + "</button> ");
				}
			}
		}
		return toolbar.toString();
	}

	/**
	 * 用户登录进入验证
	 * 
	 * <br>
	 * <br>
	 * 作者： caoyu <br>
	 * 时间： 2015年9月17日 上午11:05:53
	 * 
	 * @return 未验证成功，那么程序终止，验证成功放回验证对象
	 * @throws Exception
	 */
	/*
	 * public PersonInfo personCheck() throws Exception { PersonInfo personInfo
	 * = (PersonInfo)this.getSessionObj(Config.SESSION_PERSON); if (personInfo
	 * == null) throw new IllegalAccessError("未登录用户入侵操作"); return personInfo; }
	 */

	/**
	 * 独立分页查询 当前页数
	 * 
	 * @param @param pagenum
	 * @param @return
	 * @return int
	 * @throws
	 * @author NIUBIN
	 * @date 2015年9月15日
	 */
	public int getPage(String pagenum) {
		String page = request.getParameter(pagenum);
		if (StringUtils.isBlank(page) || page.equals("0")) {
			return 1;
		} else {
			return Integer.parseInt(page);
		}
	}

	/**
	 * 独立分页查询 每页条数
	 * 
	 * @param @param limitnum
	 * @param @return
	 * @return int
	 * @throws
	 * @author NIUBIN
	 * @date 2015年9月15日
	 */
	public int getLimit(String limitnum) {
		String limit = request.getParameter(limitnum);
		if (StringUtils.isBlank(limit)) {
			return 10;
		} else {
			return Integer.parseInt(limit);
		}
	}

	// 得到session
	public HttpSession getSession() {
		return request.getSession();
	}

	/**
	 * 获得当前登录用户
	 * 
	 * @return
	 */
	public User getLoginUser() {
		User user = (User) this.getSession().getAttribute("user");
		return user;
	}
}
