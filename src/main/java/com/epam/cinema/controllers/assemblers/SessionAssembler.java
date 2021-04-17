package com.epam.cinema.controllers.assemblers;

import com.epam.cinema.controllers.SessionController;
import com.epam.cinema.controllers.models.SessionModel;
import com.epam.cinema.dtos.SessionDto;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class SessionAssembler extends RepresentationModelAssemblerSupport<SessionDto, SessionModel> {

    public SessionAssembler() {
        super(SessionController.class, SessionModel.class);
    }

    @Override
    public SessionModel toModel(SessionDto entity) {
        SessionModel sessionModel = new SessionModel(entity);


        return sessionModel;
    }
}
