package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.GameMain;
/**
 * @author Adi
 */
@WebServlet(name = "GameController", urlPatterns = {"/gc"})
public class GameController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cellId = request.getParameter("cellId");
        HttpSession sess = request.getSession();
        GameMain g = (GameMain) sess.getAttribute("board");
        if ("0".equals(cellId)) {
            int size = Integer.parseInt(request.getParameter("size"));
            request.setAttribute("test", size);
            g.initGame(size);
        } else
            g.markTile(cellId);
        request.getRequestDispatcher("Index.jsp").forward(request, response);
    }
}