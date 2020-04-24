package br.uece.ees.jeewebapp.domain.model.common;

public class Entity
{

    private String identity;

    protected Entity()
    {
        identity = "-1";
    }

    public void setIdentity(String identity)
    {
        this.identity = identity;
    }

    public String getIdentity()
    {
        return this.identity;
    }

    @Override
    public boolean equals(Object object)
    {
        boolean equalObjects = false;
        if (object != null && this.getClass() == object.getClass()) {
            Entity typedObject = (Entity) object;
            equalObjects = this.getIdentity().equals(typedObject.getIdentity());
        }

        return equalObjects;
    }

}
