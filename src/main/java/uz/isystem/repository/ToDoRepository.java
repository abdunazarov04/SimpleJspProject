package uz.isystem.repository;

import jakarta.persistence.*;
import uz.isystem.model.ToDo;

import java.sql.SQLException;
import java.util.List;

public class ToDoRepository extends BaseRepository<ToDo> {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    public ToDo getOne(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ToDo toDo = null;
        try {
            toDo = entityManager.find(ToDo.class, id);
        } finally {
            entityManager.close();
        }
        return toDo;
    }

    public List<ToDo> getAll() throws SQLException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<ToDo> toDos = null;
        try {
            Query query = entityManager.createQuery("SELECT t FROM ToDo t");
            toDos = query.getResultList();
        } finally {
            entityManager.close();
        }
        return toDos;
    }

    public ToDo save(ToDo entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return entity;
    }

    public void delete(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            ToDo toDo = entityManager.find(ToDo.class, id);
            if (toDo != null) {
                entityManager.remove(toDo);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void update(ToDo entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
