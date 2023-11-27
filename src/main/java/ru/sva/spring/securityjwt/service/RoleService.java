package ru.sva.spring.securityjwt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sva.spring.securityjwt.entity.Role;
import ru.sva.spring.securityjwt.repository.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
