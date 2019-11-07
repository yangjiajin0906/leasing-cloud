package com.leasing.calculate;

import com.leasing.calculate.repository.CalculatorRepo;
import com.leasing.calculate.service.CalculateService;
import com.leasing.common.entity.calculate.dos.CalculatorDO;
import com.leasing.common.entity.calculate.vo.CalculatorVO;
import com.leasing.common.utils.base.DozerUtils;
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

	@Resource
	CalculatorRepo calculatorRepo;

	//避免 n+1 问题 left join feach
	@Test
	public void findOne() {
		CalculatorVO vo = calculateService.findByPk("0001MG00000000038284");
		System.out.println(vo);
	}

	//避免 n+1 问题 left join feach 查list
	@Test
	public void findListTest1(){
		List<CalculatorVO> list = calculateService.findListByPk("0001MG00000000036YJJ");
		System.out.println(list);
	}

	// Dozer vo转do
	@Test
	public void findListTest2(){
		CalculatorVO vo = calculateService.findByPk("0001MG00000000038284");
		CalculatorDO dos = DozerUtils.convert(vo,CalculatorDO.class);
		System.out.println(vo);
	}
	// Dozer do转vo
	@Test
	public void findListTest3(){
		CalculatorDO dos = calculatorRepo.findOne("0001MG00000000038284");
		CalculatorVO vo = DozerUtils.convert(dos,CalculatorVO.class);
		System.out.println(vo);
	}


}
