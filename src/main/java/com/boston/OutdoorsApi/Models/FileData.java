package com.boston.OutdoorsApi.Models;

import javax.persistence.*;

@Entity
@Table(name = "filedata")
public class FileData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "varchar")
    private String name;
    @Column(name = "type", columnDefinition = "varchar")
    private String type;
    @Column(name = "filepath", columnDefinition = "varchar")
    private String filePath;

    public FileData() {
    }

    public FileData(String name, String type, String filePath) {
        this.name = name;
        this.type = type;
        this.filePath = filePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "FileData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
