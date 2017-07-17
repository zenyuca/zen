package club.zenyuca.common.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.zenyuca.common.pojo.Menu;
import club.zenyuca.common.mapper.MenuMapper;
import club.zenyuca.common.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public Integer insert(Menu model) {
		model.setCreateTime(new Date());
		return this.menuMapper.insert(model);
	}

	@Override
	public boolean delete(Integer modelPK) {
		return this.menuMapper.delete(modelPK) == 1;
	}

	@Override
	public Menu load(Menu model) {
		return this.menuMapper.load(model);
	}

	@Override
	public boolean update(Menu model) {
		return this.menuMapper.update(model) == 1;
	}

	@Override
	public int countAll() {
		return this.menuMapper.countAll();
	}

	@Override
	public List<Menu> findAll(Menu model) {
		return this.menuMapper.findAll(model);
	}

	@Override
	public List<Menu> listPage(Menu model) {
		return this.menuMapper.listPage(model);
	}

	@Override
	public Menu loadByPK(Integer modelPK) {
		return this.menuMapper.loadByPK(modelPK);
	}

	@Override
	public boolean insertORupdate(Menu model) {
		Menu dbBean = this.loadByPK(model.getMenuSeq());
		if (dbBean == null) {
			return this.insert(model) == 1;
		} else {
			return this.update(model);
		}
	}

	@Override
	public List<Menu> findParent(int id) {
		return this.menuMapper.findParent(id);
	}

}