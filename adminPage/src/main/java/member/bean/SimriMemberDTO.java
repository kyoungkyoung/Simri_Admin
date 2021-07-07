package member.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class SimriMemberDTO {
	private String email;
	private String name;
	private String nickname;
	private String pwd;
	private int point;
	private int memsingo;
	private String profile;
	private String palette;
	private String joinType;
	private String condition;
	private int changenick;
	private String signlogtime;
	//private String stoplogtime;
	private String singologtime;
	private int stopPeriod;
	private String singoReason;
	private String stopReason;
	private int todayWriteCount;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yy/MM/dd")
	private Date writeDate;
	
}
