package com.samsam.bsl.mainpage.repository.querydsl;

import com.samsam.bsl.mainpage.dto.*;

import java.util.List;

public interface MainRepositoryQueryDsl {
  List<MainBook> getNewBook();
  List<MainNotice> getNotice();
  List<MainProgram> getProgram();
  List<MainBook> getBestseller();
  List<MainRecomm> getRecommendBook();
  List<MainReview> getReview();
}