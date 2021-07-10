package community.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ReplyDTO {
	
	private String email, nickname, palette, profile, replycomment, replysingoreason;
	private int seq, replyseq, ref, lev, step, pseq, reply, hit, replysingo;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yy/MM/dd")
	private Date replylogtime;

}
