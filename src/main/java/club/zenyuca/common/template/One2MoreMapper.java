
package club.zenyuca.common.template;

import java.io.Serializable;
import java.util.List;

/**
 * 针对一对多的JavaBean对象而提供的持久层接口
 * 
 * <br><br>作者： caoyu
 * <br>时间： 2015年8月31日 下午5:23:45
 * <br>版本： 0.0.1
 */
public interface One2MoreMapper<T, FK extends Serializable> {
	/**
	 * 根据外键来查询同一类数据
	 * 
	 * <br><br>作者： caoyu
	 * <br>时间： 2015年8月31日 下午5:26:48
	 * @param pk
	 * @return
	 */
	public List<T> findByFK(FK fk);
	
	/**
	 * 根据提供的外键集合来查询同一类数据
	 * 
	 * <br><br>作者： caoyu
	 * <br>时间： 2015年8月31日 下午5:27:40
	 * @param pks
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByFKs(FK... fks);
	
	/**
	 * 有一类的一对多关系是主表一个字段，而从表两个字段来关联的
	 * 在这种情况中，另一个关联字段一般称之为type数据
	 * 在本系统中统一规定类型用与外键相同的数据类型来表示
	 * 所以此处这样写
	 * 
	 * <br><br>作者： caoyu
	 * <br>时间： 2015年9月1日 下午3:25:52
	 * @param t 此t对象多的一方，所以里面即包含了所有的关联字段，因此此处将之作为参数传入
	 * @return
	 */
	public List<T> findByFKAndType(T t);
}
