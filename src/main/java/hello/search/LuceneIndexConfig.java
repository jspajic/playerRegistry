package hello.search;

import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManagerFactory;

public class LuceneIndexConfig {

    @Bean
    public LuceneIndexServiceBean luceneIndexServiceBean(EntityManagerFactory entityManagerFactory){
        LuceneIndexServiceBean luceneIndexServiceBean = new LuceneIndexServiceBean(entityManagerFactory);

        luceneIndexServiceBean.triggerIndexing();
        return luceneIndexServiceBean;
    }
}
