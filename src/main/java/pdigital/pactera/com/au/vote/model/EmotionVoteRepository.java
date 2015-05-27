package pdigital.pactera.com.au.vote.model;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import pdigital.pactera.com.au.vote.controller.EmotionVoteItem;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The repository for emotion vote
 */

@Repository
@Transactional
public class EmotionVoteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public EmotionVote save(EmotionVote emotionVote) {
		entityManager.persist(emotionVote);
		return emotionVote;
	}

	/**
	 * Get emotions for the specific period
	 * @param fromDate from date time
	 * @param toDate to date time
	 * @return list a list of Emotion Vote Items
	 */
	public List<EmotionVoteItem> getEmotions(Date fromDate, Date toDate) {
		Query query = entityManager.createQuery("select ev.emotion, count(ev) FROM EmotionVote ev WHERE ev.dateSubmitted BETWEEN :fromDate AND :toDate GROUP BY ev.emotion");
		query.setParameter("fromDate", fromDate);
		query.setParameter("toDate", toDate);
		List<Object[]> results = query.getResultList();
		return transformResults(results);
	}


	/**
	 * transform the JPA query result into domain objects
	 * @param results the JPA query result list
	 * @return list
	 */
	private List<EmotionVoteItem> transformResults(List<Object[]> results) {
		//To make is easier for Android implementation, the list will always have the default counts for the 3 emotions
		if(CollectionUtils.isEmpty(results)){
			return getDefaultEmotionVoteItems(3);
		}
		List<EmotionVoteItem> emotionVotes = new ArrayList<>(results.size());
		for (int i = 0; i < results.size(); i++) {
			Object[] arr = results.get(i);
			//the first element is Emotion
			String emotion = (String) arr[0];
			//the second element is count
			Long count = (Long)arr[1];
			emotionVotes.add(new EmotionVoteItem(emotion,count));
		}
		return emotionVotes;
	}

	private List<EmotionVoteItem> getDefaultEmotionVoteItems(int size) {
		List<EmotionVoteItem> emotionVotes = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			//the first element is Emotion
			String emotion = i+"";
			//the second element is count
			Long count = 0l;
			emotionVotes.add(new EmotionVoteItem(emotion,count));
		}
		return emotionVotes;
	}

	public EmotionVote findById(Integer voteId) {
		return entityManager.find(EmotionVote.class, voteId);
	}
}
