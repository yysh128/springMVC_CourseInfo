package kr.ac.hansung.cse.model;

//import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Offer {
	
	//NotEmpty = String , NotNull = integer
	
	@NotNull(message="년도를 입력하세요")
	private int year;
	
	@NotNull(message="학기를 입력하세요")
	private int semester;
	
	//@Size(min=2, max=100, message="Name must be between 2 and 100 chars")
	@NotEmpty(message="교과목명을 입력하세요")
	private String name;
	
	//@Email(message="Please provide a valid email address")
	//@NotEmpty(message="The email address cannot be empty")
	@NotEmpty(message="교과구분을 입력하세요")
	private String subject;
	
	@NotEmpty(message="담당교수를 입력하세요")
	private String professor;
	//@Size(min=5, max=100, message="Name must be between 5 and 100 chars")
	
	@NotNull(message="학점을 입력하세요")
	private int credit;

}
