package com.cristianortega.portfolio.domain.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public class PageConvert {
    public static <T, R> Page<R> convertPage(Page<T> page, List<R> list) {
        return new PageImpl<>(list, page.getPageable(), page.getTotalElements());
    }

}
