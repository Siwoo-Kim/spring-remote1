package com.siwoo.application.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter @Setter @ToString @Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity @Table(name="singer")
public class Singer implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private int version;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

}
