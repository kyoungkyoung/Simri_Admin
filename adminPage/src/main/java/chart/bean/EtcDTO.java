package chart.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EtcDTO {
	private int seq;
	private String etcLogtime;
	private String email;
	private int hitHit; 			//조회수
	private int likeLike;			//좋아요수
	private int shareShare;			//공유수
}
