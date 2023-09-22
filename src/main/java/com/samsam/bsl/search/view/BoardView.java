package com.samsam.bsl.search.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/example")
public class BoardView extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        StringBuilder htmlBuilder = new StringBuilder();

        // HTML 코드를 문자열로 작성
        htmlBuilder.append("<div class='search'>");
        htmlBuilder.append("<form action='" + response.encodeURL("/book/admin/searchBookConfirm") + "' name='search_book_form' method='get'>");
        htmlBuilder.append("<input type='text' name='b_name' placeholder='Enter the name of the book you are looking for.'>");
        htmlBuilder.append("<input type='button' value='search' onclick='searchBookForm();'></form></div>");

        String htmlContent = htmlBuilder.toString();

        // HTML 응답 전송
        response.getWriter().write(htmlContent);
    }
}

