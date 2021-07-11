package community.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class CommunityPaging {
	   private int currentPage;
	   private int pageBlock;
	   private int pageSize;
	   private int totalA;
	   private StringBuffer pagingHTML;
	   
	   
	   
	   public void makePagingHTML(String comCategory) {
		   
		   int num=0;
		   
		 if(comCategory.equals("[전체 게시글]팔레트")) {
			 num = 1;
		 }else if(comCategory.equals("[팔레트]빨강")) {
			 num = 2;
		 }else if(comCategory.equals("[팔레트]파랑")) {
			 num = 3;
		 }else if(comCategory.equals("[팔레트]초록")) {
			 num = 4;
		 }else if(comCategory.equals("[팔레트]노랑")) {
			 num = 5;
		 }else if(comCategory.equals("유머 게시판")) {
			 num = 6;
		 }else if(comCategory.equals("연애 게시판")) {
			 num = 7;
		 }else if(comCategory.equals("고민&상담 게시판")) {
			 num = 8;
		 }else if(comCategory.equals("[공지사항]")) {
			 num = 9;
		 }
		   
		   
		   
		   
		   
		   
	      pagingHTML = new StringBuffer();
	      
	      int totalP = (totalA+pageSize-1)/pageSize;
	      
	      int startPage = (currentPage-1) / pageBlock * pageBlock + 1;
	      int endPage = startPage + pageBlock - 1;
	      if(endPage > totalP) endPage = totalP;
	      
	      if(startPage > pageBlock) 
	         pagingHTML.append("<li class='page-item'><a class='page-link' onclick='communityPaging("+(startPage-1)+","+num+")'>이전</a></li>");

	      for(int i =startPage; i<=endPage; i++) {
	         if(i==currentPage) {
	            pagingHTML.append("<li class='page-item active' aria-current='page'><a class='page-link' onclick='communityPaging("+i+","+num+")'>"+i+"</a></li> ");
	         }else {
	            pagingHTML.append("<li class='page-item' ><a class='page-link' onclick='communityPaging("+i+","+num+")'>"+i+"</a></li>");
	         }//else
	      }//for
	   
	      if(endPage < totalP) 
	         pagingHTML.append("<li class='page-item'><a class='page-link' onclick='communityPaging("+(endPage+1)+","+num+")'>다음</a></li>");
	   }
	   
	}
