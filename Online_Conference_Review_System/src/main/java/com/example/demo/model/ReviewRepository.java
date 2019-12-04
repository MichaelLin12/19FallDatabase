package com.example.demo.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class ReviewRepository {

    private final String INSERT_REVIEWS_SQL =
            "INSERT INTO reviews VALUES (:email, :paperid, :techmerit, :readability, :originality, :relevance, :overallrecomm, :commentforcommittee, :commentforauthor)";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ReviewTable create(final ReviewTable review) throws Exception {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("email", review.getRevemail())
                .addValue("paperid", review.getPaperid())
                .addValue("techmerit", review.getTechmerit())
                .addValue("readability", review.getReadability())
                .addValue("originality", review.getOriginality())
                .addValue("relevance", review.getRelavance())
                .addValue("overallrecomm", review.getOverallrecomm())
                .addValue("commentforcommittee", review.getCommentforcommittee())
                .addValue("commentforauthor", review.getCommentforauthor());
        namedParameterJdbcTemplate.update(INSERT_REVIEWS_SQL, parameters);
        return review;
    }


}
