package com.restapi.book.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class FileUploadHelper {
	//*************Image upload to dynamic path
	  //public final String UPLOAD_DIR="D:\\SprintBootSTS\\RestApi\\restapibook\\src\\main\\resources\\static\\images";
	   public final String UPLOAD_DIR = new ClassPathResource("/static/images/").getFile().getAbsolutePath();
	
	   FileUploadHelper() throws IOException
	   {
		   
	   }
	public boolean uploadFile(MultipartFile multiPartFile) 
	{
		boolean f=false;
		try {
	/*
		//First way of doing it 	
		//Read Data
		InputStream in = multiPartFile.getInputStream();
		byte data[] = new byte[in.available()];
		in.read(data);	
		//Write data
		FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + File.separator+multiPartFile.getOriginalFilename());
		fos.write(data);
		fos.flush();
		fos.close();      */
		 
		Files.copy(multiPartFile.getInputStream(),Paths.get(UPLOAD_DIR + File.separator+multiPartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		
		f=true;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
 
	
	// **********************Image Uploading to static path
	/*
	public final String UPLOAD_DIR="D:\\SprintBootSTS\\RestApi\\restapibook\\src\\main\\resources\\static\\images";
	public boolean uploadFile(MultipartFile multiPartFile) 
	{
		boolean f=false;
		try {
	/*
		//First way of doing it 	
		//Read Data
		InputStream in = multiPartFile.getInputStream();
		byte data[] = new byte[in.available()];
		in.read(data);	
		//Write data
		FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + File.separator+multiPartFile.getOriginalFilename());
		fos.write(data);
		fos.flush();
		fos.close();      */
		 
	/*	Files.copy(multiPartFile.getInputStream(),Paths.get(UPLOAD_DIR + File.separator+multiPartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		
		f=true;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
*/
}
