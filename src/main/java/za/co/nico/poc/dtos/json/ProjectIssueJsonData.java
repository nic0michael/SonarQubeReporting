package za.co.nico.poc.dtos.json;

import java.sql.Date;
import java.util.List;

public class ProjectIssueJsonData {

   int total;
   int p;
   int ps;
   Paging paging;
   List<Issue> issues;
   List<Component>components;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    @Override
    public String toString() {
        return "ProjectIssueJsonData{" +
                "total=" + total +
                ", p=" + p +
                ", ps=" + ps +
                ", paging=" + paging +
                ", issues=" + issues +
                ", components=" + components +
                '}';
    }
}
