package pdigital.pactera.com.au.vote.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The domain object for emotion vote
 */

@Entity
@Table(name = "vote_comment")
public class VoteComment {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer commentId;

	@JsonIgnore
	@ManyToOne
	private EmotionVote emotionVote;

    @Column(name = "comment")
	private String comment;


	@ManyToOne
	private CommentCategory commentCategory;


	public VoteComment() {
	}


	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public EmotionVote getEmotionVote() {
		return emotionVote;
	}

	public void setEmotionVote(EmotionVote emotionVote) {
		this.emotionVote = emotionVote;
	}


	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public CommentCategory getCommentCategory() {
		return commentCategory;
	}

	public void setCommentCategory(CommentCategory commentCategory) {
		this.commentCategory = commentCategory;
	}

}



