package programmerzamannow.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmerzamannow.jpa.entity.Brand;
import programmerzamannow.jpa.util.JpaUtil;

import java.util.List;

public class JpaQueryLangaugeTest {

    @Test
    void select() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<Brand> query = entityManager.createQuery("select b from Brand b", Brand.class);
        List<Brand> brands = query.getResultList();

        for (Brand brand : brands) {
            System.out.println(brand.getId() + " : " + brand.getName());
        }

        entityTransaction.commit();
        entityManager.close();
    }
}
