package pdigital.pactera.com.au.vote.model;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * The repository for emotion vote
 */

@Repository
@Transactional
public class CommentCategoryRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public CommentCategory save(CommentCategory commentCategory) {
		return entityManager.merge(commentCategory);
	}

}
