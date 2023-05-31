package hpi.proj1ct.maxivitaminbot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author Jana Metz on 31.05.23
 */
@Data
@Entity (name = "vitaminDatabase Table")
public class Vitamin {
    @NotNull
    @Id
    @Column(nullable = false)
    private Long vitaminId;
    private String vitaminName;
    private String benefit;

    public Long getVitaminId() {
        return vitaminId;
    }

    public void setVitaminId(Long vitaminId) {
        this.vitaminId = vitaminId;
    }

    public String getVitaminName() {
        return vitaminName;
    }

    public void setVitaminName(String vitaminName) {
        this.vitaminName = vitaminName;
    }
    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }
    @Override
    public String toString() {
        return "Vitamin{" +
                "vitaminId=" + vitaminId +
                ", vitaminName='" + vitaminName + '\'' +
                ", lastName='" + benefit + '\'' +
                '}';
    }

}
