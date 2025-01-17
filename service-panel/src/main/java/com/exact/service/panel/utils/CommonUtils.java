package com.exact.service.panel.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class CommonUtils {

	public static File multipartFileToFile(MultipartFile multipartFile) throws IOException{
		File convFile = new File(multipartFile.getOriginalFilename());
	    convFile.createNewFile();
	    FileOutputStream fos = new FileOutputStream(convFile);
	    fos.write(multipartFile.getBytes());
	    fos.close();
	    return convFile;
	}
	
}
