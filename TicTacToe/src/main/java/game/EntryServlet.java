/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import game.GameBean;

/**
 *
 * @author Usuario
 */
public class EntryServlet extends HttpServlet{
    /**
* Processes requests for both HTTP &lt;code&gt;GET&lt;/code&gt; and
&lt;code&gt;POST&lt;/code&gt;
* methods.
*
* @param request servlet request
* @param response servlet response
* @throws ServletException if a servlet-specific error occurs
* @throws IOException if an I/O error occurs
*/
    
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        String user = request.getParameter("User");
        boolean userFirst = user != null;

        GameBean game = (GameBean)request.getSession(true).getAttribute("gameBean");
        game.setStartByUser(userFirst);
        game.startGame();
        request.getRequestDispatcher("/game.jsp").forward(request,response);
    }
    
    // &lt;editor-fold defaultstate=&quot;collapsed&quot; desc=&quot;HttpServlet methods.Click on the + sign on the left to edit the code.&quot;&gt;
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
    * Returns a short description of the servlet.
    *
    * @return a String containing servlet description
    */
    @Override
    public String getServletInfo() {
        return "Process initial form response.";
    }// </editor-fold>
}
