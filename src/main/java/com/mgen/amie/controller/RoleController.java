package com.mgen.amie.controller;

import com.mgen.amie.entity.RoleEntity;
import com.mgen.amie.model.Role;
import com.mgen.amie.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/api/role/")
@Api(description = "Gestion des roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "Roles disponibles", notes = "Affiche les roles disponibles")
    @RequestMapping(value = "addroles", method = RequestMethod.POST)
    public String addRole(@Valid @RequestBody RoleEntity role){
        return roleService.addRole(role);
    }

    @ApiOperation(value = "Liste des roles ", notes = "Affiche la liste des roles")
    @RequestMapping(value = "getallroles", method = RequestMethod.GET)
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }
}
