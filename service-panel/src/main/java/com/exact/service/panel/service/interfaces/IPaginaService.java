package com.exact.service.panel.service.interfaces;

import java.io.IOException;
import java.util.Map;

import com.exact.service.panel.entity.Pagina;

public interface IPaginaService {

	public Map<Integer,Object> listarPaginaPrincipal(String perfil) throws IOException;
	
	public Pagina modificarPagina(Pagina pag) throws IOException;
	
}
