package com.exact.service.panel.service.interfaces;

import com.exact.service.panel.entity.Footer;

public interface IFooterService {

	public Iterable<Footer> listarFooter();
	public Footer modificarFooter (Footer footer);
}
