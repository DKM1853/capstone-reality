package com.example.demo;
import dao.Dao;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "contactForm", value = "/contactForm")
public class contactForm extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String details = request.getParameter("contactdetails");
        JSONParser parser = new JSONParser();
        int status = 0;
        Dao d = new Dao();

        try{
            JSONArray jsonArray = (JSONArray) parser.parse(details);
            JSONObject jsonObj = (JSONObject) jsonArray.get(0);
            status = d.addContactDetails((String) jsonObj.get("contactname"), (String) jsonObj.get("contactmail"), (String) jsonObj.get("contactno"), (String) jsonObj.get("contactmessage"));
         }catch (Exception ex){ex.printStackTrace();}

        if(status > 0){

            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Thanks for submitting");
        }

    }
}
