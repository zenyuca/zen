package club.zenyuca.common.template.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日志描述标记
 * <br><br>作者： caoyu
 * <br>时间： 2015年9月14日 下午1:59:11
 * <br>版本： 0.0.1
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogDesc {
	public String value() default "";
}
