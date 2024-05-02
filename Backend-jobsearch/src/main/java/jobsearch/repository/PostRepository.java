package jobsearch.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import jobsearch.model.Post;

public interface PostRepository extends MongoRepository<Post, String>{

	

}
