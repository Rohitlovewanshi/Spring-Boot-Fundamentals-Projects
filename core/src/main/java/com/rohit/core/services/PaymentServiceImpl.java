package com.rohit.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohit.core.dao.PaymentDao;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentDao dao;

	public PaymentDao getDao() {
		return dao;
	}

	public void setDao(PaymentDao dao) {
		this.dao = dao;
	}

}
