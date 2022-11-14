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
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServiceImpl implements ServiceUser {
    @Autowired
    private RepositoryUser repositoryUser;

    @Override
    public RespondUser pagination(Integer page, Integer limit) {
        Integer activePageFix = page - 1;
        Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(activePageFix, limit, sort);
        Page<EntityUser> list = repositoryUser.findAll(pageable);
        List<DtoUser> listDto = list.stream().map(MapperUser::mapDto).collect(Collectors.toList());
        return new RespondUser("Success", listDto, list.getTotalPages(), list.getTotalElements(), page);
    }

    @Override
    public RespondUser create(InUser inUser) {
        if(inUser.getNameUser() == ""|| inUser.getNameUser() == null){
            return new RespondUser("Bạn phải nhập tên tài khoản !");
        }
        else{
            EntityUser entityUser = MapperUser.mapEntity(inUser);
            entityUser.setDateCreate(LocalDate.now());
            repositoryUser.save(entityUser);
            return new RespondUser("Tạo tài khoản thành công !");
        }

    }

    @Override
    public RespondUser delete(Integer id) {
        EntityUser entityUser = repositoryUser.getById(id);
        repositoryUser.delete(entityUser);
        return new RespondUser("Xóa tài khoản thành công !");
    }

    @Override
    public RespondUser update(Integer id, InUser inUser) {
            EntityUser entityUser = repositoryUser.getById(id);
            entityUser.setPassWord(inUser.getPassWord());
            entityUser.setNameUser(inUser.getNameUser());
            entityUser.setStatus(inUser.getStatus());
            repositoryUser.save(entityUser);
            return new RespondUser("Update thành công !");
    }

    @Override
    public RespondUser updateStatus(Integer id, InUser inUser) {
        EntityUser entityUser = repositoryUser.getById(id);
        entityUser.setStatus(inUser.getStatus());
        repositoryUser.save(entityUser);
        return new RespondUser("Update trạng thái  thành công !");

    }
}
