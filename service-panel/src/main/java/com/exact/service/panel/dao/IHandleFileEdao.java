package com.exact.service.panel.dao;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface IHandleFileEdao {

	public int upload(MultipartFile file, String ruta) throws IOException;
}
