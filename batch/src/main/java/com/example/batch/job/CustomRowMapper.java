package com.example.batch.job;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.example.domain.DataIn;

public class CustomRowMapper implements RowMapper<DataIn> {
	
	 private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private static final String COLUMN_TEXT1 = "text1";
    private static final String COLUMN_TEXT2 = "text2";

    @Override
    public DataIn mapRow(ResultSet resultSet, int i) throws SQLException {
    	log.info("[CustomRowMapper -mapRow]resultSet:"+resultSet);
        DataIn data = new DataIn();
        data.setText1(resultSet.getString(COLUMN_TEXT1));
        data.setText2(resultSet.getString(COLUMN_TEXT2));
        return data;
    }
}
