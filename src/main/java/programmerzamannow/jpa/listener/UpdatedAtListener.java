package programmerzamannow.jpa.listener;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import programmerzamannow.jpa.entity.UpdatedAtAware;

import java.time.LocalDateTime;

public class UpdatedAtListener {

    @PrePersist
    @PreUpdate
    public void setLastUpdatedAt(UpdatedAtAware object){
        object.setUpdatedAt(LocalDateTime.now());
    }

}
