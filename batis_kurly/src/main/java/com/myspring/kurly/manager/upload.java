package com.myspring.kurly.manager;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class upload {
	public String fileUpload(MultipartHttpServletRequest mRequest ){
		String re = "";
		boolean isUpload = false;
		ServletContext context = mRequest.getSession().getServletContext();
		String saveFolder = "/resources/img/";
		String uploadPath = context.getRealPath(saveFolder);
		System.out.println("realFolder="+uploadPath);
		
		
		Iterator<String> iterator = mRequest.getFileNames();
		
		while(iterator.hasNext()){
			String uploadFileName = iterator.next();
			
			MultipartFile mFile = mRequest.getFile(uploadFileName);
			String originFileName = mFile.getOriginalFilename();
			String saveFileName = originFileName;
			
			if(saveFileName != null && !saveFileName.equals("")){
				if(new File(uploadPath + saveFileName).exists()){
					
					re = saveFileName;
				}
				
				try {
					mFile.transferTo(new File(uploadPath+saveFileName));
					//int item_number = Integer.parseInt(mRequest.getParameter("item_number"));
					//System.out.println("fileUpload()" + item_number);
					isUpload=true;
				} catch (IllegalStateException e) {
					e.printStackTrace();
					isUpload=false;
				} catch (IOException e2){
					e2.printStackTrace();
					isUpload = false;
				}				
			}
		}
			
		return re;
	}
}
