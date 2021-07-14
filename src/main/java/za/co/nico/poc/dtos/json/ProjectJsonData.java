package za.co.nico.poc.dtos.json;

import java.util.List;


public class ProjectJsonData {

    RPaging paging;
    List<RComponent>components;
    
    
    List<Facet> facets;

    public RPaging getPaging() {
        return paging;
    }

    public void setPaging(RPaging paging) {
        this.paging = paging;
    }

    public List<RComponent> getComponents() {
        return components;
    }

    public void setComponents(List<RComponent> components) {
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
