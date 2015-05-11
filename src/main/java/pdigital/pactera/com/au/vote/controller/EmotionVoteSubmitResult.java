package pdigital.pactera.com.au.vote.controller;

import pdigital.pactera.com.au.vote.model.EmotionVote;

/**
 * The transfer object between API client and backend
 */
public class EmotionVoteSubmitResult {
	private String status;
	private String deviceId;
	private EmotionVote emotionVote;

	public EmotionVoteSubmitResult(String status, String deviceId, EmotionVote emotionVote) {
		this.status = status;
		this.deviceId = deviceId;
		this.emotionVote = emotionVote;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public EmotionVote getEmotionVote() {
		return emotionVote;
	}

	public void setEmotionVote(EmotionVote emotionVote) {
		this.emotionVote = emotionVote;
	}
}
