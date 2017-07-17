package club.zenyuca.common.service;

import java.util.List;

import club.zenyuca.common.template.BaseService;
import club.zenyuca.common.pojo.Menu;

public interface MenuService extends BaseService<Menu, Integer> {
	public List<Menu> findParent(int id);
}