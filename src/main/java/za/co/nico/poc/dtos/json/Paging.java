package za.co.nico.poc.dtos.json;

public class Paging {

      int pageIndex;
      int pageSize;
      int total;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Paging{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", total=" + total +
                '}';
    }

}
