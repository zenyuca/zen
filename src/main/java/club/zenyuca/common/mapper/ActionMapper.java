package club.zenyuca.common.mapper;

import java.util.List;

import club.zenyuca.common.template.BaseMapper;
import club.zenyuca.common.pojo.Action;

public interface ActionMapper extends BaseMapper<Action, Integer> {
	public List<Action> findByUrl(String actionUrl);
}