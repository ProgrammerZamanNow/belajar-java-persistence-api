package programmerzamannow.jpa.entity;

import java.time.LocalDateTime;

public interface UpdatedAtAware {

    void setUpdatedAt(LocalDateTime updatedAt);
}
