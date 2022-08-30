package com.example.demo;

import dao.Dao;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "salesInquiry", value = "/salesInquiry")
public class salesInquiry extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String details = request.getParameter("salesInquiryDetails");
        JSONParser parser = new JSONParser();
        int status = 0;
        Dao d = new Dao();

        try{
            JSONArray jsonArray = (JSONArray) parser.parse(details);
            JSONObject jsonObj = (JSONObject) jsonArray.get(0);
            status = d.addSalesDetails((String) jsonObj.get("salesInquiryName"), (String) jsonObj.get("salesInquiryMail"), (String) jsonObj.get("salesInquiryNumber"), (String) jsonObj.get("salesInquiryOccupation"),(String) jsonObj.get("salesInquiryMessage"));
        }catch (Exception ex){ex.printStackTrace();}

        if(status > 0){

            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Thanks for submitting we will get back to you soon");
        }

    }
}
