package club.zenyuca.common.service;

import club.zenyuca.common.template.BaseService;
import club.zenyuca.common.pojo.Rights;

public interface RightsService extends BaseService<Rights, Integer> {
	public int del(Rights rights);
}