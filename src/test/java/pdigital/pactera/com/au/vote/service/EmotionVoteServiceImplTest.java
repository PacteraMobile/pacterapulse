package pdigital.pactera.com.au.vote.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pdigital.pactera.com.au.vote.controller.EmotionVoteItem;
import pdigital.pactera.com.au.vote.model.DeviceRepository;
import pdigital.pactera.com.au.vote.model.EmotionVote;
import pdigital.pactera.com.au.vote.model.EmotionVoteRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;

public class EmotionVoteServiceImplTest {

	@Mock
	DeviceRepository deviceRepository;

	@Mock
	EmotionVoteRepository emotionVoteRepository;

	private EmotionVoteService emotionVoteService;

	private ArrayList<EmotionVoteItem> emotionVoteItems;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		emotionVoteItems = initializeEmotionVoteItems();
		emotionVoteService = new EmotionVoteServiceImpl(deviceRepository, emotionVoteRepository);
	}

	/**
	 * initialize the emotion vote item array list
	 *
	 * @return list a list of emotion vote items
	 */
	private ArrayList<EmotionVoteItem> initializeEmotionVoteItems() {
		ArrayList<EmotionVoteItem> emotionVoteItemsList = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			EmotionVoteItem emotionVoteItem = new EmotionVoteItem(i + "", 4);
			emotionVoteItemsList.add(emotionVoteItem);
		}
		return emotionVoteItemsList;
	}

	@Test
	public void testGetEmotionsByPeriod() throws Exception {
		Mockito.when(emotionVoteRepository.getEmotions((Date) any(), (Date) any())).thenReturn(emotionVoteItems);
		List<EmotionVoteItem> emotionVoteItems = emotionVoteService.getEmotionsByPeriod("24hours");
		assertEquals(3, emotionVoteItems.size());
	}

	@Test
	public void testSaveEmotion() throws Exception {
		EmotionVote emotionVote = mock(EmotionVote.class);
		Mockito.when(emotionVoteRepository.save((EmotionVote) any())).thenReturn(emotionVote);
		EmotionVote emotionVote1 = emotionVoteRepository.save(emotionVote);
		assertEquals(emotionVote1, emotionVote);
	}
}