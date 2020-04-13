package edu.nf.wuneng.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

import java.time.Duration;

/**
 * @author YXD
 * @date 2020/4/13
 */
@Configuration
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {
    @Override
    public RestHighLevelClient elasticsearchClient() {
        //使用HttpHeaders设置相关的请求头信息
        //HttpHeaders defaultHeaders = new HttpHeaders();
        ClientConfiguration configuration =  ClientConfiguration.builder()
                .connectedTo("39.97.179.195:9200")
                .withConnectTimeout(Duration.ofSeconds(5))
                .withSocketTimeout(Duration.ofSeconds(3))
                //.withDefaultHeaders(defaultHeaders)
                .build();
        return RestClients.create(configuration).rest();
    }
}