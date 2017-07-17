package club.zenyuca.common.service;

import java.util.List;

import club.zenyuca.common.enums.RoleEnum;
import club.zenyuca.common.pojo.User;
import club.zenyuca.common.template.BaseService;

public interface UserService extends BaseService<User, Integer> {
	public List<User> findByRole(RoleEnum roleEnum);
}