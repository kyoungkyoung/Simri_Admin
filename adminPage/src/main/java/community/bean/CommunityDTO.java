package community.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CommunityDTO {
	private String category,  email, nickname, palette, subject, content, image;
	private int seq, hit, comSingo, comLike, comShare, reply;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yy/MM/dd")
	private Date comLogtime;
	
}
