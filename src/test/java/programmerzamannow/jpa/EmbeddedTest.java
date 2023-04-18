package programmerzamannow.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;
import programmerzamannow.jpa.entity.Customer;
import programmerzamannow.jpa.entity.Member;
import programmerzamannow.jpa.entity.Name;
import programmerzamannow.jpa.util.JpaUtil;

public class EmbeddedTest {

    @Test
    void embedded() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Name name = new Name();
        name.setTitle("Mr");
        name.setFirstName("Eko");
        name.setMiddleName("Kurniawan");
        name.setLastName("Khannedy");

        Member member = new Member();
        member.setEmail("eko@example.com");
        member.setName(name);

        entityManager.persist(member);

        entityTransaction.commit();
        entityManager.close();
    }
}
