package com.example.springbootmybatisgeneratortest.service.serviceImpl;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.springbootmybatisgeneratortest.service.FileService;


@Service
public class FileServiceImpl implements FileService{

	@Override
	public String upload(MultipartFile file ,  HttpServletRequest request) throws IllegalStateException, IOException {
		
		if(file!=null) {// 判断上传的文件是否为空
			// String realPath= "C:\\Users\\liuyicong\\Desktop\\file\\"; 
			 String realPath  = "/usr/local/file/";
			 String currentNum = String.valueOf(System.currentTimeMillis());
	         String path=null;// 文件路径
	         String type=null;// 文件类型
	         String fileName=file.getOriginalFilename();// 文件原名称
	         System.out.println("上传的文件原名称:"+fileName);
     		// 判断文件类型
			 type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
	         	if (type!=null) {// 判断文件类型是否为空
		                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
		                     // 项目在容器中实际发布运行的根路径
		                     
		                     // 自定义的文件名称
		                     String trueFileName=currentNum+fileName;
		                     // 设置存放图片文件的路径
		                     path=realPath+trueFileName;
		                    // path=path.replaceAll( "/", "\\\\");
		                     System.out.println("存放图片文件的路径:"+path);
		                     // 转存文件到指定的路径
		                     file.transferTo(new File(path));
		                     System.out.println("文件成功上传到指定目录下");
		                     return "http://47.105.169.142/api/file/image/"+ trueFileName.replace(".","/");
		                    
		                 }else {
		                     System.out.println("不是我们想要的文件类型,请按要求重新上传");
		                     return null;
		                 }
	             }else {
	                 System.out.println("文件类型为空");
	                 return null;
	             }
	     }else {
	         System.out.println("没有找到相对应的文件");
	         return null;
	     }
	}

}
