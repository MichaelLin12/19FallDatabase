package com.example.demo;

import com.example.demo.model.ReviewRepository;
import com.example.demo.model.ReviewTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {

    @Autowired
    ReviewRepository reviewRepository;

    @PostMapping("/addreview")
    public String addReview(@RequestParam(name = "email") String email,
                            @RequestParam(name = "paperid") long paperid,
                            @RequestParam(name = "techmerit") int techmerit,
                            @RequestParam(name = "readability") int readability,
                            @RequestParam(name = "originality") int originality,
                            @RequestParam(name = "relevance") int relevance,
                            @RequestParam(name = "recomm") int recomm,
                            @RequestParam(name = "committeecomment") String committeecomment,
                            @RequestParam(name = "authorcomment") String authorcomment,
                            Model model
    ) {
        try {
            ReviewTable reviewTable = new ReviewTable(email, paperid, techmerit, readability, originality, relevance,
                    recomm, committeecomment, authorcomment);
            reviewRepository.create(reviewTable);
            return "reviewsuccess";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "error";
        }

    }
}
