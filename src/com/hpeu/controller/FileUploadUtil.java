package com.hpeu.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 * @author yfly
 * @date 2018年6月5日 上午9:09:20
 */
@Controller
public class FileUploadUtil {

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	@ResponseBody
	/**
	 * 
	 * @methodName FileUploadUtil.java
	 * @author yfly
	 * @date 2018年6月5日 上午9:08:29	
	 * @param MultipartFile:用于接收前台表单的文件
	 * @param req：
	 * @return
	 */
	public String upload(MultipartFile file, HttpServletRequest req) {
		/**
		 * 1、获取源文件名
		 * 2、获取原文及的后缀
		 * 3、给文件取个新的名字（+后缀）（新文件名的目的是保证，文件名不重复）
		 * 4、如果有文件夹则创建文件夹
		 * 5、把文件写到服务器上
		 */
		//1
		try {
			String oldName = file.getOriginalFilename();
			System.out.println("文件的原始名字是：" + oldName);
			String suffix = oldName.substring(oldName.indexOf("."));
			System.out.println("文件的后缀是：" + suffix);
			Integer random = Math.abs(new Random().nextInt());
			System.out.println("生成的随机数是：" + random);
			String newName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + random.toString() + suffix;
			System.out.println("新的文件名市：" + newName);
			String url = req.getServletContext().getRealPath("upload") + File.separator + new SimpleDateFormat("yyyyMMdd").format(new Date());
			File file2 = new File(url + File.separator + newName);
			if(!file2.exists()) {
				file2.mkdirs();
			}
			//把文件写到服务器上
			file.transferTo(file2);
			return newName;
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
	}
	
}
