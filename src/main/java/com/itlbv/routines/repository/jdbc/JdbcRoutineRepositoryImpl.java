package com.itlbv.routines.repository.jdbc;

import com.itlbv.routines.model.Routine;
import com.itlbv.routines.repository.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcRoutineRepositoryImpl implements RoutineRepository {

    private static final BeanPropertyRowMapper<Routine> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Routine.class);

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final SimpleJdbcInsert simpleInsert;

    @Autowired
    public JdbcRoutineRepositoryImpl(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.simpleInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("routines")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Routine save(Routine routine) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("name", routine.getName())
                .addValue("description", routine.getDescription())
                .addValue("startTime", routine.getStartTime())
                .addValue("endTime", routine.getEndTime())
                .addValue("timeOfDay", routine.getTimeOfDay());
        if (routine.isNew()) {
            Number newId = simpleInsert.executeAndReturnKey(map);
            routine.setId(newId.intValue());
        } else if (namedParameterJdbcTemplate.update(
                "UPDATE routines SET name=:name, description=:description," +
                        "startTime=:startTime, endTime=:endTime," +
                        "timeOfDay=:timeOfDay WHERE id=:id", map) == 0) {
            return null; // TODO should it return Optional?
        }
        return routine;
    }

    @Override
    public Routine get(int id) {
        List<Routine> routines = jdbcTemplate.query("SELECT * FROM routines WHERE id=?", ROW_MAPPER, id);
        return DataAccessUtils.singleResult(routines);
    }

    @Override
    public boolean delete(int id) {
        return (jdbcTemplate.update("DELETE FROM routines WHERE id=?", id)) > 0;
    }

    @Override
    public List<Routine> getAll() {
        return jdbcTemplate.query("SELECT * FROM routines", ROW_MAPPER);
    }
}
