package org.spring.test.mvn;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by user on 1/5/2017.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController{
    @RequestMapping("/index")
    public ModelAndView handleRequestInternal() throws Exception {
        ModelAndView model = new ModelAndView("index");
        model.addObject("msg", "hello world");
        return model;
    }
}
