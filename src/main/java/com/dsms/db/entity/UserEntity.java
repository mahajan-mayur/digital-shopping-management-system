package com.dsms.db.entity;

import com.dsms.enums.UserType;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Mahaj
 */
@Entity
@Table(name = "userEntity")
@Getter 
@Setter 
@Builder
@NoArgsConstructor 
@AllArgsConstructor
public class UserEntity extends TimestampedEntity {

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
    
    @Column(name = "password",  nullable = false)
    private String password;

    @Column(name = "address", nullable = false, columnDefinition = "TEXT")
    private String address;
    
    @OneToMany(mappedBy = "userEntity")
    private Set<OrderEntity> orders;

    @OneToMany(mappedBy = "userEntity")
    private Set<WishlistItem> wishlistItems;
    
    @OneToMany(mappedBy = "userEntity")
    private Set<CartItem> cartItems;
}
