package lottery.my_lottery_practice_app;

import java.util.Date; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class LotteryResult {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String result;
	@Temporal(TemporalType.DATE)
	private Date resultDate;
	
	
	public LotteryResult(String numbers, Date date) {
		super();
		this.result = numbers;
		this.resultDate = date;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Date getDate() {
		return resultDate;
	}
	public void setDate(Date date) {
		this.resultDate = date;
	}
	
	
}
