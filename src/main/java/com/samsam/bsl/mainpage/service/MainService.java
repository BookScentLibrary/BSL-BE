package com.samsam.bsl.mainpage.service;


import com.samsam.bsl.mainpage.dto.*;
import com.samsam.bsl.mainpage.repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

  @Autowired
  MainRepository mainRepository;


  public List<MainNotice> getNotice() {
    return mainRepository.getNotice();
  }
  public List<MainProgram> getProgram() {
    return mainRepository.getProgram();
  }
  public List<MainBook> getBestseller() {
    return mainRepository.getBestseller();
  }
  public List<MainRecomm> getRecommend() {
    return mainRepository.getRecommendBook();
  }
  public List<MainBook> getNewBook() {
    return mainRepository.getNewBook();
  }
  public List<MainReview> getReview() {
    return mainRepository.getReview();
  }

}
