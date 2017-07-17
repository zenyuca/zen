package club.zenyuca.common.mapper;

import club.zenyuca.common.template.BaseMapper;
import club.zenyuca.common.pojo.Role;

public interface RoleMapper extends BaseMapper<Role, Integer> {
	public Role findByRoleName(String roleName);
}