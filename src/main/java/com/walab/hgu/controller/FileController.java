package com.walab.hgu.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class FileController {
	
	@RequestMapping(value="upload.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String uploadFile(MultipartHttpServletRequest request, MultipartFile upload) {
		//파일이 업로드 될 경로 설정 
		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file");
		MultipartFile f = upload;
		//위에서 설정한 경로의 폴더가 없을 경우 생성 
		File dir = new File(saveDir); 
		if(!dir.exists()) { 
			dir.mkdirs(); 
		}
		
		if(!f.isEmpty()) {
			String orifileName = f.getOriginalFilename(); 
			String ext = orifileName.substring(orifileName.lastIndexOf("."));

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmssSSS"); 
			int rand = (int)(Math.random()*1000);

			String reName = sdf.format(System.currentTimeMillis()) + "_" + rand + ext;

			try { 
				f.transferTo(new File(saveDir + "/" + reName)); 
			}catch (IllegalStateException | IOException e) { e.printStackTrace(); } }
		
		System.out.println(saveDir);
		return "communityInfo";

	}
	
}
