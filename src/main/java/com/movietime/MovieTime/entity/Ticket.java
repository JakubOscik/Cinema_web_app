package com.movietime.MovieTime.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "ticketId")
public @Getter @Setter
class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ticketId" , nullable = false)
    private int    ticketId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "screenId", nullable = false)
    @JsonBackReference
    private Screen screenId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usersId", nullable = false)
    @JsonBackReference
    private Users usersId;

    public Ticket(Screen screenId, Users usersId) {
        this.screenId = screenId;
        this.usersId = usersId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Screen getScreenFk() {
        return screenId;
    }

    public void setScreenFk(Screen screenFk) {
        this.screenId = screenFk;
    }

    public Users getUsersFk() {
        return usersId;
    }

    public void setUsersFk(Users usersFk) {this.usersId = usersFk;}
}
