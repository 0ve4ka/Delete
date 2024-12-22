package org.example.perevozki.models;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "customers",schema = "public")
public class customers {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public Long getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPhone() {
        return phone;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInitial(){
        return secondName + ' ' + firstName.charAt(0) + ". " + middleName.charAt(0)+ '.';
    }

    @Override
    public String toString() {
        return getInitial();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        return Objects.equals(cardNumber,((customers) obj).cardNumber) &&
                Objects.equals(email,((customers) obj).email) &&
                Objects.equals(password,((customers) obj).password);
    }

    @Override
    public int hashCode() {
        return 17 * phone.hashCode() + 17 * firstName.hashCode() + 17* secondName.hashCode() + 17 * middleName.hashCode() + 31 * email.hashCode() + 31 * password.hashCode() + 31 * cardNumber.hashCode();
    }
}
