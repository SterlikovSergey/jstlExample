package by.sterlikov.jstlexample.servlet;

import by.sterlikov.jstlexample.model.Product;
import by.sterlikov.jstlexample.service.ProductService;
import by.sterlikov.jstlexample.service.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/products")// во множественном
public class ProductServlet extends HttpServlet {
    private ProductService service;

    @Override
    public void init() throws ServletException {
        service = new ProductServiceImpl();
    }

    //findAll,findById,delete
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product first =  new Product();
        first.setName("Apples");
        first.setPrice(30);
        Product second =  new Product();
        first.setName("Bananas");
        first.setPrice(35);

        service.save(first);
        System.out.println("First  " + service.findById(first.getId()));

        service.save(second);
        System.out.println("Second   " + service.findAll());

        service.delete(first.getId());
        System.out.println("All product   " + service.findAll());
        req.getRequestDispatcher("success.jsp").forward(req,resp);

    }


    //create,update
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
