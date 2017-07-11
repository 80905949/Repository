package com.sise.internsystem.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sise.internsystem.base.DaoSupportImpl;
import com.sise.internsystem.entity.Trainpath;
import com.sise.internsystem.service.TrainpathService;

@Service
@Transactional 
public class TrainpathServiceImpl extends DaoSupportImpl<Trainpath> implements TrainpathService {
	
}
