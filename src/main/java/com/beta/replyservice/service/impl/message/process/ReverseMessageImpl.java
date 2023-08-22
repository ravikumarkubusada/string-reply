package com.beta.replyservice.service.impl.message.process;

import com.beta.replyservice.service.MessageFactory;

/**
 *
 */
public class ReverseMessageImpl implements MessageFactory {
    /**
     *
     * @param message
     * @return
     */
    @Override
    public String process(String message) {
        return new StringBuilder(message).reverse().toString();
    }
}
