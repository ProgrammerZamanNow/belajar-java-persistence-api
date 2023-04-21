package programmerzamannow.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmerzamannow.jpa.entity.*;
import programmerzamannow.jpa.util.JpaUtil;

public class InheritanceTest {

    @Test
    void singleTableInsert() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Employee employee = new Employee();
        employee.setId("rina");
        employee.setName("Rina Wati");
        entityManager.persist(employee);

        Manager manager = new Manager();
        manager.setId("joko");
        manager.setName("Jomo Morro");
        manager.setTotalEmployee(10);
        entityManager.persist(manager);

        VicePresident vp = new VicePresident();
        vp.setId("budi");
        vp.setName("Budi Nugraha");
        vp.setTotalManager(5);
        entityManager.persist(vp);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void singleTableFind() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Manager manager = entityManager.find(Manager.class, "joko");
        Assertions.assertEquals("Jomo Morro", manager.getName());

        Employee employee = entityManager.find(Employee.class, "budi");
        VicePresident vicePresident = (VicePresident) employee;
        Assertions.assertEquals("Budi Nugraha", vicePresident.getName());

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void joinedTableInsert() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        PaymentGopay gopay = new PaymentGopay();
        gopay.setId("gopay1");
        gopay.setAmount(100_000L);
        gopay.setGopayId("089999999999");
        entityManager.persist(gopay);

        PaymentCreditCard creditCard = new PaymentCreditCard();
        creditCard.setId("cc1");
        creditCard.setAmount(500_000L);
        creditCard.setMaskedCard("4555-5555");
        creditCard.setBank("BCA");
        entityManager.persist(creditCard);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void joinedTableFind() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        PaymentGopay gopay = entityManager.find(PaymentGopay.class, "gopay1");
        PaymentCreditCard creditCard = entityManager.find(PaymentCreditCard.class, "cc1");

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void joinedTableFindParent() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Payment gopay = entityManager.find(Payment.class, "gopay1");

        entityTransaction.commit();
        entityManager.close();
    }
}
