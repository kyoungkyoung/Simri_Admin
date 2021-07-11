package chart.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ChartPaging {
	   private int currentPage;
	   private int pageBlock;
	   private int pageSize;
	   private int totalA;
	   private StringBuffer pagingHTML;
	   
	   
	   
	   public void makePagingHTML(String comCategory, String condition, String date) {
		   int comCategoryNum=0;
		   int conditionNum=0;
		   int dateNum=0;
		   
		   if(comCategory.equals("comCategoryAll")) {
			   comCategoryNum = 1;
		   }else if(comCategory.equals("심리테스트")) {
			   comCategoryNum = 2;
		   }else if(comCategory.equals("연애심리글")) {
			   comCategoryNum = 3;
		   }
		   
		   if(condition.equals("seq")) {
			   conditionNum = 1;
		   }else if(condition.equals("hit")) {
			   conditionNum = 2;
		   }else if(condition.equals("comlike")) {
			   conditionNum = 3;
		   }
		   
		   if(date.equals("day")) {
			   dateNum = 1;
		   }else if(date.equals("week")) {
			   dateNum = 2;
		   }else if(date.equals("month")) {
			   dateNum = 3;
		   }
		   
		   
	      pagingHTML = new StringBuffer();
	      
	      int totalP = (totalA+pageSize-1)/pageSize;
	      
	      int startPage = (currentPage-1) / pageBlock * pageBlock + 1;
	      int endPage = startPage + pageBlock - 1;
	      if(endPage > totalP) endPage = totalP;
	      
	      if(startPage > pageBlock) 
	         pagingHTML.append("<li class='page-item'><a class='page-link' onclick='chartPaging("+(startPage-1)+","+comCategoryNum+","+conditionNum+","+dateNum+")'>이전</a></li>");

	      for(int i =startPage; i<=endPage; i++) {
	         if(i==currentPage) {
	            pagingHTML.append("<li class='page-item active' aria-current='page'><a class='page-link' onclick='chartPaging("+i+","+comCategoryNum+","+conditionNum+","+dateNum+")'>"+i+"</a></li> ");
	         }else {
	            pagingHTML.append("<li class='page-item' ><a class='page-link' onclick='chartPaging("+i+","+comCategoryNum+","+conditionNum+","+dateNum+")'>"+i+"</a></li>");
	         }//else
	      }//for
	   
	      if(endPage < totalP) 
	         pagingHTML.append("<li class='page-item'><a class='page-link' onclick='chartPaging("+(endPage+1)+","+comCategoryNum+","+conditionNum+","+dateNum+")'>다음</a></li>");
	   }
	   
	}
