package com.epam.cinema.controllers.assemblers;

import com.epam.cinema.controllers.FilmController;
import com.epam.cinema.controllers.models.FilmModel;
import com.epam.cinema.dtos.FilmDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class FilmAssembler extends RepresentationModelAssemblerSupport<FilmDto, FilmModel> {

    public FilmAssembler() {
        super(FilmController.class, FilmModel.class);
    }

    @Override
    public FilmModel toModel(FilmDto entity) {
        FilmModel filmModel = new FilmModel(entity);

        Link getFilm = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(FilmController.class)
                .getFilm(entity.getFilmTitle()))
                .withRel("getFilm");

        Link updateFilm = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(FilmController.class)
                .updateFilm(entity, entity.getFilmTitle()))
                .withRel("updateFilm");

        Link deleteFilm = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(FilmController.class)
                .deleteFilm(entity.getFilmTitle()))
                .withRel("deleteFilm");
        filmModel.add(getFilm, updateFilm, deleteFilm);

        return filmModel;
    }
}
