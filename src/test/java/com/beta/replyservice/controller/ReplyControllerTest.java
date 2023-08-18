package com.beta.replyservice.controller;

import com.beta.replyservice.dto.response.ReplyMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReplyControllerTest {

    @InjectMocks
    ReplyController replyController;

    @BeforeEach
    public void init() {
        replyController = new ReplyController();
    }

    @Test
    void replyingEmptyTest() {

        ResponseEntity<ReplyMessage> replying = replyController.replying();
        assertEquals(ReplyMessage.MESSAGE_EMPTY, replying.getBody().getMessage());
        assertEquals(HttpStatus.BAD_REQUEST, replying.getStatusCode());
    }

    @Test
    void replyingTest() {
        String message = "11-hello";
        ResponseEntity<ReplyMessage> replying = replyController.replying(message);
        assertEquals(message, replying.getBody().getMessage());
        assertEquals(HttpStatus.OK, replying.getStatusCode());
    }
}
