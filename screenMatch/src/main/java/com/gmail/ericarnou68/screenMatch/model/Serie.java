package com.gmail.ericarnou68.screenMatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Serie {

    private String title;
    private Integer totalSeasons;
    private Double assessment;
    private Category genre;
    private String actors;
    private String poster;
    private String synopsis;

    public Serie(SeriesData seriesData){
        this.title = seriesData.title();
        this.poster = seriesData.poster();
        this.synopsis = seriesData.synopsis();
        this.totalSeasons = seriesData.totalSeasons();
        this.actors = seriesData.actors();
        this.genre = Category.fromString(seriesData.genre().split(",")[0].trim());

        try{
            this.assessment = Double.valueOf(seriesData.assessment());
        } catch (NumberFormatException e){
            this.assessment = 0.0;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalSeasons() {
        return totalSeasons;
    }

    public void setTotalSeasons(Integer totalSeasons) {
        this.totalSeasons = totalSeasons;
    }

    public Double getAssessment() {
        return assessment;
    }

    public void setAssessment(Double assessment) {
        this.assessment = assessment;
    }

    public Category getGenre() {
        return genre;
    }

    public void setGenre(Category genre) {
        this.genre = genre;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "title='" + title + '\'' +
                ", totalSeasons=" + totalSeasons +
                ", assessment=" + assessment +
                ", genre=" + genre +
                ", actors='" + actors + '\'' +
                ", poster='" + poster + '\'' +
                ", synopsis='" + synopsis + '\'' +
                '}';
    }
}
