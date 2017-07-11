package com.sise.internsystem.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sise.internsystem.base.DaoSupportImpl;
import com.sise.internsystem.entity.Infos;
import com.sise.internsystem.service.InfoService;

@Service
@Transactional 
public class InfoServiceImpl extends DaoSupportImpl<Infos> implements InfoService {
	
}
