package edu.nf.wuneng.admin.web;

import com.github.pagehelper.PageInfo;
import edu.nf.wuneng.admin.entity.*;
import edu.nf.wuneng.admin.service.AdminService;
import edu.nf.wuneng.conf.ESConfig;
import edu.nf.wuneng.conf.UploadVideo;
import edu.nf.wuneng.user.entity.Orders;
import edu.nf.wuneng.user.entity.Users;
import edu.nf.wuneng.vo.BaseController;
import edu.nf.wuneng.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
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


    @RequestMapping("/upload_course")
    public ResultVO uploadCourse(Integer cid,String cname,String cintroduct,MultipartFile cimg1,MultipartFile cimg2,MultipartFile cimg3,MultipartFile[] file){
        Course course=new Course();
        course.setCid(cid);
        course.setCname(cname);
        course.setCintroduct(cintroduct);
        String img1=uploadVideo.uploadFile(cimg1);
        String img2=uploadVideo.uploadFile(cimg2);
        String img3=uploadVideo.uploadFile(cimg3);
        course.setCimg1(img1);
        course.setCimg2(img2);
        course.setCimg3(img3);
        List<CourseAddr> list=new ArrayList<>();
        for (MultipartFile multipartFile : file) {
            CourseAddr ca=new CourseAddr();
            ca.setCaId(cid);
            String addr=uploadVideo.uploadFile(multipartFile);
            ca.setCaAddr(addr);
            list.add(ca);
        }
        adminService.addCourse(course);
        adminService.addCourseAddr(list);
        return success(200);
    }
    @RequestMapping("/addPayCourse")
    public ResultVO addPayCourse(Integer id, String name, String context, BigDecimal price,MultipartFile cover,MultipartFile img1,MultipartFile img2,MultipartFile[] addr){
        PayCourse payCourse=new PayCourse();
        payCourse.setId(id);
        payCourse.setName(name);
        payCourse.setContext(context);
        payCourse.setPrice(price);
        String coveraddr=uploadVideo.uploadFile(cover);
        System.out.println(coveraddr);
        String img1addr=uploadVideo.uploadFile(img1);
        System.out.println(img1addr);
        String img2addr=uploadVideo.uploadFile(img2);
        System.out.println(img2addr);
        payCourse.setCover(coveraddr);
        payCourse.setImg1(img1addr);
        payCourse.setImg2(img2addr);
        List<PayCourseAddr> list=new ArrayList<>();
        for (MultipartFile file : addr) {
            PayCourseAddr pca=new PayCourseAddr();
            pca.setId(id);
            pca.setText(file.getOriginalFilename());
            String videoaddr=uploadVideo.uploadFile(file);
            pca.setAddr(videoaddr);
            list.add(pca);
        }
        adminService.addPayCourse(payCourse);
        adminService.addPayCourseAddr(list);
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

    @RequestMapping("/get_hotCourseById")
    public void getHotCourseById(Integer id, HttpSession session, HttpServletResponse response) throws IOException {
        session.setAttribute("get_hotCourseById",id);
        response.sendRedirect("video.html");
    }

    @RequestMapping("/showHotCourse")
    public ResultVO<HotCourse> showHotCourse(HttpSession session){
        Integer id= (Integer) session.getAttribute("get_hotCourseById");
        HotCourse hotCourse = adminService.showHotCourse(id);
        return success(hotCourse);
    }
    @RequestMapping("/listDiscussByIt")
    public ResultVO<List<Discuss>> listDiscussByIt(HttpSession session){
        Integer id= (Integer) session.getAttribute("get_hotCourseById");
        List<Discuss> discusses = adminService.listDiscussByIt(id);
        return success(discusses);
    }
    @RequestMapping("/addDiscussByIt")
    public ResultVO addDiscussByIt(String text,HttpSession session){
        Integer id= (Integer) session.getAttribute("get_hotCourseById");
        System.out.println("id"+id);
        Users user=(Users) session.getAttribute("user");
        if(user!=null){
            adminService.addDiscuss(id,user.getUserId(),text);
        }
        return success(200);
    }


    @RequestMapping("/list_payCourse")
    public ResultVO<List<PayCourse>> listPayCourse(){
        List<PayCourse> payCourses = adminService.listPayCourse();
        return success(payCourses);
    }

    @RequestMapping("/returnToBuy")
    public void returnToBuy(Integer id,HttpSession session,HttpServletResponse response) throws IOException {
        session.setAttribute("buyId",id);
        response.sendRedirect("buy.html");
    }

    @RequestMapping("/get_payCourseById")
    public ResultVO<PayCourse> getPayCourseById(HttpSession session){
        Integer id=(Integer) session.getAttribute("buyId");
        PayCourse payCourseById = adminService.getPayCourseById(id);
        return success(payCourseById);
    }

    @RequestMapping("/getPayCourseById")
    public ResultVO<PayCourse> getPayCourseById(Integer id){
        PayCourse payCourseById = adminService.getPayCourseById(id);
        return success(payCourseById);
    }

    @RequestMapping("/getCourseByNum")
    public ResultVO<CourseInfo> getCourseByNum(Integer num){
        CourseInfo courseByNum = adminService.getCourseByNum(num);
        return success(courseByNum);
    }

    @RequestMapping("/toCourseByNum")
    public ResultVO loadCourseByNum(Integer num,HttpSession session){
        session.setAttribute("loadCourseByNum",num);
        return success(200);
    }

    @RequestMapping("/loadCourseInfoByNum")
    public ResultVO<CourseInfo> loadCourseInfoByNum(HttpSession session){
        Integer num=(Integer) session.getAttribute("loadCourseByNum");
        CourseInfo courseByNum = adminService.getCourseByNum(num);
        return success(courseByNum);
    }
    @RequestMapping("/loadDiscussByNum")
    public ResultVO<List<Discuss>> loadDiscussByNum(HttpSession session){
        Integer num=(Integer) session.getAttribute("loadCourseByNum");
        List<Discuss> discusses = adminService.listDiscussByNum(num);
        return success(discusses);
    }
    @RequestMapping("/addDiscuss")
    public ResultVO addDiscuss(String text,HttpSession session){
        Integer num=(Integer) session.getAttribute("loadCourseByNum");
        Users user=(Users) session.getAttribute("user");
        if(user!=null){
            adminService.addDiscuss(num,user.getUserId(),text);
            return success(200);
        }
        return success(400);
    }
    @RequestMapping("/addCollectionByCourseInfo")
    public ResultVO addCollectionByCourseInfo(HttpSession session){
        Integer cid=(Integer) session.getAttribute("loadCourseByNum");
        Users user=(Users) session.getAttribute("user");
        if(user!=null){
            adminService.addCollection(user.getUserId(),cid);
        }
        return success(200);
    }

    @RequestMapping("/update_courseInfo")
    public ResultVO updateCourseInfo(CourseInfo courseInfo){
        adminService.updateCourseInfo(courseInfo);
        return success(200);
    }

    @RequestMapping("/admin/adminIndex")
    public ResultVO<AdminIndex> adminIndex(){
        BigDecimal sumToday = adminService.sumToday();

        BigDecimal sumYesterday = adminService.sumYesterday();

        Integer countOrdersToday = adminService.countOrdersToday();

        Integer countPayedToday = adminService.countPayedToday();

        Integer countNotPayToday = adminService.countNotPayToday();

        Integer countOrdersYesterday = adminService.countOrdersYesterday();

        Integer countPayedYesterday = adminService.countPayedYesterday();

        Integer countNotPayedYesterday = adminService.countNotPayedYesterday();

        AdminIndex adminIndex=new AdminIndex();
        adminIndex.setSumToday(sumToday);
        adminIndex.setSumYesterday(sumYesterday);
        adminIndex.setCountOrdersToday(countOrdersToday);
        adminIndex.setCountPayedToday(countPayedToday);
        adminIndex.setCountNotPayToday(countNotPayToday);
        adminIndex.setCountOrdersYesterday(countOrdersYesterday);
        adminIndex.setCountPayedYesterday(countPayedYesterday);
        adminIndex.setCountNotPayedYesterday(countNotPayedYesterday);
        return success(adminIndex);
    }

    @RequestMapping("/listOrders")
    public ResultVO<PageInfo<Orders>> listOrders(Integer pageNum,Integer pageSize){
        PageInfo<Orders> ordersPageInfo = adminService.listOrders(pageNum, pageSize);
        return success(ordersPageInfo);
    }

    @RequestMapping("/listDiscuss")
    public ResultVO<PageInfo<Discuss>> listDiscuss(Integer pageNum,Integer pageSize){
        PageInfo<Discuss> discussPageInfo = adminService.listDiscuss(pageNum, pageSize);
        return success(discussPageInfo);
    }

    @RequestMapping("/search")
    public ResultVO search(String type,HttpSession session){
        session.setAttribute("search_type",type);
        return success(200);
    }

    @RequestMapping("/loadSearchCourse")
    public ResultVO<List<ESCourse>> loadSearchCourse(HttpSession session){
        String type=(String) session.getAttribute("search_type");
        List<ESCourse> list = adminService.listESCourse(type);
        return success(list);
    }

    @RequestMapping("/searchByType")
    public ResultVO<List<ESCourse>> searchByType(String type){
        List<ESCourse> list = adminService.listESCourse(type);
        return success(list);
    }
}