package com.exact.service.panel.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

public class ConvertImageToBase64 {

	public static String encodeToString(String ruta) throws IOException {
		File file = new File(ruta);
		//byte[] fileContent = FileUtils.readFileToByteArray(new File(ruta));
		String encoded = Base64.getEncoder().withoutPadding().encodeToString(FileUtils.readFileToByteArray(file));
		 return encoded;
	}
}