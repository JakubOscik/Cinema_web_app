package com.movietime.MovieTime.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "filmId")
public @Getter @Setter
class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="filmId")
    private int filmId;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="summary", nullable = false)
    private String summary;

    @Column(name="category", nullable = false)
    private String category;

    @Column(name="poster", nullable = false)
    private String poster;

    @Column(name="trailer")
    private String trailer;

    public Film(String name, String summary, String category, String poster, String trailer) {
        this.name = name;
        this.summary = summary;
        this.category = category;
        this.poster = poster;
        this.trailer = trailer;
    }

    public int getFilmId() {
        return filmId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPoster() {return poster;}

    public void setPoster(String poster) {this.poster = poster;}

}

