package com.sise.internsystem.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sise.internsystem.base.DaoSupportImpl;
import com.sise.internsystem.entity.Train;
import com.sise.internsystem.service.TrainService;

@Service
@Transactional 
public class TrainServiceImpl extends DaoSupportImpl<Train> implements TrainService {
	
}
