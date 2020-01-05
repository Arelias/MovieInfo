package com.movies.info.moviesinfo.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(
                name = "User.findByCode",
                query = "FROM User WHERE userCode = :USERCODE"
        ),
        @NamedQuery(
                name = "User.activate",
                //query = "Update DeptEmployee set department = :newDepartment where employeeNumber = :employeeNo"
                query = "Update User set emailConfirmed = true WHERE userCode = :USERCODE"
//                query = "update User u set u.emailConfirmed=true where s.userCode=:accCode"
        ),
        @NamedQuery(
                name = "User.changePassword",
                //query = "Update DeptEmployee set department = :newDepartment where employeeNumber = :employeeNo"
                query = "Update User set password = :PASSWORD WHERE userCode = :USERCODE"
//                query = "update User u set u.emailConfirmed=true where s.userCode=:accCode"
        ),
        @NamedQuery(
                name = "User.findCredentials",
                query = "FROM User WHERE login = :LOGIN AND password = :PASSWORD"
//                query = "update User u set u.emailConfirmed=true where s.userCode=:accCode"
        )
})
//update Student s set e=s.marks=50 where s.studentId=10;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String login;
    private String password;
    @Column(unique = true)
    private String email;
    private LocalDateTime registrationDate;
    private LocalDateTime lastLoginDate;
    @Column(unique = true)
    private String userCode;
    private boolean emailConfirmed;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.emailConfirmed = false;
    }


    public User(String login, String password, String email, LocalDateTime registrationDate) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.registrationDate = registrationDate;
        this.userCode = generateUserCode();
    }

    public void setData(){
        this.registrationDate = LocalDateTime.now();
        this.userCode = generateUserCode();
    }
    private String generateUserCode() {
        int result = login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + registrationDate.hashCode();
        return Integer.toString(result);
    }
}
