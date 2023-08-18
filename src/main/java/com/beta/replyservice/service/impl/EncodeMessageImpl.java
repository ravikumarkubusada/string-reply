package com.beta.replyservice.service.impl;

import com.beta.replyservice.service.MessageFactory;
import com.beta.replyservice.util.MD5;

public class EncodeMessageImpl implements MessageFactory {
    @Override
    public String process(String message) {
        return MD5.encode(message);
    }
}
