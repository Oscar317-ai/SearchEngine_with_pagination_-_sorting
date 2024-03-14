package com.yesii.Biclats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepo userRepository;

    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "0") Integer page,
                        @RequestParam(defaultValue = "id") String sortField,
                        @RequestParam(defaultValue = "asc") String sortOrder,
                        String keyword) {

        int pageSize = 5;
        Sort sort = Sort.by(sortField);
        sort = sortOrder.equals("asc") ? sort.ascending() : sort.descending();
        PageRequest pageable = PageRequest.of(page, pageSize, sort);

        page = page != null ? page : 0;

        Page<MyUser> users;
        if (keyword != null && !keyword.isEmpty()) {
            users = userRepository.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(keyword, keyword, pageable);
        } else {
            users = userRepository.findAll(pageable);
        }

        model.addAttribute("users", users);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", users.getTotalPages());
        // Add the rest of your code here
        return "index";
    }



}
