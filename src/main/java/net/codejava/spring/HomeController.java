package net.codejava.spring;

import java.util.List;
import java.util.Properties;

import net.codejava.spring.dao.PersonDAO;
import net.codejava.spring.dao.UserDAO;
import net.codejava.spring.model.Person;
import net.codejava.spring.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by JORGE-HP on 30/1/2017.
 */
@Controller
public class HomeController {
    @Autowired
    private UserDAO userDao;

    @Autowired
    private PersonDAO personDAO;

    @Resource(name="myProperties")
    private Properties myProperties;

    @RequestMapping(value="/home")
    public ModelAndView home() {
        System.err.println("Hello!!!!");
        Person person = new Person();
        person.setName("jalslsl");
        person.setCountry("bol");
        personDAO.save(person);

        System.err.println(myProperties.getProperty("username") + myProperties.entrySet().toString());
        List<User> listUsers = userDao.list();
        ModelAndView model = new ModelAndView("home");
        model.addObject("userList", listUsers);
        model.addObject("person", personDAO.getPerson());
        return model;
    }
}