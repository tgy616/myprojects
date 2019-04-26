package com.tgy.elas;

import com.tgy.elas.bean.Article;
import com.tgy.elas.bean.Book;
import com.tgy.elas.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasApplicationTests {
    @Autowired
    JestClient jestClient;
    @Autowired
    BookRepository bookRepository;

    @Test
    public void test2(){
        Book book=new Book();
        book.setId(1);
        book.setBookName("金瓶梅");
        book.setAuthor("笑笑生");
        bookRepository.index(book);
    }

    @Test
    public void tes3() {
        for (Book book : bookRepository.findByBookNameLike("瓶")) {
            System.out.println(book);
        }
    }

    @Test
    public void contextLoads() {
        //给Es中索引（保存）一个文档；
        Article article = new Article();
        article.setAuthor("张三");
        article.setId(1);
        article.setTitle("葵花宝典");
        article.setContent("欲练此功，必先自宫！！！");
        //构建一个索引功能
        Index index = new Index.Builder(article).index("tgy").type("news").build();

        try {
            //执行
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //测试：全文搜索
    @Test
    public void search(){
        //查询表达式
        String json="{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"欲练\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //构建搜索功能
        Search search = new Search.Builder(json).addIndex("tgy").addType("news").build();
        //执行
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
