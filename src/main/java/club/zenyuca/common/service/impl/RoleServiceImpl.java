package club.zenyuca.common.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.zenyuca.common.pojo.Role;
import club.zenyuca.common.mapper.RoleMapper;
import club.zenyuca.common.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
  @Autowired
  private RoleMapper roleMapper;

  @Override
  public Integer insert(Role model) {
    model.setCreateTime(new Date());
    return this.roleMapper.insert(model);
  }

  @Override
  public boolean delete(Integer modelPK) {
    return this.roleMapper.delete(modelPK) == 1;
  }

  @Override
  public Role load(Role model) {
    return this.roleMapper.load(model);
  }

  @Override
  public boolean update(Role model) {
    return this.roleMapper.update(model) == 1;
  }

  @Override
  public int countAll() {
    return this.roleMapper.countAll();
  }

  @Override
  public List<Role> findAll(Role model) {
    return this.roleMapper.findAll(model);
  }

  @Override
  public List<Role> listPage(Role model) {
    return this.roleMapper.listPage(model);
  }

  @Override
  public Role loadByPK(Integer modelPK) {
    return this.roleMapper.loadByPK(modelPK);
  }

  @Override
  public boolean insertORupdate(Role model) {
    Role dbBean = this.loadByPK(model.getRoleSeq());
    if (dbBean == null) {
      return this.insert(model) == 1;
    } else {
      return this.update(model);
    }
  }

}