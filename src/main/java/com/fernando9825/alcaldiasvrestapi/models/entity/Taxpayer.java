package com.fernando9825.alcaldiasvrestapi.models.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Taxpayer implements Serializable{

    @Id
    @Pattern(regexp = "[0-9]{8}-[0-9]")
    private String DUI;

    @NotBlank
    @Size(min = 5, max = 255)
    private String name;

    @NotBlank
    @Size(min = 5, max = 255)
    private String address;

    @NotBlank
    @Size(min = 4, max = 20)
    private String department;

    @NotNull
    private double tax;

    // these values are expressed in meters
    private double localWidth;
    private double localLength;

    @Column(insertable = false, updatable = false, nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Calendar createAt;

    public Calendar getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Calendar createAt) {
        this.createAt = createAt;
    }

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String DUI) {
        this.DUI = DUI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getLocalWidth() {
        return localWidth;
    }

    public void setLocalWidth(double localWidth) {
        this.localWidth = localWidth;
    }

    public double getLocalLength() {
        return localLength;
    }

    public void setLocalLength(double localLength) {
        this.localLength = localLength;
    }
}
