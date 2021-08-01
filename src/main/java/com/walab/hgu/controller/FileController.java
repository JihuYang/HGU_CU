package com.walab.hgu.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class FileController {

	@RequestMapping(value = "/communityInfo/upload.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String uploadFile(MultipartHttpServletRequest request, MultipartFile upload) {
		// 파일이 업로드 될 경로 설정
		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file");
		MultipartFile f = upload;
		// 위에서 설정한 경로의 폴더가 없을 경우 생성
		File dir = new File(saveDir);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		if (!f.isEmpty()) {
			String orifileName = f.getOriginalFilename();
			String ext = orifileName.substring(orifileName.lastIndexOf("."));

			// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
			// int rand = (int)(Math.random()*1000);

			// String reName = sdf.format(System.currentTimeMillis()) + "_" + rand + ext;

			try {
				f.transferTo(new File(saveDir + "/" + orifileName));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println(saveDir);
		return "communityInfo";

	}

	@RequestMapping("/communityInfo/detail/filedownload")
	public void fileDownload(HttpServletRequest request, HttpServletResponse response) {
		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file");
		String fileName = "회원관리 예시.png";
		File file = new File(saveDir + "/" + fileName);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ServletOutputStream sos = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			sos = response.getOutputStream();
			String reFilename = "";
			boolean isMSIE = request.getHeader("user-agent").indexOf("MSIE") != -1
					|| request.getHeader("user-agent").indexOf("Trident") != -1;
			if (isMSIE) {
				reFilename = URLEncoder.encode("이미지 파일.jpg", "utf-8");
				reFilename = reFilename.replaceAll("\\+", "%20");
			} else {
				reFilename = new String("이미지 파일.jpg".getBytes("utf-8"), "ISO-8859-1");
			}
			response.setContentType("application/octet-stream;charset=utf-8");
			response.addHeader("Content-Disposition", "attachment;filename=\"" + reFilename + "\"");
			response.setContentLength((int) file.length());
			int read = 0;
			while ((read = bis.read()) != -1) {
				sos.write(read);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				sos.close();
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
