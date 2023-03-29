package com.mgen.amie.service;

import com.mgen.amie.entity.RoleEntity;
import com.mgen.amie.model.Role;
import com.mgen.amie.repository.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    private static final Logger log = LoggerFactory.getLogger(FAQService.class);

    public List<Role> getAllRoles() {
        try {
            List<RoleEntity> roles = roleRepository.findAll();
            List<Role> customRoles = new ArrayList<>();
            roles.stream().forEach(r -> {
                Role role = new Role();
                BeanUtils.copyProperties(r, role);
                customRoles.add(role);
            });
            return customRoles;
        } catch (Exception e) {
            log.error("Erreur de récupération de roles : ", e);
            return Collections.emptyList();
        }
    }

    public String addRole(RoleEntity role) {
        try {
            roleRepository.save(role);
            return "Role ajouté";
        } catch (Exception e) {
            return "Erreur de ajout: " + e.getMessage();
        }
    }
}
