package com.learn.springexample.entity;

import com.learn.springexample.dto.Pojo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Getter
@Setter
@ToString
@Entity(name = "products")
@EqualsAndHashCode(callSuper = false)
@SequenceGenerator(name = "products_seq")
@NoArgsConstructor
@Table(indexes = {
        @Index(name = "products_idx_code_unique", columnList = "code", unique = true),
        @Index(name = "products_idx_status", columnList = "status")
})
@NamedQueries({
        @NamedQuery(name = "Product.fetchDetailNotNull",
                query = "select p from products p where p.detail is not null"),
        @NamedQuery(name = "Product.fetchDetailLengthGreaterThan2",
                query = "select p from products p where length(p.detail) > 2")
})
@SqlResultSetMapping(
        name = "pojo",
        classes = {
                @ConstructorResult(
                        targetClass = Pojo.class,
                        columns = {
                                @ColumnResult(name = "id", type = Long.class),
                                @ColumnResult(name = "codeAndName", type = String.class),
                                @ColumnResult(name = "detail", type = String.class)
                        }
                )
        }
)
@NamedNativeQueries({
        @NamedNativeQuery(name = "Product.customFetchProductToPojo",
                query = "select p.id , p.code||' : '||p.name as codeAndName, p.detail from products p",
                resultSetMapping = "pojo")
})
public class Product extends CommonEntity {

    @Id
    @GeneratedValue(generator = "products_seq")
    private long id;
    private String code;
    private String name;
    private String detail;


    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "alias_name", length = 50)
    private Set<String> aliasNames = new HashSet<>();


    @Column(length = 1)
    private Status status;

    @RequiredArgsConstructor
    public enum Status {
        APPROVED("A"),
        NOT_APPROVED("N"),
        PENDING("P");

        @Getter
        private final String code;

        public static Product.Status codeToStatus(String code) {
            return Stream.of(Product.Status.values()).parallel()
                    .filter(status -> status.getCode().equalsIgnoreCase(code))
                    .findAny().orElseThrow(() -> new IllegalArgumentException("The code : " + code + " is illegal argument."));

        }
    }

    public Product(String code, String name, Status status) {
        this.code = code;
        this.name = name;
        this.status = status;
    }

    public Product(String code, String name, Status status, String detail) {
        this.code = code;
        this.name = name;
        this.status = status;
        this.detail = detail;
    }




}

