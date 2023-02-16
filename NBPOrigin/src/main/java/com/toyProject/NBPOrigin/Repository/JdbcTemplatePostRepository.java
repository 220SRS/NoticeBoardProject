package com.toyProject.NBPOrigin.Repository;

import com.toyProject.NBPOrigin.model.Post;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class JdbcTemplatePostRepository implements PostRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplatePostRepository(DataSource dataSource) {

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Post save(Post post) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("post").usingGeneratedKeyColumns("postId");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", post.getTitle());
        parameters.put("body", post.getBody());

        Number key = jdbcInsert.executeAndReturnKey(new
                MapSqlParameterSource(parameters));
        post.setPostId(key.intValue());
        return post;
    }
    //"select * from post where id = ?"
    @Override
    public Post update(int postId, Post post){
        List<Post> result = jdbcTemplate.query("update * set body = ? from post where id = ?",
                postRowMapper(), post.getBody(), postId);
                Optional<Post> post1 = result.stream().findAny();

        return post1.orElse(null);
    }

    @Override
    public void delete(int postId){
        jdbcTemplate.query("delete from post where id = ?",
                postRowMapper(), postId);
    }

    @Override
    public Optional<Post> findById(int id) {
        List<Post> result = jdbcTemplate.query("select * from post where id = ?",
                postRowMapper(), id);
        return result.stream().findAny();
    }
    @Override
    public List<Post> findAll() {
        return jdbcTemplate.query("select * from post", postRowMapper());
    }

    @Override
    public Optional<Post> findByTitle(String title) {
        List<Post> result = jdbcTemplate.query("select * from post where title = ?",
                postRowMapper(), title);
        return result.stream().findAny();
    }
    private RowMapper<Post> postRowMapper() {
        return (rs, rowNum) -> {
            Post post = new Post();
            post.setPostId(rs.getInt("id"));
            post.setTitle(rs.getString("title"));
            post.setBody(rs.getString("body"));
            return post;
        };
    }
}
