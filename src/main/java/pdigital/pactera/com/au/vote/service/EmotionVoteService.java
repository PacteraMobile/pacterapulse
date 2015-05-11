package pdigital.pactera.com.au.vote.service;

import pdigital.pactera.com.au.vote.controller.EmotionVoteItem;
import pdigital.pactera.com.au.vote.model.EmotionVote;

import java.util.List;

/**
 * The interface for emotion vote service
 */
public interface EmotionVoteService {
	List<EmotionVoteItem> getEmotionsByPeriod(String period);
	EmotionVote saveEmotion(String deviceId, String emotionId);
}
