package com.nvl.service;

import com.nvl.pojo.MenuOrder;
import java.util.List;
import java.util.Map;

public interface MailService
{
	public void sendEmail(final int type, final String email, final List<MenuOrder> order);
}
