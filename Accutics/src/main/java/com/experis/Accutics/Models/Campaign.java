package com.experis.Accutics.Models;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Campaign {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column
        private String created;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @OneToMany(mappedBy = "campaign")
        private Set<Input> inputList;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public User getUser() {
                return user;
        }

        public void setUser(User user) {
                this.user = user;
        }

        public Set<Input> getInputList() {
                return inputList;
        }

        public void setInputList(Set<Input> inputList) {
                this.inputList = inputList;
        }

        public String getCreated() {
                return created;
        }

        public void setCreated(String created) {
                this.created = created;
        }
}
