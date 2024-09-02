package de.szut.store.article;

import lombok.Data;

@Data
public class GetArticleDto {
    private Long aid;
    private String designation;
    private double price;
}
