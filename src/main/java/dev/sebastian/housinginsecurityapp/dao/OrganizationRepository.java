package dev.sebastian.housinginsecurityapp.dao;

import dev.sebastian.housinginsecurityapp.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


@Repository
public class OrganizationRepository implements OrganizationDAO
{
	private final JdbcTemplate jdbcTemplate;

	// ----------------------------------------------------------------------------
	@Autowired
	public OrganizationRepository(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	// ----------------------------------------------------------------------------
	public List<Map<String, Object>> getAllOrganizations()
	{
		final String SELECT_ALL_ORGANIZATIONS = "SELECT * FROM ORGANIZATION";

		return jdbcTemplate.queryForList(SELECT_ALL_ORGANIZATIONS);
	}

	public List<Organization> getOrganizations()
	{
		final String SELECT_ALL_ORGANIZATIONS = "SELECT * FROM ORGANIZATION";

		return jdbcTemplate.query(SELECT_ALL_ORGANIZATIONS, new RowMapper<Organization>()
		{
			@Override
			public Organization mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				Organization org = new Organization();

				org.setId(rs.getInt("id"));
				org.setName(rs.getString("name"));
				org.setStreet(rs.getString("street"));
				org.setBorough(rs.getString("borough"));
				org.setState(rs.getString("state"));
				org.setZipCode(rs.getInt("zip_code"));
				org.setPhoneNumber(rs.getString("phone_number"));
				org.setWebsite(rs.getString("website"));
				org.setDescription(rs.getString("description"));

				return org;
			}
		});
	}
}
