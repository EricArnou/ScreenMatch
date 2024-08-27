package com.gmail.ericarnou68.screenMatch.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Integer number;
    private Double assessment;
    private LocalDate realeseDate;
    private Integer season;

    @ManyToOne
    private Serie serie;

    public Episode() {
    }

    public Episode(Integer season, EpisodeData episodeData){
        this.season = season;
        this.title = episodeData.title();
        this.number = episodeData.number();

        try{
            this.assessment = Double.valueOf(episodeData.assessment());
            this.realeseDate = LocalDate.parse(episodeData.releaseDate());
        }catch (NumberFormatException e){
            this.assessment = 0.0;
        }catch (DateTimeParseException e){
            this.realeseDate = null;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getAssessment() {
        return assessment;
    }

    public void setAssessment(Double assessment) {
        this.assessment = assessment;
    }

    public LocalDate getRealeseDate() {
        return realeseDate;
    }

    public void setRealeseDate(LocalDate realeseDate) {
        this.realeseDate = realeseDate;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public String toString() {
        return "Season:" + this.season + ", title: " + this.title + ", assessment: " + this.assessment;
    }
}
