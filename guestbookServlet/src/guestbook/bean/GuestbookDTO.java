package guestbook.bean;

import lombok.Data;

@Data
public class GuestbookDTO {
		public int seq;
		public String name;
		public String email;
		public String homepage;
		public String subject;
		public String content;
		public String logtime;
		public String getLogtime() {
			return logtime;
		}
		public void setLogtime(String logtime) {
			this.logtime=logtime;
		}
		public int getSeq() {
			return seq;
		}
		public void setSeq(int seq) {
			this.seq=seq;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getHomepage() {
			return homepage;
		}
		public void setHomepage(String homepage) {
			this.homepage = homepage;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		
		
}
