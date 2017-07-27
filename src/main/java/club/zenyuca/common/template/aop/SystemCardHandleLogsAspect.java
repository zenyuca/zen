//package com.bingbee.card.template.aop;
//
//import java.lang.reflect.Method;
//import java.util.Date;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.Signature;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.aop.ThrowsAdvice;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import com.bingbee.card.beans.atom.CardHandleLogs;
//import com.bingbee.card.beans.client.PersonInfo;
//import com.bingbee.card.beans.system.Role;
//import com.bingbee.card.beans.system.User;
//import com.bingbee.card.config.Config;
//import com.bingbee.card.mapper.atom.CardHandleLogsMapper;
//import com.bingbee.card.rule.PerSonQueryRule;
//import com.bingbee.card.template.annotation.LogDesc;
//
///**
// * @author lc
// * 
// * 卡券操作记录
// */
//@Component
//@Aspect
//public class SystemCardHandleLogsAspect implements ThrowsAdvice {
//	
//	public static final Log logger = LogFactory.getLog(SystemCardHandleLogsAspect.class);  
//
//	@Autowired
//	private CardHandleLogsMapper handleLogMapper;
//	
//	//环绕通知
//	@Around(value="execution(* com.bingbee.card.controller.seller.*.*(..)) ")
//	public Object doAround(ProceedingJoinPoint point) throws Throwable 
//	{
//		Object retVal = point.proceed();
//		Class<? extends Object> clazz = point.getTarget().getClass();
//		Method[] methods = clazz.getDeclaredMethods();
//		if (methods != null) {
//			for (Method method : methods) {
//				if (method.isAnnotationPresent(LogDesc.class)) {
////					LogDesc logDesc = method.getAnnotation(LogDesc.class);
//					String methodName = point.getSignature().getName();
//					if (method.getName().equals(methodName)) {
//						Object[] args = point.getArgs();
//						methodName = clazz.getName()+"."+method.getName();
//						doAroundLog(methodName,args,retVal);
//					}
//				}
//			}
//		}
//		return retVal;
//	}
//	private void doAroundLog(String methodName,Object[] args,Object retVal)
//	{
//		String description="调用方法："+methodName+"  参数：";
//		String argsString="";
//		for(int i=0; i<args.length; i++){
//			argsString+=args[i]+",";
//		}
//		argsString+="&&"+retVal;
//		
//		CardHandleLogs logs=new CardHandleLogs();
//		
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//		HttpSession session = request.getSession();
//		Object roleObj=null;
//		if(session.getAttribute(Config.SESSION_PERSON_RULE)!=null)
//			roleObj = ((PerSonQueryRule)session.getAttribute(Config.SESSION_PERSON_RULE)).getBaseInfo();//当前登录用户
//		if(roleObj != null && roleObj instanceof PersonInfo){
//			PersonInfo person=(PersonInfo)roleObj;
//			logs.setUserName(person.getPhone());
//			logs.setHandleUserSeq(person.getPersonSeq());
//			logs.setHandleUserType(Role.ROLE_TYPE_PERSON);
//		}else{
//			roleObj = session.getAttribute(Config.SESSION_USER);
//			if(roleObj!=null && roleObj instanceof User)
//			{
//				User user=(User)roleObj;
//				logs.setUserName(user.getLoginName());
//				logs.setHandleUserSeq(user.getUserSeq());
//				logs.setHandleUserType(user.getRoleType());
//			}
//		}
//		logs.setDescription(description+argsString);
//		logs.setLogTime(new Date());
//		logs.setMethodArgs(argsString);
//		logs.setMethodName(methodName);
//		logs.setHandleType(0);
//		
//		handleLogMapper.insert(logs);//插入数据
//	}
//	
//	
//	// 异常通知
//	@AfterThrowing(value = "execution(* com.bingbee.*.*.*.*(..))", throwing = "ex")
//	public void afterThrowing(JoinPoint jp,Throwable ex) {
//		StringBuffer buff=new StringBuffer();
//		Object target=jp.getTarget();
//		Object targetThis=jp.getThis();
//		Signature sig=jp.getSignature();
//		Object[] args=jp.getArgs();
//		for(Object o:args){  
//			buff.append(o.toString()+",");  
//	    }  
//		logger.info(ex);
//		CardHandleLogs logs=new CardHandleLogs();
//		logs.setDescription(ex.toString());
//		logs.setLogTime(new Date());
//		logs.setMethodArgs("异常详细信息:"+targetThis.toString());
//		logs.setMethodName("errorlog:"+target.getClass().getName()+"-->"+sig.getName()+"-->"+buff.toString());
//		logs.setUserName("system");
//		logs.setHandleType(0);
//		handleLogMapper.insert(logs);//插入数据
//	}
//}
