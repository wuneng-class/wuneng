package edu.nf.wuneng.admin.web;

import edu.nf.wuneng.admin.entity.*;
import edu.nf.wuneng.admin.service.AdminService;
import edu.nf.wuneng.conf.UploadVideo;
import edu.nf.wuneng.vo.BaseController;
import edu.nf.wuneng.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YXD
 * @date 2020/3/11
 */
@RestController
public class AdminController extends BaseController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private UploadVideo uploadVideo;

    @RequestMapping("/get")
    public String getad(String id){
        Admin admin = adminService.loginAdmin(id);
        System.out.println(admin.getId());
        return "admin";
    }

    @RequestMapping("/upload_file")
    public String upload(MultipartFile[] file){
        for(MultipartFile s:file){
            String addr=uploadVideo.uploadFile(s);
            System.out.println(addr);
        }
        return "success";
    }

    /**
     * 课程上传
     * @param cid
     * @param cname
     * @param cintroduct
     * @param cimg1
     * @param cimg2
     * @param cimg3
     * @param file
     * @return
     */
    @RequestMapping("/upload_course")
    public ResultVO uploadCourse(Integer cid,String cname,String cintroduct,MultipartFile cimg1,MultipartFile cimg2,MultipartFile cimg3,MultipartFile[] file){
        System.out.println(cid);
        System.out.println(cname);
        System.out.println(cintroduct);
        Course course=new Course();
        course.setCid(cid);
        course.setCname(cname);
        course.setCintroduct(cintroduct);
        String img1=uploadVideo.uploadFile(cimg1);
        System.out.println(img1);
        String img2=uploadVideo.uploadFile(cimg2);
        System.out.println(img2);
        String img3=uploadVideo.uploadFile(cimg3);
        System.out.println(img3);
        course.setCimg1(img1);
        course.setCimg2(img2);
        course.setCimg3(img3);
        List<CourseAddr> list=new ArrayList<>();
        for (MultipartFile multipartFile : file) {
            CourseAddr ca=new CourseAddr();
            ca.setCaId(cid);
            String addr=uploadVideo.uploadFile(multipartFile);
            System.out.println("addr:"+addr);
            ca.setCaAddr(addr);
            list.add(ca);
        }
        adminService.addCourse(course);
        adminService.addCourseAddr(list);
        return success(200);
    }

    @RequestMapping("/list_courseCation")
    public ResultVO<List<CourseCation>> listCourseCation(){
        List<CourseCation> courseCations = adminService.listCourseCation();
        return success(courseCations);
    }

    @RequestMapping("/list_courseInfo")
    public ResultVO<List<CourseInfo>> listCourseInfo(){
        List<CourseInfo> courseInfos = adminService.listCourseInfo();
        return success(courseInfos);
    }
}