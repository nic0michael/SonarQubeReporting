package za.co.nico.poc.dtos.json;

import java.util.List;

public class ProjectJsonData {

    Paging paging;
    List<Component>components;

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    @Override
    public String toString() {
        return "ProjectJsonData{" +
                "paging=" + paging +
                ", components=" + components +
                '}';
    }
}
