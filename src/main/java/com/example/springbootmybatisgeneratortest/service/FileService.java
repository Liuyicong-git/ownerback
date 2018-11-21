package com.example.springbootmybatisgeneratortest.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	public String upload(MultipartFile uploadfile , HttpServletRequest request) throws IllegalStateException, IOException;

}
