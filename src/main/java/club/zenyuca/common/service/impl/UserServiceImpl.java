package club.zenyuca.common.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.zenyuca.common.enums.RoleEnum;
import club.zenyuca.common.mapper.RoleMapper;
import club.zenyuca.common.mapper.UserMapper;
import club.zenyuca.common.pojo.Role;
import club.zenyuca.common.pojo.User;
import club.zenyuca.common.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public Integer insert(User model) {
		model.setCreateTime(new Date());
		return this.userMapper.insert(model);
	}

	@Override
	public boolean delete(Integer modelPK) {
		return this.userMapper.delete(modelPK) == 1;
	}

	@Override
	public User load(User model) {
		model = this.userMapper.load(model);
		if (model != null) {
			Role role = this.roleMapper.loadByPK(model.getUserRoleSeq());
			model.setRole(role);
		}
		return model;
	}

	@Override
	public boolean update(User model) {
		return this.userMapper.update(model) == 1;
	}

	@Override
	public int countAll() {
		return this.userMapper.countAll();
	}

	@Override
	public List<User> findAll(User model) {
		return this.userMapper.findAll(model);
	}

	@Override
	public List<User> listPage(User model) {
		return this.userMapper.listPage(model);
	}

	@Override
	public User loadByPK(Integer modelPK) {
		return this.userMapper.loadByPK(modelPK);
	}

	@Override
	public boolean insertORupdate(User model) {
		User dbBean = this.loadByPK(model.getUserSeq());
		if (dbBean == null) {
			return this.insert(model) == 1;
		} else {
			return this.update(model);
		}
	}

	@Override
	public List<User> findByRole(RoleEnum roleEnum) {
		Role role = this.roleMapper.findByRoleName(roleEnum.getName());
		List<User> list = this.userMapper.loadByFK(role.getRoleSeq());
		return list;
	}

}