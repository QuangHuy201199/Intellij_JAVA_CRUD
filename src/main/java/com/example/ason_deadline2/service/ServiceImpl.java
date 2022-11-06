package com.example.ason_deadline2.service;

import com.example.ason_deadline2.mapper.MapperUser;
import com.example.ason_deadline2.model.dtoUser.DtoUser;
import com.example.ason_deadline2.model.entityUser.EntityUser;
import com.example.ason_deadline2.model.inUser.InUser;
import com.example.ason_deadline2.model.respondUser.RespondUser;
import com.example.ason_deadline2.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServiceImpl implements ServiceUser {
    @Autowired
    private RepositoryUser repositoryUser;

    @Override
    public RespondUser pagination(Integer activePage, Integer limit) {
        Integer activePageFix = activePage - 1;
        Pageable pageable = PageRequest.of(activePageFix, limit);
        Page<EntityUser> page = repositoryUser.findAll(pageable);
        List<DtoUser> listDto = page.stream().map(MapperUser::mapDto).collect(Collectors.toList());

        return new RespondUser("Success", listDto, page.getTotalPages(), page.getTotalElements());
    }

    @Override
    public RespondUser create(InUser inUser) {
        EntityUser entityUser = MapperUser.mapEntity(inUser);
        entityUser.setDateCreate(LocalDate.now());
        repositoryUser.save(entityUser);
        return new RespondUser("Success");
    }

    @Override
    public RespondUser delete(Integer id) {
        EntityUser entityUser = repositoryUser.getById(id);
        repositoryUser.delete(entityUser);
        return new RespondUser("Success");
    }

    @Override
    public RespondUser update(Integer id, InUser inUser) {
        EntityUser entityUser = repositoryUser.getById(id);
        entityUser.setPassWord(inUser.getPassWord());
        entityUser.setNameUser(inUser.getNameUser());
        entityUser.setStatus(inUser.getStatus());
        repositoryUser.save(entityUser);
        return new RespondUser("Success");
    }
}
