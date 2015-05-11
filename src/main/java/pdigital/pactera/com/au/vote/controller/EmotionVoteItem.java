package pdigital.pactera.com.au.vote.controller;

/**
 * The transfer object between API client and backend
 */
public class EmotionVoteItem {
	private String  emotion;
	private long count;

	public EmotionVoteItem(String emotion, long count) {
		this.emotion = emotion;
		this.count = count;
	}

	public String getEmotion() {
		return emotion;
	}

	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	@Override public String toString() {
		return "EmotionVoteItem{" +
				"emotion='" + emotion + '\'' +
				", count=" + count +
				'}';
	}
}
