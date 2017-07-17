package club.zenyuca.common.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.zenyuca.common.pojo.Rights;
import club.zenyuca.common.mapper.RightsMapper;
import club.zenyuca.common.service.RightsService;

@Service
public class RightsServiceImpl implements RightsService {
	@Autowired
	private RightsMapper rightsMapper;

	@Override
	public Integer insert(Rights model) {
		model.setCreateTime(new Date());
		return this.rightsMapper.insert(model);
	}

	@Override
	public boolean delete(Integer modelPK) {
		return this.rightsMapper.delete(modelPK) == 1;
	}

	@Override
	public Rights load(Rights model) {
		return this.rightsMapper.load(model);
	}

	@Override
	public boolean update(Rights model) {
		return this.rightsMapper.update(model) == 1;
	}

	@Override
	public int countAll() {
		return this.rightsMapper.countAll();
	}

	@Override
	public List<Rights> findAll(Rights model) {
		return this.rightsMapper.findAll(model);
	}

	@Override
	public List<Rights> listPage(Rights model) {
		return this.rightsMapper.listPage(model);
	}

	@Override
	public Rights loadByPK(Integer modelPK) {
		return this.rightsMapper.loadByPK(modelPK);
	}

	@Override
	public boolean insertORupdate(Rights model) {
		Rights dbBean = this.loadByPK(model.getRightsSeq());
		if (dbBean == null) {
			return this.insert(model) == 1;
		} else {
			return this.update(model);
		}
	}

	@Override
	public int del(Rights rights) {
		return this.rightsMapper.del(rights);
	}

}