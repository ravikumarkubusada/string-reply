package com.beta.replyservice.service.impl;

import com.beta.replyservice.service.MessageFactory;

public class ReverseMessageImpl implements MessageFactory {
    @Override
    public String process(String message) {
        return new StringBuilder(message).reverse().toString();
    }
}
