package com.example.secondary.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String action;
    private LocalDateTime timestamp;
    public Long getId() {
        return id;
    }
    public String getAction() {
        return action;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}