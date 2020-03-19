package edu.nf.wuneng.admin.web;

import edu.nf.wuneng.admin.entity.Admin;
import edu.nf.wuneng.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YXD
 * @date 2020/3/11
 */
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/get")
    public String getad(String id){
        Admin admin = adminService.loginAdmin(id);
        System.out.println(admin.getId());
        return "admin";
    }
}