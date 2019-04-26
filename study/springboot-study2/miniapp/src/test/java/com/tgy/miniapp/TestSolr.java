package com.tgy.miniapp;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.util.Set;

/**
 * @author tanggy
 * @date 2018/8/11
 */
public class TestSolr {
    //添加 保存
    @Test
    public void testSolrAdd() throws Exception {
        //实例化一个solr实现类 solrJ
        String url = "http://192.168.196.128:8080/solr";
        SolrServer solrServer = new HttpSolrServer(url);
        //完成数据添加
        //实例化一个添加商品信息的类
        SolrInputDocument document = new SolrInputDocument();
        //id
        document.setField("id", 6);
        // 名字 价格 图片
        document.setField("name", "Xiaomi/小米 红米Note6");
        document.setField("price", "999");
        document.setField("url", "http://img.alicdn.com/bao/uploaded/i6/TB1j70Nd1OSBuNjy0FdNbPDnVXa_044457.jpg_400x400q60.jpg");
        solrServer.add(document);
        document.setField("id", 7);
        document.setField("name", "Xiaomi/小米 小米8");
        document.setField("price", "3999");
        document.setField("url", "http://img.alicdn.com/bao/uploaded/i6/TB1j70Nd1OSBuNjy0FdNbPDnVXa_044457.jpg_400x400q60.jpg");
        solrServer.add(document);
        document.setField("id", 8);
        document.setField("name", "Xiaomi/小米 小米8p");
        document.setField("price", "4999");
        document.setField("url", "http://img.alicdn.com/bao/uploaded/i6/TB1j70Nd1OSBuNjy0FdNbPDnVXa_044457.jpg_400x400q60.jpg");
        //保存上边的数据
        solrServer.add(document);
        //solr作为一个数据库 事务能力 保存之后进行提交 submit
        solrServer.commit();
    }

    @Test
    public void testSeach() throws Exception {
        String url = "http://192.168.196.128:8080/solr";
        SolrServer solrServer = new HttpSolrServer(url);

        SolrQuery solrQuery = new SolrQuery();
        //查询关键词 q 关键词查询
        solrQuery.set("q", "name:米");
        //过滤条件
        //solrQuery.addFilterQuery("品牌");
        //查询数据
        QueryResponse resp = solrServer.query(solrQuery);
        //拿出QueryResponse的数据 结果集
        SolrDocumentList results = resp.getResults();
        long numFound = results.getNumFound();
        System.out.println("数据条数" + numFound);
        for (SolrDocument solrDocument : results) {
            //取出Id
            String id = (String) solrDocument.get("id");
            System.out.println("id:" + id);
            String name = (String) solrDocument.get("name");
            System.out.println("name:" + name);
            String urlPic = (String) solrDocument.get("url");
            System.out.println("urlPic:" + urlPic);
            float price = (float) solrDocument.get("price");
            System.out.println("price:"+price);
        }
    }
}
