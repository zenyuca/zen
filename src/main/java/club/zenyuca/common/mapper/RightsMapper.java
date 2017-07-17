package club.zenyuca.common.mapper;

import club.zenyuca.common.template.BaseMapper;
import club.zenyuca.common.pojo.Rights;

public interface RightsMapper extends BaseMapper<Rights, Integer> {
	public int del(Rights rights);
}