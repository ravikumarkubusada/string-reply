package com.beta.replyservice.controller;

import com.beta.replyservice.dto.response.ReplyMessage;
import com.beta.replyservice.service.ReplyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is V2 for Reply controller, we have addition feature for the apis
 */
@RestController
@RequestMapping("/v2/reply")
public class ReplyV2Controller {


	private final ReplyService replyService;

	public ReplyV2Controller(ReplyService replyService) {
		this.replyService = replyService;
	}

	/**
	 *
	 * @return
	 */
	@GetMapping()
	public ResponseEntity<ReplyMessage> replying() {
		return ResponseEntity.badRequest().body(new ReplyMessage(ReplyMessage.MESSAGE_EMPTY));
	}

	/**
	 *
	 * @param message
	 * @return
	 */
	@GetMapping("/{message}")
	public ResponseEntity<ReplyMessage> replying(@PathVariable String message) {
		return replyService.checkAndReply(message);
	}
}