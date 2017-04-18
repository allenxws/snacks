package com.snacks.common;

import java.util.HashMap;

/**
 * Created by xuwushun on 2016/9/30.
 */
public class ThreadContextHolder {
	public static final ThreadLocal threadLocal = new ThreadLocal();
	public static final String USER_ID = "userId";

	public static void setCurrentUserId(Long userId) {
		HashMap paramMap = (HashMap) threadLocal.get();
		if (null == paramMap) {
			paramMap = new HashMap();
		}
		paramMap.put(USER_ID, userId);
		threadLocal.set(paramMap);
	}

	public static Long getCurrentUserId() {
		HashMap paramMap = (HashMap) threadLocal.get();
		if (null == paramMap) {
			return null;
		}
		return (Long) paramMap.get(USER_ID);
	}
}
