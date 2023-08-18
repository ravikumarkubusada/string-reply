package com.beta.replyservice.service;

import com.beta.replyservice.dto.response.ReplyMessage;
import org.springframework.http.ResponseEntity;

public interface ReplyService {
    ResponseEntity<ReplyMessage> checkAndReply(String message);
}
