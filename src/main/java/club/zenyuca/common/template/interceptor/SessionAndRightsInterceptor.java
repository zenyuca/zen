package club.zenyuca.common.template.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import club.zenyuca.common.service.MenuService;

/**
 * @author Administrator
 *管理端
 */
public class SessionAndRightsInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private MenuService menuService;
	
	/**
	 * 权限拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String path = request.getServletPath();
		HttpSession session = request.getSession();
		
//		if (path.matches((String)Config.NO_INTERCEPTOR_PATH)) {
//			return true;
//		} else {
//			User user = (User) session.getAttribute(Config.SESSION_USER);
//			if (user != null) {
//				Integer menuId = null;
//				List<Menu> subList = menuService.findAll(null);
//				for (Menu m : subList) {
//					String menuUrl = m.getMenuUrl();
//					if (Tools.notEmpty(menuUrl)) {
//						if (path.contains(menuUrl)) {
//							menuId = m.getMenuSeq();
//							break;
//						} else {
//							String[] arr = menuUrl.split("\\.");
//							String regex = "";
//							if (arr.length == 2) {
//								regex = "/?" + arr[0] + "(/.*)?." + arr[1];
//							} else {
//								regex = "/?" + menuUrl + "(/.*)?.html";
//							}
//							if (path.matches(regex)) {
//								menuId = m.getMenuSeq();
//								break;
//							}
//						}
//					}
//				}
//				if (menuId != null) {
//					String roleRights = user.getRole().getRoleRights();
//					if (RightsHelper.testRights(roleRights, menuId)) {
//						return true;
//					} else {
//						ModelAndView mv = new ModelAndView();
//						mv.setViewName("/common/no_rights");
//						throw new ModelAndViewDefiningException(mv);
//					}
//				}
//			} else {
//				ModelAndView mv = new ModelAndView();
//				mv.setViewName("/common/_login");
//				throw new ModelAndViewDefiningException(mv);
//			}
//		}
		return super.preHandle(request, response, handler);
	}

}
