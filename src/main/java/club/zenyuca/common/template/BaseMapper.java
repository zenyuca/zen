package club.zenyuca.common.template;

import java.util.List;

public interface BaseMapper<T, PK extends java.io.Serializable> {
	
	/**
	 * 如果需要的在插入数据的时候将对应行的id插入到Bean当中
	 * 那么需要在MyBatis里配置如下：
	 * <insert id="insert" useGeneratedKeys="true" keyColumn="PRODUCT_SEQ" keyProperty="productSeq" parameterType="com.bingbee.card.beans.seller.MerchantProduct">
	 * 
	 * <br><br>作者： caoyu
	 * <br>时间： 2015年9月2日 上午8:32:35
	 * @param modelPK		返回影响的行数
	 * @return
	 */
	PK insert(T model);
	
	int delete(PK modelPK);
	
	T load(T model);
	
	int update(T model);
	
	int countAll();
	
	List<T> findAll(T model);
	
	List<T> listPage(T model);
	
	T loadByPK(PK modelPK);
	
	List<T> loadByFK(PK modelFK);
	
	/**
	 * 根据提供的主键集合删除对应的数据
	 * 
	 * <br><br>作者： caoyu
	 * <br>时间： 2015年8月31日 下午5:29:40
	 * @param ids
	 */
	@SuppressWarnings("unchecked")
	public void deleteByPKs(PK... pks);
	/**
	 * 根据指定的主键集合来查询对应的一组数据
	 * 
	 * <br><br>作者： caoyu
	 * <br>时间： 2015年9月1日 上午9:34:52
	 * @param pks
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByPKs(PK... pks);
	
	/**
	 * 批量插入集合中的数据
	 * 
	 * <br><br>作者： caoyu
	 * <br>时间： 2015年9月24日 下午4:38:13
	 * @param modelList
	 */
	public void insertFromList(List<T> modelList);
}
