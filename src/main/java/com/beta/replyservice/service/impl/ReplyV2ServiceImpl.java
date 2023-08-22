package com.beta.replyservice.service.impl;

import com.beta.replyservice.constants.CommonConstants;
import com.beta.replyservice.dto.response.ReplyMessage;
import com.beta.replyservice.enums.ProcessTypeEnum;
import com.beta.replyservice.exception.InvalidInputException;
import com.beta.replyservice.service.MessageFactory;
import com.beta.replyservice.service.ReplyV2Service;
import com.beta.replyservice.service.impl.message.process.EncodeMessageImpl;
import com.beta.replyservice.service.impl.message.process.ReverseMessageImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReplyV2ServiceImpl implements ReplyV2Service {

    private final Logger logger = LoggerFactory.getLogger(ReplyV2ServiceImpl.class);

    /**
     * The input string will now be comprised of two components, a rule and a string, separated by a dash (-). Rules always contain two numbers. Each number represents a string operation.
     * The supported numbers are:
     * 1: reverse the string
     * E.g. kbzw9ru becomes ur9wzbk
     * 2: encode the string via MD5 hash algorithm and display as hex
     * E.g. kbzw9ru becomes 0fafeaae780954464c1b29f765861fad
     * The numbers are applied in sequence, i.e. the output of the first rule will serve as the input of the second rule. The numbers can also be repeated,
     * i.e. a rule of 11 would mean reversing the string twice, resulting in no change to the string.
     *
     * @param message
     * @return
     */
    @Override
    public ResponseEntity<ReplyMessage> checkAndReply(String message) {
        try {
            String[] split = message.split(CommonConstants.HYPHEN);
            String[] digits = split[0].split("");
            message = split[1];
            logger.info("splitting the message successful");

            for (String digit : digits) {
                message = getMessageFactory(digit).process(message);
            }
            logger.info("message conversion successful, replying message");
        } catch (Exception e) {
            logger.error("Error in parsing the message:{}, ex: {}", message, e.getMessage());
            return ResponseEntity.badRequest().body(new ReplyMessage(ReplyMessage.INVALID_INPUT));
        }
        return ResponseEntity.ok(new ReplyMessage(message));
    }

    /**
     * @param digit
     * @return
     */
    private static MessageFactory getMessageFactory(String digit) {

        if (digit.equalsIgnoreCase(ProcessTypeEnum.REVERSE.label)) {
            return new ReverseMessageImpl();
        } else if (digit.equalsIgnoreCase(ProcessTypeEnum.ENCODE.label)) {
            return new EncodeMessageImpl();
        } else {
            throw new InvalidInputException(ReplyMessage.INVALID_INPUT);
        }
    }
}
