package com.marcos.desenvolvimento.authapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "sales_reports")
public class SalesReportsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String groupBy;
    @NotNull
    private String display;
    @NotNull
    private String title;
    @NotNull
    private String filterRowSource;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilterRowSource() {
        return filterRowSource;
    }

    public void setFilterRowSource(String filterRowSource) {
        this.filterRowSource = filterRowSource;
    }

    public SalesReportsModel(){

    }

    public SalesReportsModel(Long id, String groupBy, String display, String title, String filterRowSource) {
        this.id = id;
        this.groupBy = groupBy;
        this.display = display;
        this.title = title;
        this.filterRowSource = filterRowSource;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesReportsModel that = (SalesReportsModel) o;
        return Objects.equals(groupBy, that.groupBy) && Objects.equals(display, that.display) && Objects.equals(title, that.title) && Objects.equals(filterRowSource, that.filterRowSource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupBy, display, title, filterRowSource);
    }


}
