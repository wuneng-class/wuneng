package edu.nf.wuneng.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author YXD
 * @date 2020/3/25
 */
@ConfigurationProperties(prefix = "upload")
@Data
public class UploadConfig {
    private String baseUrl;
    private List<String> allowTypes;
}