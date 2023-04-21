package programmerzamannow.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payments")
@Inheritance(strategy = InheritanceType.JOINED)
public class Payment {

    @Id
    private String id;

    private Long amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
