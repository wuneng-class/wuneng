package edu.nf.wuneng.admin.dao;

import edu.nf.wuneng.admin.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author YXD
 * @date 2020/3/9
 */
@Mapper
public interface AdminDao {
    Admin loginAdmin(String id);
}