package com.rmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ylf on 2017/11/12.
 */
public interface IFileService {

    String upload(MultipartFile file, String path);
}
