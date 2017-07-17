package club.zenyuca.common.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.zenyuca.common.pojo.Action;
import club.zenyuca.common.mapper.ActionMapper;
import club.zenyuca.common.service.ActionService;

@Service
public class ActionServiceImpl implements ActionService {
	@Autowired
	private ActionMapper actionMapper;

	@Override
	public Integer insert(Action model) {
		model.setCreateTime(new Date());
		return this.actionMapper.insert(model);
	}

	@Override
	public boolean delete(Integer modelPK) {
		return this.actionMapper.delete(modelPK) == 1;
	}

	@Override
	public Action load(Action model) {
		return this.actionMapper.load(model);
	}

	@Override
	public boolean update(Action model) {
		return this.actionMapper.update(model) == 1;
	}

	@Override
	public int countAll() {
		return this.actionMapper.countAll();
	}

	@Override
	public List<Action> findAll(Action model) {
		return this.actionMapper.findAll(model);
	}

	@Override
	public List<Action> listPage(Action model) {
		return this.actionMapper.listPage(model);
	}

	@Override
	public Action loadByPK(Integer modelPK) {
		return this.actionMapper.loadByPK(modelPK);
	}

	@Override
	public boolean insertORupdate(Action model) {
		Action dbBean = this.loadByPK(model.getActionSeq());
		if (dbBean == null) {
			return this.insert(model) == 1;
		} else {
			return this.update(model);
		}
	}

	@Override
	public List<Action> findByUrl(String actionUrl) {
		return this.actionMapper.findByUrl(actionUrl);
	}
	
}