package pdigital.pactera.com.au.vote.model;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * The repository for mobile devices
 */

@Repository
@Transactional
public class UserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public User save(User user) {
		return entityManager.merge(user);
	}

	public User findUserById(String userId) {
		return entityManager.find(User.class, userId);
	}

	public User find(User user) {
		return findUserById(user.getUserId());
	}
}
