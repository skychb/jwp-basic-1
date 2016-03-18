package next.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import core.jdbc.JdbcTemplate;
import core.jdbc.RowMapper;
import next.model.Answer;


public class AnswerDao {
	public void insert(Answer answer) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        String sql = "INSERT INTO QUESTIONS VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, answer.getAnswerId(),
                answer.getWriter(),
                answer.getContents(),
                answer.getCreatedDate(),
                answer.getQuestionId()
        		);
    }

    public Answer findByUserId(int answerId) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        String sql = "SELECT answerId, writer, contents, createdDate, questionId FROM ANSWERS WHERE userid=?";
        
        RowMapper<Answer> rm = new RowMapper<Answer>() {
            @Override
            public Answer mapRow(ResultSet rs) throws SQLException {
                return new Answer(rs.getInt("answerId"), 
                        rs.getString("writer"), 
                        rs.getString("contents"),
                        rs.getDate("createDate"),
                        rs.getInt("questionId")
                		);
            }
        };
        
        return jdbcTemplate.queryForObject(sql, rm, answerId);
    }

    public List<Answer> findAll() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        String sql = "SELECT answerId, writer, contents, createdDate, questionId FROM ANSWERS";
        
        RowMapper<Answer> rm = new RowMapper<Answer>() {
            @Override
            public Answer mapRow(ResultSet rs) throws SQLException {
                return new Answer(rs.getInt("answerId"), 
                        rs.getString("writer"), 
                        rs.getString("contents"),
                        rs.getDate("createDate"),
                        rs.getInt("questionId"));
            }
        };
        return jdbcTemplate.query(sql, rm);
    }

    public void update(Answer answer) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        String sql = "UPDATE ANSWERS set contents = ?, createdDate = ? WHERE answerId = ?";
        jdbcTemplate.update(sql, answer.getContents(),
                answer.getCreatedDate(),
                answer.getAnswerId());
    }

	public List<Answer> findByQuestionId(String questionId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
        String sql = "SELECT answerId, writer, contents, createdDate, questionId FROM ANSWERS WHERE questionId=?";
        
        RowMapper<Answer> rm = new RowMapper<Answer>() {
            @Override
            public Answer mapRow(ResultSet rs) throws SQLException {
                return new Answer(rs.getInt("answerId"), 
                        rs.getString("writer"), 
                        rs.getString("contents"),
                        rs.getDate("createDate"),
                        Integer.parseInt(questionId)
                		);
            }
        };
        
        return jdbcTemplate.query(sql, rm, questionId);
    }
}
