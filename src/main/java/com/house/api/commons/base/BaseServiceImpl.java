package com.house.api.commons.base;

import com.house.api.constant.ConstantType;
import com.house.util.UUIDUtil;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

public abstract class BaseServiceImpl<T extends BaseModel> implements BaseService<T> {

	private BaseMapper<T> baseMapper;

	@PostConstruct
	protected abstract void initBaseMapper();

	public void setBaseMapper(BaseMapper<T> baseMapper) {
		this.baseMapper = baseMapper;
	}

	@Override
	public T getById(Long id) throws Exception {
		return baseMapper.getById(id);
	}

	@Override
	public Long getCount(T entity) throws Exception {
		return baseMapper.getCount(entity);
	}

	@Override
	public List<T> getList(PageVo<T> vo) throws Exception {
		return baseMapper.getList(vo);
	}

	@Override
	public void modify(T entity) throws Exception {
		entity.setCreatedOn(null);
		baseMapper.modify(entity);
	}

	@Override
	public void delete(Long id) throws Exception {
		baseMapper.delete(id);
	}

	@Override
	public void add(T entity) throws Exception {
        entity.setId(UUIDUtil.generateUniqueKey());
        entity.setCreatedOn(new Date());
		baseMapper.add(entity);
	}

	@Override
	public T getById(String id) throws Exception{
		return baseMapper.getById(id);
	}

	@Override
	public void delete(String id) throws Exception{
		baseMapper.delete(id);
	}
}
