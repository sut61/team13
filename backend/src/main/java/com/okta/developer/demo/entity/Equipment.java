package com.okta.developer.demo.entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "Equipment")

public class Equipment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long equipmentId;

    @NotNull(message="String must not be null to be valid")
    @Size(min = 5)
    @Size(max = 40)
    private String equipment;

    public Equipment(){}

    public Equipment(String equipment){
        this.equipment = equipment;
    }
    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

}
