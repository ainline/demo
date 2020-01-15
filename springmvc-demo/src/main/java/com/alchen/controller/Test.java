package com.alchen.controller;

import com.alchen.domain.User;
import com.alchen.exception.ExceptionMessage;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class Test {

    @RequestMapping(path = "/getText")
    public String getText() {
        System.out.println("getText");
        return "success";
    }

    @RequestMapping(value = "/save")
    public void save(User user) {
        System.out.println(user);
    }

    @ModelAttribute()
    public void modelAttribute() {
        User user = new User();
        user.setName("chen");
        user.setAge(12);
    }

    @RequestMapping("/void")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid");
        //请求转发,使用自定义转发，不会经过视图解析器，需要配置转发文件全路径地址
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        // 重定向
//        response.sendRedirect(request.getContextPath()+"/index.jsp");

        // 设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        // 直接响应内容
        response.getWriter().print("直接响应");
    }

    @RequestMapping("modelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView");
        User user = new User();
        user.setName("chen");
        user.setAge(12);
        //把对象存储到mv对象中，会把对象存入request对象
        mv.addObject("user", user);
        //跳转到哪个页面
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("forwardOrRedirect")
    public String forwardOrRedirect() {
        System.out.println("forwardOrRedirect");
        // 请求的转发
        //return "forward:/WEB-INF/pages/success.jsp";
        //重定向
        return "redirect:/index.jsp";
    }

    @RequestMapping("ajax")
    public @ResponseBody
    User ajax(@RequestBody User user) {
        System.out.println("ajax");
        System.out.println(user);
        return user;
    }

    @RequestMapping("upload")
    public String fileUpload(HttpServletRequest request) throws Exception {
        // 获取文件保存路径
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(realPath);
        //如果不存在该路径，创建文件夹
        if (!file.exists()) {
            file.mkdirs();
        }
        // 解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request结构
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item : items) {
            if (item.isFormField()) {
                // 判断是一个普通表单
            } else {
                // 提交的是一个文件，进行文件处理
                String fileName = item.getName();
                // write方法将文件上传到指定路径
                item.write(new File(realPath, fileName));
                item.delete();
            }
        }
        return "success";
    }

    @RequestMapping("uploadMVC")
    public String uploadFileSpringMVC(HttpServletRequest request, MultipartFile upload) throws IOException {
        // 获取文件保存路径
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(realPath);
        //如果不存在该路径，创建文件夹
        if (!file.exists()) {
            file.mkdirs();
        }
        // 调用transferTo方法上传文件
        upload.transferTo(new File(realPath, upload.getOriginalFilename()));
        return "success";
    }

    @RequestMapping("exception")
    public String testException() throws Exception {

        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionMessage("错误啦");
        }
        return "success";
    }
}
