package com.example.ason_deadline2.mapper;

import com.example.ason_deadline2.model.dtoUser.DtoUser;
import com.example.ason_deadline2.model.entityUser.EntityUser;
import com.example.ason_deadline2.model.inUser.InUser;

public class MapperUser {
    public static EntityUser mapEntity(InUser inUser){
        EntityUser entityUser = new EntityUser();
        entityUser.setNameUser(inUser.getNameUser());
        entityUser.setDateOfBirth(inUser.getDateOfBirth());l
        if (inUser.getStatus()== null){
            entityUser.setStatus(true);
        }else {
            entityUser.setStatus(inUser.getStatus());
        }
        if (inUser.getPassWord()== null){
            entityUser.setPassWord("admin");
        }else {
            entityUser.setPassWord(inUser.getPassWord());
        }
        return entityUser;
    }
    public static DtoUser mapDto(EntityUser entityUser){
        DtoUser dtoUser = new DtoUser();
        dtoUser.setId(entityUser.getId());
        dtoUser.setNameUser(entityUser.getNameUser());
        dtoUser.setStatus(entityUser.getStatus());
        dtoUser.setPassWord(entityUser.getPassWord());
        dtoUser.setDateCreate(entityUser.getDateCreate());
        dtoUser.setDateOfBirth(entityUser.getDateOfBirth());
        return dtoUser;
    }
}
