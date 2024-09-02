package de.szut.store.article;

import lombok.Data;

import java.util.Set;

@Data
public class GetAllArticlesBySupplierIdDto {
    private Long supplierId;
    private String name;
    Set<GetArticleDto> getArticleDto;
}
