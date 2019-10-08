package com.company.reply.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.border.service.BorderService;
import com.company.reply.dto.ReplyDTO;
import com.company.reply.service.ReplyService;
import com.company.user.dto.UserDTO;

@RestController
public class ReplyController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@Inject
	private ReplyService replyService;
	@Inject
	private BorderService borderService;
	
	@RequestMapping(value="replyList", method=RequestMethod.POST)
	public List<ReplyDTO> replyLise(@RequestParam("borderId")int borderId) throws Exception {
		logger.info("Reply List Call");
		System.out.println(borderId);
		return replyService.replyList(borderId);
	}
	
	@RequestMapping(value="replyWrite", method=RequestMethod.POST)
	public Map<String, Object> replyWrite(@RequestBody ReplyDTO replyDTO,Model model) throws Exception {
		logger.info("Reply Write");
		Map<String, Object> result = new HashMap<>();
		int bId =replyDTO.getBorderId();
		System.out.println(bId);
		try {
			borderService.replyCnt(bId);
			replyService.replyWrite(replyDTO);
			model.addAttribute("replyId",replyDTO.getReplyId());
			result.put("status","OK");
		}catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");
		}
		return result;
	}
	@RequestMapping(value="replyUpdate", method=RequestMethod.POST)
	public int replyUpdate(@RequestBody ReplyDTO replyDTO,@RequestBody UserDTO userDTO) throws Exception {
		logger.info("reply Update");
		//Map<String, Object> result = new HashMap<>();
		if(replyDTO.getUserId().equals(userDTO.getUserId())) {
			return replyService.replyUpdate(replyDTO);
		}
		return -1;
		
	}
//	@RequestMapping(value="replyDelete")
//	public int replyDelete(@RequestParam("replyId")int replyId, @RequestParam("borderId")int borderId) throws Exception {
//		logger.info("reply Delete");
////		Map<String, Object> result = new HashMap<>();
////		try {
////			System.out.println(borderId);
////			borderService.replyDeleteCnt(borderId);
////			replyService.replyDelete(replyId);
////			result.put("status","OK");
////		}catch (Exception e) {
////			e.printStackTrace();
////			result.put("status", "False");
////		}
////		return result;
//		borderService.replyDeleteCnt(borderId);
//		return replyService.replyDelete(replyId);
//	}
	@RequestMapping(value="replyDelete")
	public int replyDelete(@RequestParam("replyId")int replyId, @RequestParam("borderId")int borderId) throws Exception {
		logger.info("Reply Delete");
		borderService.replyDeleteCnt(borderId);
		return replyService.replyDelete(replyId);
	}
}