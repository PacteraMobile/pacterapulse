package pdigital.pactera.com.au.vote.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * The domain object for mobile device
 */

@Entity
@Table(name = "device")
public class Device {

	@OneToOne
	private User user;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "device")
	private List<EmotionVote> emotionVotes = new ArrayList<>();

	@Id
	@Column(name = "device_id")
	private String deviceId;

	public List<EmotionVote> getEmotionVotes() {
		return emotionVotes;
	}

	public void setEmotionVotes(List<EmotionVote> emotionVotes) {
		this.emotionVotes = emotionVotes;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Device(User user) {
		this.user = user;
	}

	public Device(String deviceId) {
		this.deviceId = deviceId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Device(String deviceId, User user) {
		this.deviceId = deviceId;
		this.user = user;
	}

	public Device() {
	}
}



