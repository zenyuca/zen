package club.zenyuca.common.template;

import java.util.List;

public interface BaseUserService<U, T, PK extends java.io.Serializable> {
	
	PK insert(U user, T model);
	
	boolean delete(U user, PK modelPK);
	
	T load(U user, T model);
	
	boolean update(U user, T model);
	
	int countAll();
	
	List<T> findAll(U user, T model);
	
	List<T> listPage(U user, T model);
	
	T loadByPK(U user, PK modelPK);
	
	boolean insertORupdate(U user, T model);
	
}
