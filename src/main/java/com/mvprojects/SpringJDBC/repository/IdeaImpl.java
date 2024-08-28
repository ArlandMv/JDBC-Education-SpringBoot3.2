package com.mvprojects.SpringJDBC.repository;

import com.mvprojects.SpringJDBC.model.Idea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class IdeaImpl implements IdeaRepository
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /* //without Autowiring private JdbcTemplate template;
    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }*/

    private static final RowMapper<Idea> IDEA_ROW_MAPPER = new RowMapper<Idea>() {
        @Override
        public Idea mapRow(ResultSet rs, int rowNum) throws SQLException {
            Idea idea = new Idea();
            idea.setIdeaId(rs.getInt("idea_id"));
            idea.setTitle(rs.getString("title"));
            idea.setHow(rs.getString("how"));
            idea.setWhy(rs.getString("why"));
            idea.setCategory(rs.getString("category"));
            return idea;
        }
        /* jdbcTemplate.query(sql, (rs, rowNum) -> {
            Idea x = new Idea();
            x.setIdeaId(rs.getInt(1));
            x.setTitle(rs.getString(2));
            x.setHow(rs.getString(3));
            x.setWhy(rs.getString(4));
            x.setCategory(rs.getString(5));
            return x;
        })); */
    };

    @Override
    public Optional<Idea> findById(int ideaId) {
        String sql = "SELECT * FROM idea WHERE idea_id = ?";
        List<Idea> results = jdbcTemplate.query(sql, IDEA_ROW_MAPPER, ideaId);
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
        //return Optional.empty();
    }

    @Override
    public List<Idea> findAll() {
        String sql = "SELECT * FROM idea";
        return jdbcTemplate.query(sql, IDEA_ROW_MAPPER);
    }

    @Override
    public void save(Idea idea) {
        String sql = "INSERT INTO idea (title, how, why, category) VALUES (?,?,?,?)";
        int rows = jdbcTemplate.update(sql, idea.getTitle(), idea.getHow(), idea.getWhy(), idea.getCategory());
        System.out.println(rows + " row/s affected.");
    }

    @Override
    public void update(Idea idea) {
        String sql = "UPDATE idea SET title = ?, how = ?, why = ?, category = ? WHERE idea_id = ?";
        jdbcTemplate.update(sql, idea.getTitle(), idea.getHow(), idea.getWhy(), idea.getCategory(), idea.getIdeaId());
        System.out.println("Updated Idea with ID: " + idea.getIdeaId());
    }

    @Override
    public void delete(int ideaId) {
        System.out.println("delete by ID");
        String sql = "DELETE FROM idea WHERE idea_id = ?";
        jdbcTemplate.update(sql, ideaId );
        System.out.println("Deleted Idea with ID: " + ideaId);
    }
}
