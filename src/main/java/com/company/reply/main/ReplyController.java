package com.company.reply.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.reply.dto.ReplyDTO;
import com.company.reply.service.ReplyService;

@RestController
public class ReplyController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@Inject
	private ReplyService replyService;
	
	@RequestMapping(value="replyList", method=RequestMethod.POST)
	public List<ReplyDTO> replyLise(@RequestParam("borderId")int borderId) throws Exception {
		logger.info("Reply List Call");
		return replyService.replyList(borderId);
	}
	
	@RequestMapping(value="replyWrite", method=RequestMethod.POST)
	public Map<String, Object> replyWrite(@RequestBody ReplyDTO replyDTO) throws Exception {
		logger.info("Reply Write");
		Map<String, Object> result = new HashMap<>();
		try {
			replyService.replyWrite(replyDTO);
			result.put("status","OK");
		}catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");
		}
		return result;
	}
	
}