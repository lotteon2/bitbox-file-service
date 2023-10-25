package com.bitbox.file.controller;

import com.bitbox.file.service.FileService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {

  private final FileService fileService;

  @PostMapping("/image")
  public ResponseEntity<String> registerImage(@RequestPart("image")MultipartFile image) {
    try {
      return ResponseEntity.ok(fileService.uploadImage(image));
    } catch (IOException e) {
      return ResponseEntity.internalServerError().body("이미지를 업로드하지 못 했습니다.");
    }
  }

}
