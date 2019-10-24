package com.leasing.calculate;

import com.alibaba.fastjson.JSON;
import com.leasing.calculate.dos.CalculatorDO;
import com.leasing.calculate.repository.CalculatorRepository;
import com.leasing.calculate.vo.CalculatorVO;
import com.leasing.calculate.service.CalculateService;
import com.leasing.calculate.dto.CalculatorDTO;
import com.leasing.common.utils.DozerUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)              //就是指用SpringJUnit4ClassRunner来运行
@WebAppConfiguration                                    //申明这是一个测试
@SpringBootTest(classes=CalculateServiceApplication.class)//引入springboot的入口
@Transactional
public class CalculateServiceApplicationTests {

	@Resource
	CalculateService calculateService;

	@Resource
	CalculatorRepository calculatorRepository;

	//避免 n+1 问题 left join feach
	@Test
	public void findOne() {
		CalculatorVO vo = calculateService.findOne("0001MG00000000038284");
		System.out.println(vo);
	}

	//动态投影
	@Test
	public void findByPkLeaseCalculatorClass() {
		CalculatorDTO vo = calculateService.findByPkLeaseCalculator("0001MG00000000038284", CalculatorDTO.class);
		System.out.println(vo.getQuotName());
		//System.out.println(vo.getLeaseCalculator());
	}

	//自定义sql new对象
	@Test
	public void findByIsSql() {
		CalculatorDTO vo  = calculateService.findByIsSql("0001MG00000000038284");
		//CalculatorVO vo = JSON.parseObject(JSON.toJSONString(map),CalculatorVO.class);
		System.out.println(vo);
	}

	//自定义sql 别名
	@Test
	public void findByIsSql2() {
		Map<String,Object> map = calculateService.findByIsSql2("0001MG00000000038284");
		Map<String,Object> map2 = new HashMap<String,Object>();
		for(String key:map.keySet()){//keySet获取map集合key的集合  然后在遍历key即可
			map2.put(key,map.get(key));
		}
		CalculatorVO vo = DozerUtils.convert(map2,CalculatorVO.class);
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
		CalculatorVO vo = calculateService.findOne("0001MG00000000038284");
		CalculatorDO dos = DozerUtils.convert(vo,CalculatorDO.class);
		System.out.println(vo);
	}
	// Dozer do转vo
	@Test
	public void findListTest3(){
		CalculatorDO dos = calculatorRepository.findOne("0001MG00000000038284");
		CalculatorVO vo = DozerUtils.convert(dos,CalculatorVO.class);
		System.out.println(vo);
	}


}
