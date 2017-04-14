package com.snacks.common.util;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by xuwushun on 2017/4/5.
 */
public class ListUtils {
	public static final String ID_STRING_SEPERATE = ",";

	public static String idListToString(List<Long> ids) {
		return "(" + join(ids, ID_STRING_SEPERATE) + ")";
	}

	public static String[] listStringToArray(List<String> stringList) {
		if (CollectionUtils.isEmpty(stringList)) {
			return null;
		}
		String[] stringArray = new String[stringList.size()];
		for (int i = 0; i < stringList.size(); i++) {
			stringArray[i] = stringList.get(i);
		}
		return stringArray;
	}

	public static List<Long> stringToIdList(String ids) {
		List<Long> idList = Lists.newArrayList();
		if (StringUtils.isEmpty(ids)) {
			return idList;
		}
		String[] idArray = ids.split(ID_STRING_SEPERATE);
		for (String id : idArray) {
			idList.add(Long.valueOf(id));
		}
		return idList;
	}

	public static String join(List<Long> ids, String separator) {
		if (CollectionUtils.isEmpty(ids)) {
			return null;
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (Long id : ids) {
			stringBuilder.append(id + separator);
		}
		stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(separator));
		return stringBuilder.toString();
	}
}
