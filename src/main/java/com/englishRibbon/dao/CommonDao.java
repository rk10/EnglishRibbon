package com.englishRibbon.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * Created by t3wr on 15.03.15.
 */
abstract
public class CommonDao<T>
{
    private String findById = "SELECT * FROM :table WHERE id = :id";
    private String findAll = "SELECT * FROM :table";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    abstract String getTableName();

    abstract T convertRowToObject(ResultSet resultSet);

    abstract Map<String, Object> convertObjectToFieldMap(T obj);

    public T findById(int id)
    {
        return jdbcTemplate.queryForObject(
                findById,
                new Object[]{getTableName(), id},
                new RowMapper<T>() {
                    @Override
                    public T mapRow(ResultSet resultSet, int i) throws SQLException {
                        return convertRowToObject(resultSet);
                    }
                });
    }

    public List<T> findAll()
    {
        return jdbcTemplate.query(
                findAll,
                new Object[]{getTableName()},
                new RowMapper<T>() {
                    @Override
                    public T mapRow(ResultSet resultSet, int i) throws SQLException {
                        return convertRowToObject(resultSet);
                    }
                });
    }



    private void add(StringBuffer fieldsStr, StringBuffer valuesStr, Function<Object, >)
    {

    }

    public void create(T object)
    {
        StringBuffer fieldsStr = new StringBuffer("");
        StringBuffer valuesStr = new StringBuffer("");

        Map<String, Object> mapFields = convertObjectToFieldMap(object);
        Object[] objects = new Object[mapFields.size()];
        int c = 0;
        for(String key : mapFields.keySet()) {
            objects[++c] = mapFields.get(key);
            fieldsStr.append( (fieldsStr.capacity() == 0 ? "" : ",") + key );
            valuesStr.append( (valuesStr.capacity() == 0 ? "" : ",") + "?" );
        }

        String sql = "INSERT INTO " + getTableName() +
                     "(" + fieldsStr.toString() + ") VALUES (" + valuesStr.toString() + ")";
        jdbcTemplate.update(sql, objects);
    }

    public void update(T object)
    {
        StringBuffer updateStr = new StringBuffer("");

        Map<String, Object> mapFields = convertObjectToFieldMap(object);
        Object[] objects = new Object[mapFields.size()];
        int c = 0;
        for(String key : mapFields.keySet()) {
            objects[++c] = mapFields.get(key);
            updateStr.append( (updateStr.capacity() == 0 ? "" : ",") + key + "=" + "?" );
        }

        String sql = "UPDATE " + getTableName() + " SET " +
        jdbcTemplate.update("");
    }

    public void delete(T object) {
        Map<String, Object> mapFields = convertObjectToFieldMap(object);
        jdbcTemplate.update("");
    }
}
