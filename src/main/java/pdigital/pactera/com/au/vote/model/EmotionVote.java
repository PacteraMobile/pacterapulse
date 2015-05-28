package pdigital.pactera.com.au.vote.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The domain object for emotion vote
 */

@Entity
@Table(name = "emotion_vote")
public class EmotionVote {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer voteId;

	@JsonIgnore
	@ManyToOne
	private Device device;

	@Column(name = "emotion")
	private String emotion;


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "emotionVote")
	private List<VoteComment> voteComments = new ArrayList<>();


	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Australia/Sydney")
	@Column(name = "date_submitted")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateSubmitted;

	public EmotionVote() {
	}

	public EmotionVote(Device device, String emotion) {
		this.device = device;
		this.emotion = emotion;
		dateSubmitted = Calendar.getInstance().getTime();
	}

	public Device getDevice() {
		return device;
	}

	public Integer getVoteId() {
		return voteId;
	}

	public void setVoteId(Integer voteId) {
		this.voteId = voteId;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public String getEmotion() {
		return emotion;
	}

	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}

	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	public List<VoteComment> getVoteComments() {
		return voteComments;
	}

	public void setVoteComments(List<VoteComment> voteComments) {
		this.voteComments = voteComments;
	}

	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}




	@Override public String toString() {
		return "EmotionVote{" +
				"voteId=" + voteId +
				", device=" + device +
				", emotion='" + emotion + '\'' +
				", dateSubmitted=" + dateSubmitted +
				'}';
	}
}



