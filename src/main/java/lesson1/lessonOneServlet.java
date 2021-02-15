package lesson1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "lessonOneServlet", urlPatterns = "/lessonOneServlet")

public class lessonOneServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(lessonOneServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New GET request");
        java.io.PrintWriter writer = resp.getWriter();
        writer.printf("<h1>The items we have</h1>");
        writer.printf("<table>");
        writer.printf("<tr><th>title</th><th>price</th>");

        for (int i = 0; i < 10; i++) {
            Product tmpProd = new Product(i, "product_" + i, Math.random() * 100);
            writer.printf("<tr>");
            writer.printf("<td>%s</td>", tmpProd.getTitle());
            writer.printf("<td>%.2f</td>", tmpProd.getCost());
            writer.printf("</tr>");
        }
        writer.printf("</table>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New POST request");

        resp.getWriter().printf("<h1>New POST request</h1>");
    }
}