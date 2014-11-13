package cn.gordon.mybatis.controller;

import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.gordon.mybatis.model.DemoEbo;
import cn.gordon.mybatis.service.DemoService;

@Controller
@RequestMapping("demo")
public class DemoController {

    private DemoService demoService;

    public DemoService getDemoService() {
        return demoService;
    }
    
    @Autowired
    public void setDemoService(DemoService demoService) {
        this.demoService = demoService;
    }

    @SuppressWarnings("finally")
    @RequestMapping("insert")
    public String add(DemoEbo demo, HttpServletRequest request) {
        try {
            demo.setId(UUID.randomUUID().toString());
            System.out.println(demo.getId() + ":::::" + demo.getTname() + ":::::" + demo.getTpwd());
            String str = demoService.insert(demo);
            System.out.println(str);
            request.setAttribute("InfoMessage", str);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("InfoMessage", "添加信息失败！具体异常信息：" + e.getMessage());
        } finally {
            return "demo/result";
        }
    }

    @RequestMapping("getAll")
    public String getAddInfoAll(HttpServletRequest request) {
        try {
            List<DemoEbo> list = demoService.getAll();
            System.out.println(list);
            request.setAttribute("demoList", list);
            return "demo/listAll";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
            return "demo/result";
        }
    }

    @SuppressWarnings("finally")
    @RequestMapping("del")
    public String del(String tid, HttpServletRequest request) {
        try {
            String str = demoService.delete(tid);
            request.setAttribute("InfoMessage", str);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("InfoMessage", "删除信息失败！具体异常信息：" + e.getMessage());
        } finally {
            return "demo/result";
        }
    }

    @RequestMapping("modify")
    public String modify(String tid, HttpServletRequest request) {
        try {
            DemoEbo demo = demoService.get(tid);
            request.setAttribute("demo", demo);
            return "demo/modify";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
            return "demo/result";
        }
    }

    @SuppressWarnings("finally")
    @RequestMapping("update")
    public String update(DemoEbo demo, HttpServletRequest request) {
        try {
            String str = demoService.update(demo);
            request.setAttribute("InfoMessage", str);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("InfoMessage", "更新信息失败！具体异常信息：" + e.getMessage());
        } finally {
            return "demo/result";
        }
    }

}
