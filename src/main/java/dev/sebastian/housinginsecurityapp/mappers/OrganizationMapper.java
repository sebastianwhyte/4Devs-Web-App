package dev.sebastian.housinginsecurityapp.mappers;

import dev.sebastian.housinginsecurityapp.model.Address;
import dev.sebastian.housinginsecurityapp.model.Organization;
import dev.sebastian.housinginsecurityapp.model.Shelter;
import org.springframework.jdbc.core.RowMapper;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class OrganizationMapper implements RowMapper<Organization>
{
	@Override
	public Organization mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		//Organization org = new Organization();
		Organization org = new Shelter();

		org.setId(rs.getInt("id"));
		org.setName(rs.getString("name"));
		/*org.setAddress(new Address(rs.getString("street"),
									rs.getString("borough"),
									rs.getString("state"),
									rs.getInt("zip_code")));*/
		org.setPhoneNumber(rs.getString("phone_number"));

		try
		{
			org.setWebsite(new URI(rs.getString("website")).toURL());

		} catch (MalformedURLException exception)
		{
			System.out.println(" " + exception.getClass()  + ":  URL is malformed. Try verifying the URL for any typos or missing parts.");
		}
		catch (URISyntaxException exception)
		{
			System.out.println(" " + exception.getClass()  + ":  string could not be parsed as a URI reference.");
		}

		return org;
	}
}
