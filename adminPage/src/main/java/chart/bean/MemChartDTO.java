package chart.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MemChartDTO {
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yy/MM/dd")
	private Date dt;
	private String dtmonth;
	private int cnt;
}
