package jobsearch.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jobsearch.model.Post;
import jobsearch.repository.PostRepository;
import jobsearch.repository.SearchRepositoryimpl;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

	@Autowired
	PostRepository repo;
	@Autowired
	SearchRepositoryimpl repositoryimpl;

	// only for enabling swagger if req--> homepage->> it will go to swagger
	@ApiIgnore
	@RequestMapping("/")
	public void redirect(HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.sendRedirect("/swagger-ui.html");
	}

	@GetMapping("/allPosts")
	@CrossOrigin
	public List<Post> getAllPosts() {

		return repo.findAll();
	}

	@GetMapping("/posts/{text}")
	@CrossOrigin
	public List<Post> search(@PathVariable String text) {
		return repositoryimpl.findByText(text);
	}

	@PostMapping("/post")
	@CrossOrigin
	public String addPost(@RequestBody Post post) {
		repo.save(post);

		return "Post is added in feeds";

	}
}
