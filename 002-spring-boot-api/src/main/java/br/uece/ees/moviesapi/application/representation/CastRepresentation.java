package br.uece.ees.moviesapi.application.representation;

import br.uece.ees.moviesapi.domain.model.CastMember;

import java.io.Serializable;

public class CastRepresentation implements Serializable {

    public String role_id;
    public String actor_id;
    public String role_name;
    public String actor_name;

    public CastRepresentation() {}

    public CastRepresentation(CastMember member) {
        this.actor_id   = member.getId();
        this.actor_name = member.getName();
        this.role_id    = member.getRole().getId();
        this.role_name  = member.getRole().getName();
    }

}
