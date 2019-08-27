package com.exact.service.panel.service.clases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.service.panel.dao.IFooterDao;
import com.exact.service.panel.entity.Footer;
import com.exact.service.panel.service.interfaces.IFooterService;

@Service
public class FooterService implements IFooterService{

	@Autowired
	IFooterDao footerDao;
	
	@Override
	public Iterable<Footer> listarFooter() {
		return footerDao.findAll();
	}

}
