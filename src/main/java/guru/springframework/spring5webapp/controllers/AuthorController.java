package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRespository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRespository authorRespository;

    public AuthorController(AuthorRespository authorRespository) {
        this.authorRespository = authorRespository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authorsList", authorRespository.findAll());
        return "authors";
    }
}
