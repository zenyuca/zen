package club.zenyuca.common.service;

import java.util.List;

import club.zenyuca.common.template.BaseService;
import club.zenyuca.common.pojo.Action;

public interface ActionService extends BaseService<Action, Integer> {
	public List<Action> findByUrl(String actionUrl);
}