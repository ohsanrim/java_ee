package borad.bean;

import lombok.Data;

@Data
public class BoardPaging {
   private int currentPage;
   private int pageBlock;
   private int pageSize;
   private int totalA;
   private StringBuffer pagingHTML;
   
   public void makePagingHTML() {
      pagingHTML = new StringBuffer();
      int totalP = (totalA+pageSize-1)/pageSize;// 총페이지수
      int startPage = (currentPage -1)/pageBlock*pageBlock+1;
      int endPage = startPage+pageBlock-1;
      if(endPage > totalP) endPage = totalP; // endpage=9 이고 totalP=8일때 처리하기위한 공식
      
      if(startPage > pageBlock) {
         pagingHTML.append("[<a href='boardList.jsp?pg="+(startPage-1)+"'>이전]</a>");
      }
      
      for(int i = startPage; i <= endPage; i++) {
         if(i == currentPage) {
            pagingHTML.append("[<a href='boardList.jsp?pg="+i+"'>"+i+"</a>]");
         }else {
            pagingHTML.append("[<a href='boardList.jsp?pg="+i+"'>"+i+"</a>]");
         }
      }
      
      if(endPage < totalP) {
         pagingHTML.append("[<a href='boardList.jsp?pg="+(endPage+1)+"'>다음</a>]");
      }
   }
}