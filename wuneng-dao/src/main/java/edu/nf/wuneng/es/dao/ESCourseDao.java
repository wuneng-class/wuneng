package edu.nf.wuneng.es.dao;

import edu.nf.wuneng.admin.entity.ESCourse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author YXD
 * @date 2020/4/13
 */
@Mapper
public interface ESCourseDao extends ElasticsearchRepository<ESCourse, String> {
    @Query("{\"match\" : {\"type\" : \"?0\"}}}")
    List<ESCourse> listESCourse(String type);
}