package advertise.bean;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AdvertiseDTO {
	private int seq;
	private String category, subject, image;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yy/MM/dd")
	private Date cflogtime;
}
