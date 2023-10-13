package com.samsam.bsl.mainpage.controller;

import com.samsam.bsl.mainpage.domain.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class MainController {

    @GetMapping("/newbook")
    public List<MainBook> getNewBooks() {

        return null;
    }

    @GetMapping("/notice")
    public List<MainNotice> getNotice() {
        return null;
    }

    @GetMapping("/program")
    public List<MainProgram> getProgram() {
        return null;
    }

    @GetMapping("/bestseller")
    public List<MainBook> getBestseller() {
        return null;
    }

    @GetMapping("/recommend")
    public List<MainRecomm> getRecommend() {
        return null;
    }

    @GetMapping("/review")
    public List<MainReview> getReview() {
        return null;
    }
}
