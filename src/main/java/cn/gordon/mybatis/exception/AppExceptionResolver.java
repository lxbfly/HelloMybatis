package cn.gordon.mybatis.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class AppExceptionResolver extends SimpleMappingExceptionResolver {
    
    private Logger logger = Logger.getLogger(this.getClass());
    
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        logger.error("Exception", ex);
        return super.doResolveException(request, response, handler, ex);
    }
    
}
