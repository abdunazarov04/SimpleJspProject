package uz.isystem.repository;

import jakarta.persistence.*;
import uz.isystem.model.Users;

public class UserRepository {

    public Users save(Users user) {
        EntityManagerFactory aDefault = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = aDefault.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Users merge = null;
        try {
            transaction.begin();
            if (user.getId() == null) {
                entityManager.persist(user);
            } else {
                merge = entityManager.merge(user);
                return merge;
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return merge;
    }

    public Users findByUsername(String username) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Users user = null;

        try {
            transaction.begin();

            Query query = entityManager.createQuery("SELECT u FROM Users u WHERE u.username = :login");
            query.setParameter("login", username);

            user = (Users) query.getSingleResult();
            transaction.commit();
        } catch (NoResultException e) {
            transaction.rollback();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

        return user;
    }

    public boolean exists(Users users) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        boolean exists = false;

        try {
            transaction.begin();
            Query query = entityManager.createQuery("SELECT COUNT(u) FROM Users u WHERE u.username = :login");
            query.setParameter("login", users.getUsername());

            Long count = (Long) query.getSingleResult();
            exists = count > 0;

            transaction.commit();
        } catch (NoResultException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

        return exists;
    }

}
