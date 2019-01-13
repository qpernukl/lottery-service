package lottery.my_lottery_practice_app;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class LotteryRepositoryTest {
	@Autowired
	TestEntityManager testEntityManager;
	
	@Autowired
	private LotteryRepository lotteryRepository;
	
	@Test
	public void testFindByDate() {
		Date today = new Date();
		LotteryResult result = new LotteryResult("1 4 31 12 32 42", today);
		lotteryRepository.save(result);
		
		List<LotteryResult> results = lotteryRepository.findByResultDate(today);
		assertThat(results).extracting(LotteryResult::getResult).containsOnly(result.getResult());
	}

}
