package br.com.queroumtrampo.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import br.com.queroumtrampo.util.JPAUtil;

public abstract class GenericDAO<T> implements Serializable {
	/**
	 * N�mero serial.
	 */
	private static final long serialVersionUID = 1L;
	private static final EntityManagerFactory emf = JPAUtil.createEntityManagerFactory();

	private EntityManager em;
	private Class<T> entityClass;

	public GenericDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected void beginTransaction() {
		em = emf.createEntityManager();
		em.getTransaction().begin();
	}

	protected void commit() {
		em.getTransaction().commit();
	}

	protected void rollback() {
		em.getTransaction().rollback();
	}

	protected void closeTransaction() {
		em.close();
	}

	protected void commitAndCloseTransaction() {
		commit();
		closeTransaction();
	}

	protected void flush() {
		em.flush();
	}

	protected void joinTransaction() {
		em = emf.createEntityManager();
		em.joinTransaction();
	}

	protected void save(T entity) {
		em.persist(entity);
	}

	protected void delete(Object id, Class<T> classe) {
		T entityToBeRemoved = em.getReference(classe, id);
		em.remove(entityToBeRemoved);
	}

	protected T update(T entity) {
		return em.merge(entity);
	}

	protected T find(int entityID) {
		return em.find(entityClass, entityID);
	}

	protected T findReferenceOnly(int entityID) {
		return em.getReference(entityClass, entityID);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected List<T> findAll() {
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return em.createQuery(cq).getResultList();
	}

	@SuppressWarnings("unchecked")
	protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
		T result = null;

		try {
			Query query = em.createNamedQuery(namedQuery);

			if (parameters != null && !parameters.isEmpty())
				populateQueryParameters(query, parameters);

			result = (T) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("No result found for named query: " + namedQuery);
		} catch (Exception e) {
			System.out.println("Error while running query: " + e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	private void populateQueryParameters(Query query, Map<String, Object> parameters) {
		for (Entry<String, Object> entry : parameters.entrySet())
			query.setParameter(entry.getKey(), entry.getValue());
	}
}
