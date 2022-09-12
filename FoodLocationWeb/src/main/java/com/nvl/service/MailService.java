package com.nvl.service;

import java.util.Map;

public interface MailService
{
	public void sendEmail(final int type, final String email, final Map<String, Object> object);
}
