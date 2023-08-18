package com.beta.replyservice.dto.response;

public class ReplyMessage {

	private final String message;

	public ReplyMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}