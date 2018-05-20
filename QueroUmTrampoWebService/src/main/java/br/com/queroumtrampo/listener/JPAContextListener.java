package br.com.queroumtrampo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.com.queroumtrampo.util.JPAUtil;

public class JPAContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent context) {
		JPAUtil.closeEntityManagerFactory();
	}

	@Override
	public void contextInitialized(ServletContextEvent context) {
		JPAUtil.createEntityManagerFactory();
	}
}
