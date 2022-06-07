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
        property = "screenId")
public @Getter @Setter
class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="`screenId`")
    private int screenId;

    @Column(name="screenHour", nullable = false)
    private String screenHour;

    @Column(name="screenDay", nullable = false)
    private String screenDay;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "filmId")
    @JsonBackReference
    private Film filmId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hallId")
    @JsonBackReference
    private Hall hallId;



    public Screen(String hour, String day, Film filmId, Hall hallId) {
        this.screenHour = hour;
        this.screenDay = day;
        this.filmId = filmId;
        this.hallId = hallId;
    }

    public int getScreenId() {
        return screenId;
    }

    public String getHour() {
        return screenHour;
    }

    public void setHour(String hour) {
        this.screenHour = hour;
    }

    public String getDay() {
        return screenDay;
    }

    public void setDay(String day) {
        this.screenDay = day;
    }

    public Film getFilmFk() {
        return filmId;
    }

    public void setFilmFk(Film filmId) {
        this.filmId = filmId;
    }

    public Hall getHallFk() {
        return hallId;
    }

    public void setHallFk(Hall hall_fk) {
        this.hallId = hall_fk;
    }
}

