package br.com.queroumtrampo.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = null;

	public static EntityManagerFactory createEntityManagerFactory() {
		try {
			if (emf == null)
				emf = Persistence.createEntityManagerFactory("tcc");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return emf;
	}

	public static void closeEntityManagerFactory() {
		emf.close();
	}
}
