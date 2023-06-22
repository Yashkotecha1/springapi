package org.example.model;

import jakarta.persistence.*;


@Entity
public class BillingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @Override
    public String toString() {
        return "BillingModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prize=" + prize +
                '}';
    }

    private Long prize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrize() {
        return prize;
    }

    public void setPrize(Long prize) {
        this.prize = prize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
