package boot.test;

import lombok.Data;

/*@Setter
@Getter
@ToString*/ // -> 3개 다 합친게 @Data
@Data
public class TestDto {
	
	private String name;
	private String addr;
	
}
