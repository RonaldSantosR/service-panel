package com.exact.service.panel.service.clases;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.service.panel.dao.IFooterDao;
import com.exact.service.panel.dao.IItemDao;
import com.exact.service.panel.dao.IPaginaDao;
import com.exact.service.panel.dao.ITituloDao;
import com.exact.service.panel.entity.Footer;
import com.exact.service.panel.entity.Item;
import com.exact.service.panel.entity.Pagina;
import com.exact.service.panel.entity.Titulo;
import com.exact.service.panel.service.interfaces.IPaginaService;
import com.exact.service.panel.utils.ConvertImageToBase64;

@Service
public class PaginaService implements IPaginaService {

	private static final String USUARIO_MANT = "USER_MANTENIMIENTO";
	
	@Autowired
	IPaginaDao paginaDao;
	
	@Autowired
	IItemDao itemDao;
	
	@Autowired
	ITituloDao tituloDao;
	
	@Autowired
	IFooterDao footerDao;
	
	@Override
	public Map<Integer,Object> listarPaginaPrincipal(String perfil) throws IOException {

		Iterable<Titulo> titulos = tituloDao.findAll();
		Iterable<Item> items = itemDao.findAll();
		Iterable<Footer> footers = footerDao.findAll();
		Iterable<Pagina> paginas = paginaDao.findAll();
		Map<Integer,Object> vistaPrincipal = new HashMap<>();
		
		for(Item item : items) {
			String imagenB64=ConvertImageToBase64.encodeToString(item.getRuta_imagen());
			item.setRuta_imagen(imagenB64);
		}
		
		for(Footer footer : footers) {
			String imagenB64=ConvertImageToBase64.encodeToString(footer.getLogo());
			footer.setLogo(imagenB64);
		}
		
		List<Item> itemlst = StreamSupport.stream(items.spliterator(), false).collect(Collectors.toList());
		itemlst.removeIf(item->!item.isActivo());
				
		vistaPrincipal.put(1, titulos);
		vistaPrincipal.put(2, paginas);
		vistaPrincipal.put(3, itemlst);
		vistaPrincipal.put(4, footers);
		
		if(perfil.equals(USUARIO_MANT)) {
			vistaPrincipal.put(5, "MANTENIMIENTO");
		}else {
			vistaPrincipal.put(5, "DEMO");
		}

		return vistaPrincipal;
		
	}

	@Override
	public Pagina modificarPagina(Pagina pag) throws IOException {
		if(pag.getColor()!=null) {
			return paginaDao.save(pag);
		}
		
		return null;
	}

	
	
}
