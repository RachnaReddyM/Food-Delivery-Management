package edu.northeastern.cs5200.controllers;

import edu.northeastern.cs5200.forms.LoginForm;
import edu.northeastern.cs5200.forms.OnlineUser;
import edu.northeastern.cs5200.forms.Search;
import edu.northeastern.cs5200.models.Restaurant;
import edu.northeastern.cs5200.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private RestaurantService resService;

    @GetMapping("/search/")
    public String loginPage(@ModelAttribute("search") Search searchText,Model model) {

        List<Restaurant> restaurants = resService.findRestaurantsByName(searchText.getSearchText());
        model.addAttribute("restaurants", restaurants);

        model.addAttribute("search", new Search());
        model.addAttribute("loginForm", new LoginForm());

        model.addAttribute("user", new OnlineUser());
        return "index";
    }

}
