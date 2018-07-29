/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Canchito
 */

@WebListener
public class MyListener implements ServletContextListener {
    //todo los servlet tienen la misma sesion en el contexto
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        String nombreContexto = ctx.getInitParameter("basededatos");
        ctx.setAttribute("bd", nombreContexto);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
    
}
