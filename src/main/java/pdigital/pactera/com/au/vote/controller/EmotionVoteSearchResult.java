package pdigital.pactera.com.au.vote.controller;

import java.util.List;

/**
 * The transfer object between API client and backend
 */
public class EmotionVoteSearchResult {
	private String status;
	private List<EmotionVoteItem> emotionVotes;

	public EmotionVoteSearchResult(String status, List<EmotionVoteItem> emotionVotes) {
		this.status = status;
		this.emotionVotes = emotionVotes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<EmotionVoteItem> getEmotionVotes() {
		return emotionVotes;
	}

	public void setEmotionVotes(List<EmotionVoteItem> emotionVotes) {
		this.emotionVotes = emotionVotes;
	}

	@Override public String toString() {
		return "EmotionVoteSearchResult{" +
				"status='" + status + '\'' +
				", emotionVotes=" + emotionVotes +
				'}';
	}
}
