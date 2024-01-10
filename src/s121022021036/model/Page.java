package s121022021036.model;

import java.util.List;

public class Page<T> {
    private int pageNo;
    private int pageSize;
    private int totalCount;
    private int totalPage;
    private List<T> list;

    public void setPage(int pageNo, int pageSize, int totalCount) { //设置页面大小
        if (pageSize < 0 || pageSize > 7) pageSize = 7;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        totalPage = (int) Math.ceil((double) totalCount / pageSize);
        if (pageNo <= 0) pageNo = 1;
        if (pageNo >= totalPage + 1) pageNo = totalPage;
        this.pageNo = pageNo;
    }

    public int getNextPage() {
        return pageNo != totalPage ? pageNo + 1 : totalPage;
    }

    public int getPrePage() {
        return pageNo > 1 ? pageNo - 1 : 1;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}