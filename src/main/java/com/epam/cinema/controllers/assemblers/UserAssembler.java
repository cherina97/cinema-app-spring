package com.epam.cinema.controllers.assemblers;

import com.epam.cinema.controllers.UserController;
import com.epam.cinema.controllers.models.UserModel;
import com.epam.cinema.dtos.UserDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class UserAssembler extends RepresentationModelAssemblerSupport<UserDto, UserModel> {

    public UserAssembler() {
        super(UserController.class, UserModel.class);
    }

    @Override
    public UserModel toModel(UserDto entity) {
        UserModel userModel = new UserModel(entity);

        Link getUser = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(UserController.class)
                .getUser(entity.getEmail()))
                .withRel("getUser");

        Link deleteUser = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(UserController.class)
                .deleteUser(entity.getEmail()))
                .withRel("deleteUser");

        Link updateUser = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(UserController.class)
                .updateUser(entity, entity.getEmail()))
                .withRel("updateUser");

        userModel.add(getUser, deleteUser, updateUser);

        return userModel;
    }
}
