package com.exact.service.panel.service.clases;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.exact.service.panel.dao.IFooterDao;
import com.exact.service.panel.entity.Footer;
import com.exact.service.panel.service.interfaces.IFooterService;

@Service
public class FooterService implements IFooterService{

	@Autowired
	IFooterDao footerDao;
	
	@Value("${ruta.logos}")
	String rutaLogo;
	
	@Override
	public Iterable<Footer> listarFooter() {
		return footerDao.findAll();
	}

	@Override
	public Footer modificarFooter(Footer footer) {
		Optional<Footer> footerOpt = footerDao.findById(footer.getId());
		if(!footerOpt.isPresent()) {
			return null;
		}
		Footer footerActualizado = footerOpt.get();
		
		if(footer.getDescripcion()!=null) {
			footerActualizado.setDescripcion(footer.getDescripcion());
		}
		if(footer.getColor()!=null) {
			footerActualizado.setColor(footer.getColor());
		}
		if(footer.getColorDescripcion()!=null) {
			footerActualizado.setColorDescripcion(footer.getColorDescripcion());
		}
		if(footer.getLogo()!=null) {
			footerActualizado.setLogo(rutaLogo+footer.getLogo());
		}
		
		return footerDao.save(footerActualizado);
	}

}
