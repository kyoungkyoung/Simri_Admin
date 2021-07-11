package post.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class PostPaging2 {
	   private int currentPage;
	   private int pageBlock;
	   private int pageSize;
	   private int totalA;
	   private StringBuffer pagingHTML;
	   
	   
	   
	   public void makePagingHTML(String DHL) {
		    int num = 0;
		   
		   	 if(DHL.equals("최신순")) {
				 num = 1;
			 }else if(DHL.equals("조회수")) {
				 num = 2;
			 }else if(DHL.equals("좋아요")) {
				 num = 3;
			 }
	      pagingHTML = new StringBuffer();
	      
	      int totalP = (totalA+pageSize-1)/pageSize;
	      
	      int startPage = (currentPage-1) / pageBlock * pageBlock + 1;
	      int endPage = startPage + pageBlock - 1;
	      if(endPage > totalP) endPage = totalP;
	      
	      if(startPage > pageBlock) 
	         pagingHTML.append("<li class='page-item'><a class='page-link' onclick='postPaging2("+(startPage-1)+","+num+")'>이전</a></li>");

	      for(int i =startPage; i<=endPage; i++) {
	         if(i==currentPage) {
	            pagingHTML.append("<li class='page-item active' aria-current='page'><a class='page-link' onclick='postPaging2("+i+","+num+")'>"+i+"</a></li> ");
	         }else {
	            pagingHTML.append("<li class='page-item' ><a class='page-link' onclick='postPaging2("+i+","+num+")'>"+i+"</a></li>");
	         }//else
	      }//for
	   
	      if(endPage < totalP) 
	         pagingHTML.append("<li class='page-item'><a class='page-link' onclick='postPaging2("+(endPage+1)+","+num+")'>다음</a></li>");
	   }
	   
	}
