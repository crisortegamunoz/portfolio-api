package com.cristianortega.portfolio.domain.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

public class PageConvert {
    public static <T, R> Page<R> convertPage(Page<T> page, List<R> list) {
        return new PageImpl<>(list, page.getPageable(), page.getTotalElements());
    }

}
