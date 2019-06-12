package exam;

import java.util.List;

// TODO: 完成这个类

public class PaginationHelper<I> {

    /**
     * 构造函数包含
     * 1）数组collection，表示需要分页的所有元素
     * 2）数字itemsPerPage，表示每页的元素个数
     */

    public List<I> collection;  //所有元素
    public int itemsPerPage;   //每页的元素个数

    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection=collection;
        this.itemsPerPage=itemsPerPage;
    }

    /**
     * 返回collection中所有元素的个数
     */
    public int itemCount() {
        return collection.size();
    }

    /**
     * 返回页数
     */
    public int pageCount() {
        int len = collection.size();
        int page = len%itemsPerPage;
        int pages = 0;
        if(page != 0){
            pages = len/itemsPerPage +1;
        }else{
            pages = len/itemsPerPage;
        }
        return pages;
    }

    /**
     * 返回当前页pageIndex中所包含的元素个数
     * pageIndex从0开始计数
     * 如果pageIndex为非法值则返回-1
     */
    public int pageItemCount(int pageIndex) {
        int pages = this.pageCount();
        int len = collection.size();
        int page = len%itemsPerPage;
        if(pageIndex<0 || pageIndex>=pages){
            return -1;
        }
        else{
            if(page !=0 && pageIndex==pages-1){
                return page;
            }else{
                return itemsPerPage;
            }
        }
    }

    /**
     * 返回第itemIndex个元素所在的页数
     * pageIndex从0开始计数
     * 如果itemIndex为非法值则返回-1
     */
    public int pageIndex(int itemIndex) {
        int len = collection.size();
        if(itemIndex<=len && itemIndex >0){
            return itemIndex / itemsPerPage;
        }else{
            return -1;
        }
    }
}