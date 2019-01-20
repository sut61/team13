package com.okta.developer.demo.entity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

    @Data
    @Entity
    @Getter
    @Setter
    @ToString
    @EqualsAndHashCode
@Table(name = "StudyTimeTable")
public class StudyTimeTable {
        @Id
        @SequenceGenerator(name="Personnel_seq",sequenceName="Personnel_seq")
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Personnel_seq")
        @Column(name="Personnel_ID",unique = true, nullable = true)
        private   @NonNull Long id;
        private   @NonNull String fname;
        private   @NonNull String Lname;
        private   @NonNull String nationality;
        private   @NonNull String educational;
        private   @NonNull String IdentificationNumber;
        private   @NonNull String job_id;
        private   @NonNull String phonenumber;
        private   @NonNull String E_mail;
        private   @NonNull String extraction;

    }
