package cn.gordon.mybatis.controller;

import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.gordon.mybatis.utils.VerifyCode;

@Controller
@RequestMapping("user")
public class UserController {

    private InputStream inputStream;

    @RequestMapping("genverifycode")
    public String genVerificationCode(HttpServletRequest req) {
        VerifyCode verifyCode = VerifyCode.Instance();
        req.getSession().setAttribute("sessionVerifyCode", verifyCode.getVerificationCodeValue());
        this.setInputStream(verifyCode.getImage());
        return "html/login";
    }

    @RequestMapping("loginui")
    public String loginui() {
        return "html/login";
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

}
