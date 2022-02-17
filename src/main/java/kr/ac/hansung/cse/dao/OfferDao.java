package kr.ac.hansung.cse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.cse.model.Offer;

@Repository("offerDao")
public class OfferDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// 학년,학기별 이수 총 학점
	public List<Offer> getCredits() {
		String sqlStatement = "select year, semester, sum(credit) from offers GROUP BY year, semester";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setYear(rs.getInt("year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setCredit(rs.getInt("sum(credit)"));
				return offer;
			}
		});
	}

// 상세조회
	@SuppressWarnings("deprecation")
	public List<Offer> getOffer(int year, int semester) {
		String sqlStatement = "select * from offers where year=? and semester=?";
		return jdbcTemplate.query(sqlStatement, new Object[] {year, semester}, new RowMapper<Offer>(){

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

				Offer offer = new Offer();
				offer.setYear(rs.getInt("year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setName(rs.getString("name"));
				offer.setSubject(rs.getString("subject"));
				offer.setProfessor(rs.getString("professor"));
				offer.setCredit(rs.getInt("credit"));
				return offer;
			}
		});
	}

	// 전체 이수 과목
	public List<Offer> getOffers() {
		String sqlStatement = "select * from offers";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

				Offer offer = new Offer();

				offer.setYear(rs.getInt("year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setName(rs.getString("name"));
				offer.setSubject(rs.getString("subject"));
				offer.setProfessor(rs.getString("professor"));
				offer.setCredit(rs.getInt("credit"));

				return offer;

			}
		});
	}

	public boolean insert(Offer insertoffer) {
		int year = insertoffer.getYear();
		int semester = insertoffer.getSemester();
		String name = insertoffer.getName();
		String subject = insertoffer.getSubject();
		String professor = insertoffer.getProfessor();
		int credit = insertoffer.getCredit();

		String sqlStatement = "insert into offers(year, semester, name, subject, professor, credit) value (?,?,?,?,?,?)";
		return (jdbcTemplate.update(sqlStatement,
				new Object[] { year, semester, name, subject, professor, credit }) == 1);

	}

	public int getTotalCredits() {
		String sqlStatement = "select sum(credit) from offers";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}
}
