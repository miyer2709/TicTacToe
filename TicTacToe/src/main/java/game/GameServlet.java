/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import game.GameBean;
import game.GameBean.GamePlayer;
/**
 *
 * @author Usuario
 */
public class GameServlet extends HttpServlet{
    /**
        * Processes requests for both HTTP &lt;code&gt;GET&lt;/code&gt; and &lt;code&gt;POST&lt;/code&gt;
        * methods.
        *
        * @param request servlet request
        * @param response servlet response
        * @throws ServletException if a servlet-specific error occurs
        * @throws IOException if an I/O error occurs
        */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        GameBean game = (GameBean) request.getSession(true).getAttribute("gameBean");
        
        int line = Integer.parseInt(request.getParameter("Line"));
        int col = Integer.parseInt(request.getParameter("Col"));
        
        game.playPlayerTurn(line, col);
        
        GamePlayer winner = game.getWinner();
        switch(winner){
            case NOBODY:
                if(game.hasEmptyCell()){
                    game.playComputerTurn();
                    switch(game.getWinner()){
                        case NOBODY:
                            break;
                        case COMPUTER:
                            request.setAttribute("winner", "The computer");
                            break;
                        case USER:
                            request.setAttribute("winner", "You");
                            break;
                    }
                }
                break;
            case COMPUTER:
                request.setAttribute("winner", "The computer");
                break;
            case USER:
                request.setAttribute("winner", "You");
                break;
        }
        if(winner == GamePlayer.NOBODY && !game.hasEmptyCell()){
            request.setAttribute("winner", "Nobody");
        }
        request.getRequestDispatcher("/game.jsp").forward(request, response);
    }
    // &lt;editor-fold defaultstate=&quot;collapsed&quot; desc=&quot;HttpServlet methods. Click on the + sign on the leftto edit the code.&quot;&gt;
    /**
    * Handles the HTTP &lt;code&gt;GET&lt;/code&gt; method.
    *
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException if a servlet-specific error occurs
    * @throws IOException if an I/O error occurs
    */ 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /**
    * Handles the HTTP &lt;code&gt;POST&lt;/code&gt; method.
    *
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException if a servlet-specific error occurs
    * @throws IOException if an I/O error occurs
    */
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /**
    * Returns a short description of the servlet.
    *
    * @return a String containing servlet description
    */
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
        
    
    
    
}
