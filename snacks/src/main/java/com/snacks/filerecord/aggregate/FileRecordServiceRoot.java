package com.snacks.filerecord.aggregate;

import com.snacks.filerecord.domain.FileRecord;
import com.snacks.filerecord.repository.FileRecordServiceDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuwushun on 2017/4/14.
 */
@Service
public class FileRecordServiceRoot {
	@Autowired
	FileRecordServiceDB fileRecordServiceDB;

	public String getFileUrlById(Long id) {
		if (null == id) {
			return null;
		}
		FileRecord fileRecord = fileRecordServiceDB.selectByPrimaryKey(id);
		if (null == fileRecord) {
			return null;
		}
		return fileRecord.getUrl();
	}

	public List<String> batchGetFileUrlById(List<Long> ids) {
		return fileRecordServiceDB.batchGetFileUrlById(ids);
	}
}
