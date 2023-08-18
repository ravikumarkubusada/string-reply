package com.beta.replyservice.service;

import com.beta.replyservice.dto.response.ReplyMessage;
import org.springframework.http.ResponseEntity;

public interface ReplyV2Service {
    ResponseEntity<ReplyMessage> checkAndReply(String message);
}
