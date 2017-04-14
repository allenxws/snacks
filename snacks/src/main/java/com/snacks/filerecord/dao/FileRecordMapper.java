package com.snacks.filerecord.dao;

import com.snacks.filerecord.domain.FileRecord;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * Created by xuwushun on 2016/11/3.
 */
@Mapper
public interface FileRecordMapper {
	@Select({
			"select id, file_name, url, file_type, is_deleted, create_time, update_time from file_record where is_deleted = 0 and id = #{id} limit 1"
	})
	@Results({
			@Result(property = "id", column = "id", id = true),
			@Result(property = "fileName", column = "file_name"),
			@Result(property = "url", column = "url"),
			@Result(property = "fileType", column = "file_type"),
			@Result(property = "isDeleted", column = "is_deleted"),
			@Result(property = "createTime", column = "create_time"),
			@Result(property = "updateTime", column = "update_time")
	})
	FileRecord selectByPrimaryKey(@Param("id") Long id);

	@Select({
			"select url from file_record where is_deleted = 0 and id in ${ids}"
	})
	List<String> batchGetFileUrlById(@Param("ids") String ids);
}
