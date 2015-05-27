package pdigital.pactera.com.au.vote.controller;

import pdigital.pactera.com.au.vote.model.VoteComment;

import java.util.List;

/**
 * Created by liny1 on 27/05/201 .
 */
public class VoteCommentList {
	private Integer voteId;
	private List<VoteComment> voteCommentList;

	public Integer getVoteId() {
		return voteId;
	}

	public void setVoteId(Integer voteId) {
		this.voteId = voteId;
	}

	public List<VoteComment> getVoteCommentList() {
		return voteCommentList;
	}

	public void setVoteCommentList(List<VoteComment> voteCommentList) {
		this.voteCommentList = voteCommentList;
	}
}
