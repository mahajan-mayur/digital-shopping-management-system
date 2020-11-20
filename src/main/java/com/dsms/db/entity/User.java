package com.dsms.db.entity;

import com.dsms.enums.UserType;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Mahaj
 */
@Entity
@Table(name = "user")
@Getter 
@Setter 
@Builder
@NoArgsConstructor 
@AllArgsConstructor
public class User extends TimestampedEntity implements Serializable {

    private String id;

    @Column(name = "firstName", length = 50, nullable = false)
    private String firstName;

    @Column(name = "lastName", length = 50, nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "userType", nullable = false)
    private UserType userType;

    @Email
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "address", nullable = false, columnDefinition = "TEXT")
    private String address;

}
