package com.leasing.calculate;

import com.leasing.calculate.vo.CalculatorVO;
import com.leasing.calculate.service.CalculateService;
import com.leasing.calculate.dto.CalculatorDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)              //就是指用SpringJUnit4ClassRunner来运行
@WebAppConfiguration                                    //申明这是一个测试
@SpringBootTest(classes=CalculateServiceApplication.class)//引入springboot的入口
@Transactional
public class CalculateServiceApplicationTests {

	@Resource
	CalculateService calculateService;


	@Test
	public void findOne() {
		CalculatorVO vo = calculateService.findOne("0001MG00000000036YJJ");
		System.out.println(vo);
	}

	@Test
	public void findByPkLeaseCalculatorClass() {
		CalculatorDTO vo = calculateService.findByPkLeaseCalculator("0001MG00000000038284", CalculatorDTO.class);
		System.out.println(vo.getQuotName());
		//System.out.println(vo.getLeaseCalculator());
	}

	@Test
	public void findByIsSql() {
		CalculatorDTO vo  = calculateService.findByIsSql("0001MG00000000038284");
		//CalculatorVO vo = JSON.parseObject(JSON.toJSONString(map),CalculatorVO.class);
		System.out.println(vo);
	}

	@Test
	public void updateC(){
		CalculatorVO vo = calculateService.findOne("0001MG00000000038284");
		vo.setQuotName("yjj佳木斯电信-手机终端租赁");
		//vo.setPkLimitPlan(true);
		calculateService.update(vo);
	}

	@Test
	public void findListTest(){
		List<CalculatorVO> list = calculateService.findListTest("0001MG00000000036YJJ");
		System.out.println(list);
	}

	@Test
	public void findListTest1(){
		List<CalculatorVO> list = calculateService.findListTest1("0001MG00000000036YJJ");
		System.out.println(list);
	}

	@Test
	public void findListTest2(){
		List<CalculatorVO> list = calculateService.findListTest2("0001MG00000000036YJJ");
		System.out.println(list);
	}

	@Test
	public void findListTest3(){
		List<CalculatorVO> list = calculateService.findListTest3("0001MG00000000036YJJ");
		System.out.println(list);
	}

}
