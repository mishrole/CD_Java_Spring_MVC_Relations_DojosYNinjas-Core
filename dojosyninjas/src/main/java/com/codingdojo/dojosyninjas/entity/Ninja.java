package com.codingdojo.dojosyninjas.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="ninjas")
@Data
public class Ninja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 3, max = 200, message = "First name must be at least 3 characters long")
    private String firstName;
    
    @NotNull
    @Size(min = 3, max = 200, message = "Last name must be at least 3 characters long")
    private String lastName;
    
    @NotNull
    @Min(value = 18, message = "Age must be at least 18")
    private int age;
    
    @Column(updatable=false)
    private Date createdAt;
    
    private Date updatedAt;
    
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;
    
    public Ninja() {
        
    }
    
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
    
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

}