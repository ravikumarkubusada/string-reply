package com.beta.replyservice.controller;

import com.beta.replyservice.dto.response.ReplyMessage;
import com.beta.replyservice.service.ReplyV2Service;
import com.beta.replyservice.service.impl.ReplyV2ServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReplyV2ControllerTest {

    @InjectMocks
    ReplyV2Controller replyV2Controller;

    @BeforeEach
    public void init() {
        ReplyV2Service replyService = new ReplyV2ServiceImpl();
        replyV2Controller = new ReplyV2Controller(replyService);
    }

    @Test
    void replyingEmptyTest() {

        ResponseEntity<ReplyMessage> replying = replyV2Controller.replying();
        assertEquals(ReplyMessage.MESSAGE_EMPTY, Objects.requireNonNull(replying.getBody()).getMessage());
        assertEquals(HttpStatus.BAD_REQUEST, replying.getStatusCode());
    }

    @Test
    void replyingTest() {
        String message = "11-hello";
        ResponseEntity<ReplyMessage> replying = replyV2Controller.replying(message);
        assertEquals("hello", Objects.requireNonNull(replying.getBody()).getMessage());
        assertEquals(HttpStatus.OK, replying.getStatusCode());
    }

    @Test
    void replyingMD5Test() {
        String message = "12-hello";
        ResponseEntity<ReplyMessage> replying = replyV2Controller.replying(message);
        assertEquals("10e099145e3c91cd94ccb9bdc50d0495", Objects.requireNonNull(replying.getBody()).getMessage());
        assertEquals(HttpStatus.OK, replying.getStatusCode());
    }

    @Test
    void replyingInvalidInputTest() {
        String message = "13-hello";
        ResponseEntity<ReplyMessage> replying = replyV2Controller.replying(message);
        assertEquals(HttpStatus.BAD_REQUEST, replying.getStatusCode());
        assertEquals(ReplyMessage.INVALID_INPUT, Objects.requireNonNull(replying.getBody()).getMessage());
    }

    @Test
    void replyingInvalidInputExceptionTest() {
        String message = "13hello";
        ResponseEntity<ReplyMessage> replying = replyV2Controller.replying(message);
        assertEquals(HttpStatus.BAD_REQUEST, replying.getStatusCode());
        assertEquals(ReplyMessage.INVALID_INPUT, Objects.requireNonNull(replying.getBody()).getMessage());
    }

    @Test
    void replyingInvalidInputException2Test() {
        String message = "hello";
        ResponseEntity<ReplyMessage> replying = replyV2Controller.replying(message);
        assertEquals(HttpStatus.BAD_REQUEST, replying.getStatusCode());
        assertEquals(ReplyMessage.INVALID_INPUT, Objects.requireNonNull(replying.getBody()).getMessage());
    }


}
