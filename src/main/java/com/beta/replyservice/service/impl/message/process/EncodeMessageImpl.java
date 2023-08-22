package com.beta.replyservice.service.impl.message.process;

import com.beta.replyservice.service.MessageFactory;
import com.beta.replyservice.util.MD5;

/**
 *
 */
public class EncodeMessageImpl implements MessageFactory {
    /**
     *
     * @param message
     * @return
     */
    @Override
    public String process(String message) {
        return MD5.encode(message);
    }
}
