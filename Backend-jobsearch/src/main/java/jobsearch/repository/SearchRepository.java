package jobsearch.repository;

import java.util.List;

import jobsearch.model.Post;

public interface SearchRepository {
	List<Post> findByText(String text);


}
