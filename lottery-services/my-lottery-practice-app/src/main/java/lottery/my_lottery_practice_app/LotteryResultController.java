package lottery.my_lottery_practice_app;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LotteryResultController {
	@Autowired
	private LotteryRepository lotteryRepository;
	
	@RequestMapping("/resultForDate")
	public LotteryResult getResultForDate(@RequestParam(value="date") Date date) {
		return new LotteryResult("1 2 4 2 3 12", date);
	}
	
	@RequestMapping("/add")
	public @ResponseBody String addLotteryResult(@RequestParam(value="result") String result, @RequestParam(value="resultDate") Date resultDate) {
		LotteryResult lotteryResult = new LotteryResult(result, resultDate);
		lotteryRepository.save(lotteryResult);
		return "Success";
	}
	
	@RequestMapping("/all")
	public @ResponseBody Iterable<LotteryResult> fetchAll() {
		return lotteryRepository.findAll();
	}
}
