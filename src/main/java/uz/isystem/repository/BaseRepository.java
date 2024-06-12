package uz.isystem.repository;

import java.sql.SQLException;
import java.util.List;

public abstract class BaseRepository<T> {

    public abstract T getOne(Integer id) throws SQLException;

    public abstract List<T> getAll() throws SQLException;

    public abstract T save(T entity);

    public abstract void delete(Integer id);

    public abstract void update(T entity);

}
