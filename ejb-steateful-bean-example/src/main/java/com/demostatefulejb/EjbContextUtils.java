package com.demostatefulejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public final class EjbContextUtils {
    private static InitialContext context;

    static {
        try {
            context = new InitialContext();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static InitialContext getContext() {
        return context;
    }

    public static Object getBean(String name) throws NamingException {
        return context.lookup(name);
    }
}
