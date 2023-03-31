package com.kishanseva.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kishanseva.dao.OrderDetailsDao;

@Service
public class OrderDetailsServiceImpl implements IOrderDetailsService {

	@Autowired
	private OrderDetailsDao orderDetailsDao;

}
