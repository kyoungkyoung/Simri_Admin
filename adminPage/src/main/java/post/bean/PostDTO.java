package post.bean;

import java.util.Date;

import lombok.Data;

@Data
public class PostDTO {
	private String category,  email, nickname, palette, subject, content, image;
	private int seq, hit, comSingo, comLike, comShare, reply;
	private Date comLogtime;
	
}
