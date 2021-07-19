package com.ToDoV1.model;

import com.ToDoV1.enums.Rule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String login;

    private String password;

    @Enumerated(EnumType.STRING)
    private Rule rule;

    private LocalDateTime createDate;

}
