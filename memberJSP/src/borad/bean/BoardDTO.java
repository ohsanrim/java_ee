package borad.bean;

import lombok.Data;

@Data
public class BoardDTO {
	public int seq;
	public String id;
	public String name;
	public String email;
	public String subject;
	public String content;
	public int ref;
	public int lev;
	public int step;
	public int pseq;
	public int reply;
	public int hit;
	public String logtime;
}
