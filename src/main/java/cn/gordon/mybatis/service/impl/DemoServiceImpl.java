package cn.gordon.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.gordon.mybatis.dao.DemoMapper;
import cn.gordon.mybatis.model.DemoEbo;
import cn.gordon.mybatis.service.DemoService;

@Service("demoService")
public class DemoServiceImpl extends BaseServiceImpl<DemoEbo> implements DemoService {
	
	private DemoMapper demoMapper;

	public DemoMapper getDemoMapper() {
		return demoMapper;
	}
	
	@Autowired
	public void setDemoMapper(DemoMapper demoMapper) {
	    super.setBaseMapper(demoMapper);
		this.demoMapper = demoMapper;
	}
	
}
