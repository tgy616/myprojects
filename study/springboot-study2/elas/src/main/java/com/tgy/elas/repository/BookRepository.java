package com.tgy.elas.repository;

import com.tgy.elas.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author tanggy
 * @date 2018/9/27
 */
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {

    //自定义查询，参考：https://docs.spring.io/spring-data/elasticsearch/docs/2.1.15.RELEASE/reference/html/#project
    public List<Book> findByBookNameLike(String bookName);
}
