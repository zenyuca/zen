//package com.bingbee.card.template.aop;
//
//import java.util.Date;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.aop.ThrowsAdvice;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import com.bingbee.card.beans.atom.LoginLogs;
//import com.bingbee.card.beans.system.User;
//import com.bingbee.card.config.Config;
//import com.bingbee.card.mapper.atom.LoginLogsMapper;
//
//
///**
// * @author lc 
// * 记录用户登录日志
// */
//@Component
//@Aspect
//public class SystemLoginLogsAspect implements ThrowsAdvice {
//	public static final Log logger = LogFactory.getLog(SystemLoginLogsAspect.class);  
//	
//	@Autowired
//	private LoginLogsMapper loginLogsMapper;
//
//	
//	// 获取返回后通知
//	@AfterReturning(value = "execution(* com.bingbee.card.controller.system.LoginController.*login*(..))", returning = "retVal")
//	public void doAfterReturning(JoinPoint jp, Object retVal) {
//		dolog(jp,retVal);
//	}
//	
//	// 异常通知
//	@AfterThrowing(value = "execution(* com.bingbee.card.controller.system.LoginController.*(..))", throwing = "ex")
//	public void afterThrowing(Throwable ex) {
//		// logger.info("抛出异常通知" + ex);
//	}
//
//	public void dolog(JoinPoint jp, Object retVal) {
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//		HttpSession session = request.getSession();
//		String ip = request.getRemoteAddr();
//		// 读取session中的用户
//		User user = (User) session.getAttribute(Config.SESSION_USER);
//		if (user != null) {
//			try {
//				String name = user.getLoginName();
//				LoginLogs log = new LoginLogs();
//				log.setIp(ip);
//				log.setUserSeq(user.getUserSeq());
//				log.setUserName(name);
//				log.setLoginTime(new Date());
//
//				// 保存数据库
//				loginLogsMapper.insert(log);
//
//			} catch (Exception e) {
//				// 记录本地异常日志
//				logger.error("异常信息:"+ e.getMessage());
//			}
//
//		} else {
//			logger.info("ip:"+ ip +" 登录错误");
//		}
//	}
//}
