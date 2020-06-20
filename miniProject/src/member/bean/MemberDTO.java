package member.bean;

import lombok.Data;

@Data
public class MemberDTO {
	public String name;
	public String id;
	public String pwd;
	public String repwd;
	public String gender;
	public String email1;
	public String email2;
	public String tel1;
	public String tel2;
	public String tel3;
	public String zipcode;
	public String addr1;
	public String addr2;
	//이름
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//아이디
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	//비밀번호
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	//비밀번호 재확인
	public String getRepwd() {
		return repwd;
	}
	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}
	//성별
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	//이메일
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	//핸드폰번호
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getTel3() {
		return tel3;
	}
	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}
	//주소
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	
}
