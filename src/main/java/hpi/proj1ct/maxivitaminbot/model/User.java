package hpi.proj1ct.maxivitaminbot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author Jana Metz on 21.05.23
 */
@Data
@Entity(name = "userDatabase Table")
public class User {
    @Id
    private Long chatId;
    private String firstName;
    private String lastName;
    private String username;
    private String eMail;
    private Long password;

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }
    public Long getPassword() {
        return password;
    }

    public void setPassword(Long password) {
        this.password = password;
    }


    public Timestamp getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Timestamp registeredAt) {
        this.registeredAt = registeredAt;
    }

    private Timestamp registeredAt;


    @Override
    public String toString() {
        return "User{" +
                "chatId=" + chatId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", eMail='" + eMail + '\'' +
                ", registeredAt=" + registeredAt +
                '}';
    }
}
