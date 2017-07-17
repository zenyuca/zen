package club.zenyuca.common.template;

import java.util.List;

public interface BaseService<T, PK extends java.io.Serializable> {
	
	PK insert(T model);
	
	boolean delete(PK modelPK);
	
	T load(T model);
	
	boolean update(T model);
	
	int countAll();
	
	List<T> findAll(T model);
	
	List<T> listPage(T model);
	
	T loadByPK(PK modelPK);
	
	boolean insertORupdate(T model);
	
}
