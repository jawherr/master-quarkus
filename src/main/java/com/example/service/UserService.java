package com.example.service;

import com.example.dto.CreateUserRequest;
import com.example.dto.PageResponse;
import com.example.dto.UserResponse;
import com.example.model.User;
import com.example.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.WebApplicationException;
import java.util.List;
import io.quarkus.panache.common.Sort;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    /* CREATE */
    @Transactional
    public UserResponse create(CreateUserRequest request) {

        if (userRepository.findByEmail(request.email).isPresent()) {
            throw new WebApplicationException("Email already exists", 409);
        }

        User user = new User();
        user.name = request.name;
        user.email = request.email;
        user.password = request.password;

        userRepository.persist(user);

        return UserResponse.from(user);
    }

    /* READ ALL (PAGINATED) */
    public PageResponse<UserResponse> list(
            int page,
            int size,
            String sort,
            String direction) {

        Sort sortOrder = Sort.by(sort != null ? sort : "id");

        if ("desc".equalsIgnoreCase(direction)) {
            sortOrder = sortOrder.descending();
        }

        var query = userRepository.findAll(sortOrder);

        long total = query.count();
        long totalPages = (long) Math.ceil((double) total / size);

        var users = query.page(page, size)
                .list()
                .stream()
                .map(UserResponse::from)
                .toList();

        Map<String, String> links = buildLinks(page, size, totalPages);

        return new PageResponse<>(users, page, size, total, totalPages, links);
    }

    private Map<String, String> buildLinks(int page, int size, long totalPages) {

        Map<String, String> links = new HashMap<>();

        links.put("self", "/api/users?page=" + page + "&size=" + size);

        if (page + 1 < totalPages) {
            links.put("next", "/api/users?page=" + (page + 1) + "&size=" + size);
        } else {
            links.put("next", null);
        }

        if (page > 0) {
            links.put("prev", "/api/users?page=" + (page - 1) + "&size=" + size);
        } else {
            links.put("prev", null);
        }

        return links;
    }

    /* READ BY ID */
    public UserResponse getById(Long id) {

        User user = userRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("User not found"));

        return UserResponse.from(user);
    }

    /* SEARCH */
    public List<UserResponse> searchByName(String name) {

        return userRepository.findByNameContaining(name)
                .stream()
                .map(UserResponse::from)
                .toList();
    }

    /* UPDATE */
    @Transactional
    public UserResponse update(Long id, CreateUserRequest request) {

        User user = userRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("User not found"));

        user.name = request.name;
        user.email = request.email;
        user.password = request.password;

        return UserResponse.from(user);
    }

    /* DELETE */
    @Transactional
    public void delete(Long id) {

        if (!userRepository.deleteById(id)) {
            throw new NotFoundException("User not found");
        }
    }
}
