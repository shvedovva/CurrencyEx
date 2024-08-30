package org.shvedovva.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.shvedovva.dao.CurrencyDao;
import org.shvedovva.dto.CurrencyDto;
import org.shvedovva.services.CurrencyService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/currency/*")
public class CurrencyController extends HttpServlet {
    private CurrencyDao dao = new CurrencyDao();
    private CurrencyService service = new CurrencyService(dao);
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getPathInfo().substring(1);
        CurrencyDto dto = service.findByCode(code);
        PrintWriter writer = resp.getWriter();
        writer.println(dto);
    }
}
