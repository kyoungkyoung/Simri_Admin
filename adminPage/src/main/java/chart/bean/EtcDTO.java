package chart.bean;

import lombok.Data;

@Data
public class EtcDTO {
	private int seq;
	private String etcLogtime;
	private int hitHit; 			//조회수
	private int likeLike;			//좋아요수
	private int shareShare;			//공유수
}
