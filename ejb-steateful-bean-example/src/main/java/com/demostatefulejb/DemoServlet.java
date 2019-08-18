package com.demostatefulejb;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/servlet")
public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String localCounterBeanName = "java:global/demostatefulejb-1.0//LocalCounterBean!com.demostatefulejb.LocalCounter";
        LocalCounter localCounterBean1 = null;
        LocalCounter localCounterBean2 = null;
        try {
            Object obj = EjbContextUtils.getBean(localCounterBeanName);
            Object obj2 = EjbContextUtils.getBean(localCounterBeanName);
            localCounterBean1 = (LocalCounter) obj;
            localCounterBean2 = (LocalCounter) obj2;
        } catch (NamingException e) {
            e.printStackTrace();
        }

        if (localCounterBean1 != null) {
            localCounterBean1.increment();
            PrintWriter out = resp.getWriter();
            out.println(localCounterBean1);
            out.println("Operand field of localCounterBean after increment operation: " + localCounterBean1.getOperand());
            localCounterBean1.decrement();
            out.println("Operand field of localCounterBean after decrement operation: " + localCounterBean1.getOperand());
        }
        resp.getWriter().println("-------------------------------------------------------------");
        if (localCounterBean2 != null) {
            localCounterBean2.increment();
            PrintWriter out = resp.getWriter();
            out.println(localCounterBean2);
            out.println("Operand field of localCounterBean after increment operation: " + localCounterBean2.getOperand());
            localCounterBean2.decrement();
            out.println("Operand field of localCounterBean after decrement operation: " + localCounterBean2.getOperand());
        }
        resp.getWriter().println(Objects.equals(localCounterBean1, localCounterBean2));
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
