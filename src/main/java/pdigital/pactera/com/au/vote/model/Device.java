package pdigital.pactera.com.au.vote.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * The domain object for mobile device
 */

@Entity
@Table(name = "device")
public class Device {

	@OneToMany(mappedBy = "device")
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

	public Device(String deviceId) {
		this.deviceId = deviceId;
	}

	public Device() {
	}
}



