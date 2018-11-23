package com.example.springbootmybatisgeneratortest.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.springbootmybatisgeneratortest.pojo.Result;
import com.example.springbootmybatisgeneratortest.pojo.StatusMap;
import com.example.springbootmybatisgeneratortest.service.FileService;




@RestController
@RequestMapping("/api/file")
public class FileController {

	
	@Autowired
	private FileService fileService;
	
	
	@PostMapping
	@RequestMapping("/upload")
	public Result uploadFile(@RequestParam("file_data") MultipartFile uploadfile , HttpServletRequest request){
		String httpPath = "";
		try {
			httpPath = fileService.upload(uploadfile , request);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  new Result("success", StatusMap.CONTROLLER_BACK_SUCSSES, httpPath);
	}
	
	
	@GetMapping
	/**
	 * 百度ueditor编辑器的图片回显   通过<img/>标签中的src访问  例:http://localhost:8080/qxzst-sp-apis//pc/image/getUeditorImg/1480504795791062668/png
	 * @param imgname  图片名
	 * @param imgType	扩展名
	 * @param response
	 */
	@RequestMapping("/image/{imgname}/{imgType}")
	public void getUeditorImg(@PathVariable String imgname, @PathVariable String imgType,
			HttpServletResponse response , HttpServletRequest request) {
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		try {
			String filePath = "//usr//local//file//";
			File file = new File(filePath  + imgname + "." + imgType);
			in = new BufferedInputStream(new FileInputStream(file));
			out = new BufferedOutputStream(response.getOutputStream());
			response.setContentType(new MimetypesFileTypeMap().getContentType(file));// 设置response内容的类型
			response.setHeader("Content-disposition", "attachment;filename=" + imgname + "." + imgType);// 设置头部信息
			byte[] buffer = new byte[10240];
			int length = 0;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
