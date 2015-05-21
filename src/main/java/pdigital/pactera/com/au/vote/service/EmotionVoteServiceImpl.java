package pdigital.pactera.com.au.vote.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdigital.pactera.com.au.vote.controller.EmotionVoteItem;
import pdigital.pactera.com.au.vote.model.Device;
import pdigital.pactera.com.au.vote.model.DeviceRepository;
import pdigital.pactera.com.au.vote.model.EmotionVote;
import pdigital.pactera.com.au.vote.model.EmotionVoteRepository;
import pdigital.pactera.com.au.vote.model.User;
import pdigital.pactera.com.au.vote.model.UserRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The implementation for EmotionVoteService
 */
@Service
public class EmotionVoteServiceImpl implements EmotionVoteService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private UserRepository userRepository;
	private DeviceRepository deviceRepository;
	private EmotionVoteRepository emotionVoteRepository;

	@Autowired
	public EmotionVoteServiceImpl(UserRepository userRepository, DeviceRepository deviceRepository, EmotionVoteRepository emotionVoteRepository) {
		this.userRepository = userRepository;
		this.deviceRepository = deviceRepository;
		this.emotionVoteRepository = emotionVoteRepository;
	}

	/**
	 * get a list of emotions for the specified period
	 * @param period the value would be 24hours, 7days and 30days
	 * @return list a list of emotion vote
	 */
	@Override public List<EmotionVoteItem> getEmotionsByPeriod(String period) {
		List<EmotionVoteItem> emotionVoteItems = new ArrayList<>();
		logger.info("period is "+ period);
		Calendar calendar = Calendar.getInstance();
		Calendar calendarTo = Calendar.getInstance();
		calendarTo.add(Calendar.SECOND,5);
		Date toDate = calendarTo.getTime();

		if(StringUtils.equalsIgnoreCase("24hours", period)){
			calendar.add(Calendar.HOUR_OF_DAY, -24);
		} else if (StringUtils.equalsIgnoreCase("7days", period)){
			calendar.add(Calendar.DAY_OF_YEAR, -7);
		} else if (StringUtils.equalsIgnoreCase("30days", period)){
			calendar.add(Calendar.DAY_OF_YEAR, -30);
		}
		Date fromDate = calendar.getTime();
		emotionVoteItems = emotionVoteRepository.getEmotions(fromDate, toDate);
		return emotionVoteItems;
	}

	/**
	 * Save emotion to the persistence layer
	 * @param deviceId the mobile device id
	 * @param emotionId the emotion id
	 * @return emotionVote the saved emotion vote
	 */
	@Override public EmotionVote saveEmotion(String deviceId, String emotionId) {
		logger.info("deviceId is "+deviceId +"; emotionId is "+emotionId);
		//validate emotion id: Integer and value range is between 0 and 2
		if(StringUtils.isEmpty(emotionId) || Integer.valueOf(emotionId) > 2 || Integer.valueOf(emotionId) < 0){
			throw new RuntimeException("invalid emotionId");
		}

		Device device = deviceRepository.save(new Device(deviceId));
		EmotionVote emotionVote = new EmotionVote(device, emotionId);
		//return emotionVote;
		emotionVote = emotionVoteRepository.save(emotionVote);
		logger.info("the result is "+emotionVote);
		return emotionVote;
	}

	/**
	 * Save emotion to the persistence layer
	 * @param user the user details
	 * @param deviceId the mobile device id
	 * @param emotionId the emotion id
	 * @return emotionVote the saved emotion vote
	 */
	@Override public EmotionVote saveEmotion(User user, String deviceId, String emotionId) {
		logger.info("deviceId is "+deviceId +"; emotionId is "+emotionId+ "user "+user);
		//validate emotion id: Integer and value range is between 0 and 2
		if(StringUtils.isEmpty(emotionId) || Integer.valueOf(emotionId) > 2 || Integer.valueOf(emotionId) < 0){
			throw new RuntimeException("invalid emotionId");
		}

		user = userRepository.save(user);
		Device device = deviceRepository.save(new Device(deviceId,user));

		EmotionVote emotionVote = new EmotionVote(device, emotionId);
		emotionVote = emotionVoteRepository.save(emotionVote);

		//return emotionVote;
		logger.info("the result is "+emotionVote);
		return emotionVote;
	}

}
