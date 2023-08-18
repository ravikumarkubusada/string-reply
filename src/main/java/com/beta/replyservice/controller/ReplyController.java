package com.beta.replyservice.controller;

import com.beta.replyservice.dto.response.ReplyMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/reply")
public class ReplyController {

	@GetMapping()
	public ResponseEntity<ReplyMessage> replying() {
		return ResponseEntity.badRequest().body(new ReplyMessage(ReplyMessage.MESSAGE_EMPTY));
	}

	@GetMapping("/{message}")
	public ResponseEntity<ReplyMessage> replying(@PathVariable String message) {
		return ResponseEntity.ok(new ReplyMessage(message));
	}
}