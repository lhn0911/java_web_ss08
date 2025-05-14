package com.rikkei.ss08.controller;

import com.rikkei.ss08.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @GetMapping("/users")
    public ModelAndView showUserList() {
        List<User> userList = new ArrayList<>();

        userList.add(new User("Nguyễn Văn A", 25, "1999-01-01", "a@gmail.com", "0909123456"));
        userList.add(new User("Trần Thị B", 30, "1994-05-20", "b@gmail.com", "0909345678"));
        userList.add(new User("Lê Văn C", 28, "1996-11-10", "c@gmail.com", "0912123456"));

        ModelAndView mav = new ModelAndView("Bai5/userList");
        mav.addObject("users", userList);

        return mav;
    }
}
