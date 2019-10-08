package com.leasing.calculate;

import com.leasing.calculate.service.CalculateService;
import com.leasing.calculate.vo.CalculatorVO;
import com.leasing.calculate.vo.OrgRefVO;
import org.hibernate.type.TimestampType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)              //就是指用SpringJUnit4ClassRunner来运行
@WebAppConfiguration                                    //申明这是一个测试
@SpringBootTest(classes=CalculateServiceApplication.class)//引入springboot的入口
@Transactional
public class CalculateServiceApplicationTests {

	@Resource
	CalculateService calculateService;

	@Test
	public void contextLoads() {
		System.out.println(calculateService.findLike("遵义"));
	}

	@Test
	public void deleteById() {
		String id = "0001MG00000000036YJJ";
		calculateService.deleteById(id);
	}

	@Test
	public void testQueryPage() {
		List<CalculatorVO> list = calculateService.query();
		System.out.println(list);
	}

	@Test
	public void testSave() {
		CalculatorVO vo = new CalculatorVO();
		CalculatorVO vo01 = calculateService.findById("0001MG00000000036711");
		vo.setPk_lease_calculator("0001MG00000000036YJJ");
		vo.setQuot_code(vo01.getQuot_code());
		vo.setLease_commencement_date(vo01.getLease_commencement_date());
		vo.setLease_method(vo01.getLease_method());
		vo.setTotal_amount_equipment(vo01.getTotal_amount_equipment());
		vo.setNet_finance_cash(vo01.getNet_finance_cash());
		vo.setIf4basic(vo01.getIf4basic());
		vo.setBillstatus(vo01.getBillstatus());
		vo.setPlan_date_loan(vo01.getPlan_date_loan());
		OrgRefVO org = new OrgRefVO();
		org.setPk_org("1003");
		vo.setPk_org(org);
		vo.setTs("2019-09-26 00:000:00");
		vo.setPk_initial(vo01.getPk_initial());
		calculateService.save(vo);
		System.out.println("111111");
	}

//	@Test
//	public void findById() {
//		CalculatorVO vo = calculateService.findById("0001MG00000000036711");
//		CalculatorDTO dto = CalculatorDTO.entityToDTO(vo);
//		System.out.println(dto);
//	}

	@Test
	public void findById2() {
		CalculatorVO vo = calculateService.findById("0001MG00000000036711");
		vo.getInout_plan_market();
		System.out.println(vo);
	}

}
