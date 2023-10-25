package com.bitbox.file.service;

import com.bitbox.file.config.util.S3UploadUtil;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class FileService {

  private final S3UploadUtil s3UploadUtil;

  public String uploadImage(MultipartFile image) throws IOException {
    return s3UploadUtil.upload(image, "images");
  }

}
