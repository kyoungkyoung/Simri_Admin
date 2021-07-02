package post.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PostDTO {
	private String category,  email, nickname, palette, subject, content, image, testURL,hashTag1,hashTag2,hashTag3;
	private int seq, hit, comSingo, comLike, comShare, reply, point;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yy/MM/dd")
	private Date comLogtime;
	
}
