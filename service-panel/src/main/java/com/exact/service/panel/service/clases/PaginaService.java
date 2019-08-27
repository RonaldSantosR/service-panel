package com.exact.service.panel.service.clases;



import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.service.panel.dao.IFooterDao;
import com.exact.service.panel.dao.IItemDao;
import com.exact.service.panel.dao.IPaginaDao;
import com.exact.service.panel.dao.ITituloDao;
import com.exact.service.panel.entity.Footer;
import com.exact.service.panel.entity.Item;
import com.exact.service.panel.entity.Titulo;
import com.exact.service.panel.service.interfaces.IPaginaService;
import com.exact.service.panel.utils.ConvertImageToBase64;

@Service
public class PaginaService implements IPaginaService {

	@Autowired
	IPaginaDao paginaDao;
	
	@Autowired
	IItemDao itemDao;
	
	@Autowired
	ITituloDao tituloDao;
	
	@Autowired
	IFooterDao footerDao;
	
	@Override
	public Map<Integer,Object> listarPaginaPrincipal() throws IOException {

		Iterable<Titulo> titulos = tituloDao.findAll();
		Iterable<Item> items = itemDao.findAll();
		Iterable<Footer> footer = footerDao.findAll();
		Map<Integer,Object> vistaPrincipal = new HashMap<>();
		
		for(Item item : items) {
			String imagenB64=ConvertImageToBase64.encodeToString(item.getRuta_imagen());
			item.setRuta_imagen(imagenB64);
		}
		
		
		vistaPrincipal.put(1, titulos);
		vistaPrincipal.put(2, items);
		vistaPrincipal.put(3, footer);
		
		return vistaPrincipal;
		
	}

	
	
}
