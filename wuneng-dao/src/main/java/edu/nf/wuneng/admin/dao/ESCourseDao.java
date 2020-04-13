package edu.nf.wuneng.admin.dao;

import edu.nf.wuneng.admin.entity.ESCourse;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author YXD
 * @date 2020/4/13
 */
public interface ESCourseDao extends ElasticsearchRepository<ESCourse, String> {
    @Query("{\"match\" : {\"type\" : \"?0\"}}}")
    List<ESCourse> listCourseByName(String name);
}