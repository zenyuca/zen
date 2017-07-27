package club.zenyuca.common.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import club.zenyuca.common.config.Const;
import club.zenyuca.common.pojo.Menu;
import club.zenyuca.common.pojo.User;
import club.zenyuca.common.service.MenuService;
import club.zenyuca.common.service.UserService;
import club.zenyuca.common.template.BaseController;
import club.zenyuca.common.util.RightsHelper;
import club.zenyuca.common.util.fastjsonx.JSONUtil;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/api/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "login.json", method = RequestMethod.POST)
	public void login(User user) {
		User dbUser = this.userService.load(user);
		JSONObject jsonObject = new JSONObject();
		if (dbUser != null) {
			this.setSessionObj(Const.SESSION_USER, dbUser);
			List<Menu> list = this.loadRight();
			
			JSONObject jsonObject2 = new JSONObject();
			jsonObject2.put("menuList", JSONUtil.toJSON(list, false));
			jsonObject2.put("user", JSONUtil.toJSON(dbUser, true, "userLoginname", "userLoginpass"));
			jsonObject.put(Const.JSON_DATA, jsonObject2);
			jsonObject.put(Const.JSON_STATUS, Const.ResponseCode.SUCCESS.getCode());
		} else {
			jsonObject.put(Const.JSON_MSG, Const.ResponseCode.LOGIN_ERROR.getDesc());
			jsonObject.put(Const.JSON_STATUS, Const.ResponseCode.LOGIN_ERROR.getCode());
		}
		this.render(jsonObject.toJSONString());
	}
	
	@RequestMapping(value = "logout.json", method = RequestMethod.POST)
	public void logout(User user) {
		User dbUser = this.userService.load(user);
		JSONObject jsonObject = new JSONObject();
		if (dbUser != null) {
			this.removeSession(Const.SESSION_USER);
			jsonObject.put(Const.JSON_MSG, "登出成功");
			jsonObject.put(Const.JSON_STATUS, Const.ResponseCode.SUCCESS.getCode());
		} else {
			jsonObject.put(Const.JSON_MSG, Const.ResponseCode.LOGOUT_ERROR.getDesc());
			jsonObject.put(Const.JSON_STATUS, Const.ResponseCode.LOGOUT_ERROR.getCode());
		}
		this.render(jsonObject.toJSONString());
	}

	public List<Menu> loadRight() {
		User user = (User) this.getSessionObj(Const.SESSION_USER);// 得到用户SESSION
		String rights = user.getRole().getRoleRights();// 得到角色权限

		List<Menu> listRoot = this.menuService.findAll(null);// 得到所有菜单

		List<Menu> listRights = new ArrayList<Menu>();// 定义父节点list 存储该账户具备的权限菜单
		for (Menu menu : listRoot) {
			boolean isHasMenu = RightsHelper.testRights(rights, menu.getMenuSeq());
			if (isHasMenu) {
				listRights.add(menu);
			}
		}
		
		return listRights;
	}
}
