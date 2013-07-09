package net.ufida.info.mahout.job;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.ufida.info.mahout.model.BasicRemmenderModel;

import org.springframework.jdbc.core.RowMapper;


public class BasicRemmenderModelRowMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		BasicRemmenderModel basicModel = new BasicRemmenderModel();
		basicModel.setUserId(rs.getInt("user_id"));
		basicModel.setProductId(rs.getInt("goods_id"));
		basicModel.setIndicator(rs.getInt("goods_number"));
		return basicModel;
	}
}
