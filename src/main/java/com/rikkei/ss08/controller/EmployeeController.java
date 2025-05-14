package com.rikkei.ss08.controller;

import com.rikkei.ss08.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {
    private List<Employee> employeeList = new ArrayList<>();

    @GetMapping("/employees")
    public ModelAndView showEmployeeList() {
        ModelAndView mav = new ModelAndView("Bai6/listEmployee");
        mav.addObject("employees", employeeList);
        return mav;
    }

    @GetMapping("/employees/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "Bai6/addEmployee";
    }

    @PostMapping("/employees")
    public String addEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        employeeList.add(employee);
        model.addAttribute("message", "Thêm nhân viên thành công!");
        return "redirect:/employees";
    }
}
