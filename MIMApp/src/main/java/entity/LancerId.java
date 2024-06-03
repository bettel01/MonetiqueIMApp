package entity;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.*;

@Embeddable
public class LancerId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "id_user")
    private Integer userId;

    @Column(name = "id_instance_traitement")
    private Integer instanceTraitementId;

    public LancerId() {
    }

    public LancerId(Integer userId, Integer instanceTraitementId) {
        this.userId = userId;
        this.instanceTraitementId = instanceTraitementId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getInstanceTraitementId() {
        return instanceTraitementId;
    }

    public void setInstanceTraitementId(Integer instanceTraitementId) {
        this.instanceTraitementId = instanceTraitementId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        LancerId lancerId = (LancerId) obj;
        return userId.equals(lancerId.userId) && instanceTraitementId.equals(lancerId.instanceTraitementId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, instanceTraitementId);
    }
}
