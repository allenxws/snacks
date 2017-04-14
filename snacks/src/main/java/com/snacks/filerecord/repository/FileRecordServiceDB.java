package com.snacks.filerecord.repository;

import com.google.common.collect.Lists;
import com.snacks.common.util.ListUtils;
import com.snacks.filerecord.dao.FileRecordMapper;
import com.snacks.filerecord.domain.FileRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by xuwushun on 2016/11/3.
 */
@Service
public class FileRecordServiceDB {
	@Autowired
	FileRecordMapper fileRecordMapper;

	public FileRecord selectByPrimaryKey(Long id) {
		return fileRecordMapper.selectByPrimaryKey(id);
	}

	public List<String> batchGetFileUrlById(List<Long> ids) {
		if (CollectionUtils.isEmpty(ids)) {
			return Lists.newArrayList();
		}
		return fileRecordMapper.batchGetFileUrlById(ListUtils.idListToString(ids));
	}
}
