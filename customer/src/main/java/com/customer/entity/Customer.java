package com.customer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @NotNull(message = "Name is mandatory")
    @Column(nullable = false) // Adds NOT NULL constraint in the database
    private String name;

    @NotNull(message = "Email is mandatory")
    @Column(nullable = false, unique = true) 
    private String email;

    @NotNull(message = "Password is mandatory")
    @Size(min = 6, message = "Password should have at least 6 characters")
    @Column(nullable = false) 
    private String password;

    @NotNull(message = "Phone number is mandatory")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number should be 10 digits")
    @Column(nullable = false) 
    private String phoneNo;

    @NotNull(message = "Address is mandatory")
    @Column(nullable = false) 
    private String address;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Customer(Integer customerId, @NotNull(message = "Name is mandatory") String name,
			@NotNull(message = "Email is mandatory") String email,
			@NotNull(message = "Password is mandatory") @Size(min = 6, message = "Password should have at least 6 characters") String password,
			@NotNull(message = "Phone number is mandatory") @Pattern(regexp = "^\\d{10}$", message = "Phone number should be 10 digits") String phoneNo,
			@NotNull(message = "Address is mandatory") String address) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
		this.address = address;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", phoneNo=" + phoneNo + ", address=" + address + "]";
	}
    
}
