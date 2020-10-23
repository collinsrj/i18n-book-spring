package com.collinsrj.i18nbook.service;

import lombok.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Objects;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;

@Value
public class Paging {
    int limit;
    int offset;
    String[] sort;
    boolean ascending;

    public Paging(final int limit, final int offset, List<String> sort) {
        this.limit = limit;
        this.offset = offset;
        if (Objects.nonNull(sort) && sort.size() > 0) {
            String firstElement = sort.get(0);
            if (firstElement.startsWith("+")) {
                firstElement = firstElement.substring(1);
                ascending = true;
            } else if (firstElement.startsWith("-")) {
                firstElement = firstElement.substring(1);
                ascending = false;
            } else {
                ascending = true;
            }
            sort.set(0, firstElement);
            this.sort = sort.stream().toArray(String[]::new);
        } else {
            ascending = true;
            this.sort = new String[]{};
        }
    }

    protected Pageable pageable() {
        Sort.Direction direction = ascending ? ASC : DESC;
        return sort.length > 0 ?
                PageRequest.of(offset, limit, direction, sort) :
                PageRequest.of(offset, limit);
    }
}
