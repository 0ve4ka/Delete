package org.example.perevozki.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "workers",schema = "public")
public class workers {
    @Id
    @Column(name = "worker_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workerId;

    @Column(name = "position")
    private String position;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "middle_name")
    private String middleName;


    public String getInitial(){
        return secondName + ' ' + firstName.charAt(0) + ". " + middleName.charAt(0)+ '.';
    }

    public Long getWorkerId() {
        return workerId;
    }

    public String getPosition() {
        return position;
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

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public void setPosition(String position) {
        this.position = position;
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
        return Objects.equals(position,((workers) obj).position) &&
                Objects.equals(firstName,((workers) obj).firstName) &&
                Objects.equals(secondName,((workers) obj).secondName) &&
                Objects.equals(middleName,((workers) obj).middleName);
    }

    @Override
    public int hashCode() {
        return 17 * position.hashCode() + 17 * firstName.hashCode() + 31 * secondName.hashCode() + 31 * middleName.hashCode();
    }
}