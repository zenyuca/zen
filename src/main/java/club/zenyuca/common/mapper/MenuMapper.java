package club.zenyuca.common.mapper;

import java.util.List;

import club.zenyuca.common.template.BaseMapper;
import club.zenyuca.common.pojo.Menu;

public interface MenuMapper extends BaseMapper<Menu, Integer> {
	public List<Menu> findParent(int id);
}