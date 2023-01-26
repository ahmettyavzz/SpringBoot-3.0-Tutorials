package com.yavuzahmet;

import com.yavuzahmet.model.Post;
import com.yavuzahmet.repository.PostRepository;
import com.yavuzahmet.service.JsonPlaceHolderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PostRepository postRepository) {
        return args -> {
            var client = WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();
            var factor = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
            var jps = factor.createClient(JsonPlaceHolderService.class);
            List<Post> posts = jps.loadPosts();
            postRepository.saveAll(posts);
        };
    }
}