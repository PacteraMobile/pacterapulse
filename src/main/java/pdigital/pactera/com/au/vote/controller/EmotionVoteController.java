package pdigital.pactera.com.au.vote.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pdigital.pactera.com.au.vote.model.EmotionVote;
import pdigital.pactera.com.au.vote.model.User;
import pdigital.pactera.com.au.vote.model.VoteComment;
import pdigital.pactera.com.au.vote.service.EmotionVoteService;

import java.util.List;

@Controller
public class EmotionVoteController {

	private EmotionVoteService emotionVoteService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public EmotionVoteController(EmotionVoteService emotionVoteService) {
		this.emotionVoteService = emotionVoteService;
	}

	@RequestMapping(value = "emotions/{deviceId}/{emotionId}", method = { RequestMethod.POST })
	public @ResponseBody EmotionVoteSubmitResult save(@PathVariable String deviceId, @PathVariable String emotionId) {
		EmotionVote emotionVote = emotionVoteService.saveEmotion(deviceId, emotionId);
		//construct response
		EmotionVoteSubmitResult emotionVoteSubmitResult = new EmotionVoteSubmitResult("OK", deviceId, emotionVote);
		return emotionVoteSubmitResult;
	}

	@RequestMapping(value = "emotions/{userId}/{deviceId}/{emotionId}", method = { RequestMethod.POST })
	public @ResponseBody EmotionVoteSubmitResult save(@PathVariable String userId, @PathVariable String deviceId, @PathVariable String emotionId) {
		//construct user
		User user = new User(userId);
		EmotionVote emotionVote = emotionVoteService.saveEmotion(user, deviceId, emotionId);
		//construct response
		EmotionVoteSubmitResult emotionVoteSubmitResult = new EmotionVoteSubmitResult("OK", deviceId, emotionVote);
		return emotionVoteSubmitResult;
	}

	@RequestMapping(value = "emotions/{voteId}", method = { RequestMethod.PUT }, consumes = "application/json")
	public @ResponseBody EmotionVoteSubmitResult save(@PathVariable Integer voteId, @RequestBody List<VoteComment> voteComments) {
		//construct user
		EmotionVote emotionVote = emotionVoteService.saveEmotionComments(voteId, voteComments);
		//construct response
		EmotionVoteSubmitResult emotionVoteSubmitResult = new EmotionVoteSubmitResult("OK", "", emotionVote);
		return emotionVoteSubmitResult;
	}

	@RequestMapping(value = "emotions/{period}", method = { RequestMethod.GET })
	public @ResponseBody EmotionVoteSearchResult getEmotions(@PathVariable String period) {
		List<EmotionVoteItem> emotionVotes = emotionVoteService.getEmotionsByPeriod(period);
		EmotionVoteSearchResult emotionVoteSearchResult = new EmotionVoteSearchResult("OK", emotionVotes);
		logger.info("getEmotions result is "+emotionVoteSearchResult);
		return emotionVoteSearchResult;
	}

	@RequestMapping(value = "emotions/{userId}/{period}", method = { RequestMethod.GET })
	public @ResponseBody EmotionVoteSearchResult getEmotionsByUser(@PathVariable String userId, @PathVariable String period) {
		List<EmotionVoteItem> emotionVotes = emotionVoteService.getEmotionsByPeriod(period);
		EmotionVoteSearchResult emotionVoteSearchResult = new EmotionVoteSearchResult("OK", emotionVotes);
		logger.info("getEmotions result is "+emotionVoteSearchResult);
		return emotionVoteSearchResult;
	}


	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String handleException(Exception e) {
		return "bad request";
	}

}
