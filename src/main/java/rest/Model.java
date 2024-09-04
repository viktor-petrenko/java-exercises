package rest;


public class Model implements IModel {
    public Model() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Model that = (Model) o;
        return ModelJsonComparator.compare(this, that).isEquals();
    }

    @Override
    public int hashCode() {
        // Ensures consistency with equals()
        return super.hashCode();
    }
}