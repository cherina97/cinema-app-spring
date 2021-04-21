package com.epam.cinema.controllers.assemblers;

import com.epam.cinema.controllers.GenreController;
import com.epam.cinema.controllers.models.GenreModel;
import com.epam.cinema.dtos.GenreDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class GenreAssembler extends RepresentationModelAssemblerSupport<GenreDto, GenreModel> {

    public GenreAssembler() {
        super(GenreController.class, GenreModel.class);
    }

    @Override
    public GenreModel toModel(GenreDto entity) {
        GenreModel genreModel = new GenreModel(entity);

        Link get = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(GenreController.class)
                .getGenre(entity.getGenreName()))
                .withRel("get");

        Link update = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(GenreController.class)
                .updateGenre(entity, entity.getGenreName()))
                .withRel("update");

        Link delete = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(GenreController.class)
                .deleteGenre(entity.getGenreName()))
                .withRel("delete");

        Link create = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(GenreController.class)
                .createGenre(entity))
                .withRel("create");

        Link getAll = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(GenreController.class)
                .getAllGenres())
                .withRel("getAll");

        genreModel.add(get, update, delete, create, getAll);

        return genreModel;
    }
}
