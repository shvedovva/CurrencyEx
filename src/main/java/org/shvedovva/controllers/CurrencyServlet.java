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
public class CurrencyServlet extends HttpServlet {
    private CurrencyDao dao = new CurrencyDao();
    private CurrencyService service = new CurrencyService(dao);
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String code = req.getPathInfo().substring(1).toUpperCase();
        CurrencyDto dto = service.findByCode(code);
        PrintWriter writer = resp.getWriter();
        writer.println(dto);
    }
}
/*
@WebServlet("/currency/*")
public class SingleCurrencyController extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    private CurrencyService currencyService = new CurrencyService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            String errorJson = objectMapper.writeValueAsString(Map.of("message", "Currency code is required"));
            resp.getWriter().write(errorJson);
            return;
        }

        String code = pathInfo.substring(1).toUpperCase();

        try {
            Currency currency = currencyService.getCurrencyByCode(code);

            if (currency == null) {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                String errorJson = objectMapper.writeValueAsString(Map.of("message", "Currency not found"));
                resp.getWriter().write(errorJson);
                return;
            }

            String json = objectMapper.writeValueAsString(currency);
            resp.getWriter().write(json);
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            String errorJson = objectMapper.writeValueAsString(Map.of("message", "Error fetching currency"));
            resp.getWriter().write(errorJson);
        }
    }
}
*/