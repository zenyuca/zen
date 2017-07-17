package club.zenyuca.common.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.zenyuca.common.pojo.Property;
import club.zenyuca.common.mapper.PropertyMapper;
import club.zenyuca.common.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {
  @Autowired
  private PropertyMapper propertyMapper;

  @Override
  public Integer insert(Property model) {
    model.setCreateTime(new Date());
    return this.propertyMapper.insert(model);
  }

  @Override
  public boolean delete(Integer modelPK) {
    return this.propertyMapper.delete(modelPK) == 1;
  }

  @Override
  public Property load(Property model) {
    return this.propertyMapper.load(model);
  }

  @Override
  public boolean update(Property model) {
    return this.propertyMapper.update(model) == 1;
  }

  @Override
  public int countAll() {
    return this.propertyMapper.countAll();
  }

  @Override
  public List<Property> findAll(Property model) {
    return this.propertyMapper.findAll(model);
  }

  @Override
  public List<Property> listPage(Property model) {
    return this.propertyMapper.listPage(model);
  }

  @Override
  public Property loadByPK(Integer modelPK) {
    return this.propertyMapper.loadByPK(modelPK);
  }

  @Override
  public boolean insertORupdate(Property model) {
    Property dbBean = this.loadByPK(model.getPtySeq());
    if (dbBean == null) {
      return this.insert(model) == 1;
    } else {
      return this.update(model);
    }
  }

}