import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;

/**
 * @author yang
 * 2021年04月16日 17:15:00
 */
public class 向solr服务器发送数据 {
    public static void main(String[] args) throws IOException, SolrServerException {
        String serverUrl = "http://localhost:8080/solr/weibo";


        String[] name = {"jack","tom","john","mary","lucy","bob"};
        HttpSolrServer httpSolrServer = new HttpSolrServer(serverUrl);

        SolrInputDocument doc1 = new SolrInputDocument();
        doc1.setField("id",2);
        doc1.setField("screen_name_s","@tom");
        doc1.setField("type_s","post");
        doc1.setField("lang_s","en");
        doc1.setField("timestamp_tdt","2012-05-22T09:30:22Z/HOUR");
        doc1.setField("favorites_count_ti","10");
        doc1.setField("text_t","#Yummm :) Drinking a latte at Caffe Grecco in SF's historic North Beach... Learning text analysis with #SolrInAction by @ManningBooks on my i-Pad");

        httpSolrServer.add(doc1);

        httpSolrServer.commit(true,true);



    }
}
