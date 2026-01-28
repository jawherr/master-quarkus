package com.example.dto;

import java.util.List;
import java.util.Map;

public class PageResponse<T> {

    public List<T> data;
    public int page;
    public int size;
    public long total;
    public long totalPages;
    public Map<String, String> links;

    public PageResponse(List<T> data,
                        int page,
                        int size,
                        long total,
                        long totalPages,
                        Map<String, String> links) {

        this.data = data;
        this.page = page;
        this.size = size;
        this.total = total;
        this.totalPages = totalPages;
        this.links = links;
    }
}
