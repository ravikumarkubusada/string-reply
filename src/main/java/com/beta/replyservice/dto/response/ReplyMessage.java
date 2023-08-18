package com.beta.replyservice.dto.response;

public class ReplyMessage {

	public static final String MESSAGE_EMPTY="Message is empty";
	public static final String INVALID_INPUT="Invalid input";

	private final String message;

	public ReplyMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}