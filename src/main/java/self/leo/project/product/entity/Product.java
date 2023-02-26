package self.leo.project.product.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double stock;
    private Double price;
    private String status;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

}
