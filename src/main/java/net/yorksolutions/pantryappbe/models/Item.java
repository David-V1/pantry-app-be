package net.yorksolutions.pantryappbe.models;

import jakarta.persistence.*;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "image", length = 10000)
    private String image;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "metric")
    private String metric;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "calories")
    private Integer calories;

    @Column(name = "category")
    private String category;

    @ManyToOne(optional = false)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    public Item(Long id, String name, String image, Double weight, String metric, Integer quantity, Integer calories, String category, Account account) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.weight = weight;
        this.metric = metric;
        this.quantity = quantity;
        this.calories = calories;
        this.category = category;
        this.account = account;
    }

    public Item() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getWeight() {
        return weight;
    }

    public String getMetric() {
        return metric;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
