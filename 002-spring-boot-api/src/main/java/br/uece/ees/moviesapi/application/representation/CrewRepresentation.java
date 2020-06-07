package br.uece.ees.moviesapi.application.representation;

import br.uece.ees.moviesapi.domain.model.CrewMember;

public class CrewRepresentation {

    public String role_id;
    public String person_id;
    public String role_name;
    public String person_name;

    public CrewRepresentation() {}

    public CrewRepresentation(CrewMember member) {
        this.person_id   = member.getId();
        this.person_name = member.getName();
        this.role_id     = member.getRole().getId();
        this.role_name   = member.getRole().getName();
    }

}
