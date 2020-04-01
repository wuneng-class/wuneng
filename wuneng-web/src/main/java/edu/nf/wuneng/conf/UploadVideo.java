package edu.nf.wuneng.conf;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import edu.nf.wuneng.exception.AccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * @author YXD
 * @date 2020/4/1
 */
@Component
@EnableConfigurationProperties(UploadConfig.class)
public class UploadVideo {
    @Autowired
    private FastFileStorageClient storageClient;
    @Autowired
    private UploadConfig uploadConfig;

    public String uploadFile(MultipartFile file) {
        try{
            String extension = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
            StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), extension, null);
            return uploadConfig.getBaseUrl() + storePath.getFullPath();
        } catch (IOException e) {
            e.printStackTrace();
            throw new AccessException("文件上传失败");
        }
    }
}