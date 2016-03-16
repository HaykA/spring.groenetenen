package be.vdab.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CreateTestDataSourceBean.class)
public class DataSourceTest {

	@Autowired
	private DataSource dataSource;
	@Test
	public void getConnection() throws SQLException {
		try (Connection connection = dataSource.getConnection()) {}
	}
}
