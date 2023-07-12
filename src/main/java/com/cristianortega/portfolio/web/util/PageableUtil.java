package com.cristianortega.portfolio.web.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageableUtil {

    public static Pageable basicPageable(int pages, int elements, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        return PageRequest.of(pages, elements, sort);
    }
}
