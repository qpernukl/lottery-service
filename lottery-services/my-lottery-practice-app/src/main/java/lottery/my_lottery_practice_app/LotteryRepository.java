package lottery.my_lottery_practice_app;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LotteryRepository extends CrudRepository<LotteryResult, Long>{
	List<LotteryResult> findByResultDate(Date date);
}
