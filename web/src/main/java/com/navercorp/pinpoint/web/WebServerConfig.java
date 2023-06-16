package com.navercorp.pinpoint.web;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.ErrorPageFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import javax.servlet.Filter;
import java.util.List;

@Configuration
public class WebServerConfig {
    @Bean
    public FilterRegistrationBean<Filter> etagFilterBean() {
        Filter filter = new ShallowEtagHeaderFilter();

        FilterRegistrationBean<Filter> filterBean = new FilterRegistrationBean<>();
        filterBean.setFilter(filter);
        filterBean.setName(filter.getClass().getSimpleName());
        filterBean.setUrlPatterns(List.of("/assets/*", "*.html", "/main"));
        return filterBean;
    }

    @Bean
    public Filter errorPageFilter() {
        return new ErrorPageFilter();
    }
}
