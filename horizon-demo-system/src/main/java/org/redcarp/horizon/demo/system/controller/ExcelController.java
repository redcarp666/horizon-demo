package org.redcarp.horizon.demo.system.controller;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.redcarp.horizon.infrastructure.utils.ResponseUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author redcarp
 * @date 2024/3/11
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {

	@GetMapping("/export")
	public void export(HttpServletResponse response) throws IOException {
		ExcelExport e1 = new ExcelExport();
		e1.setId("1");
		e1.setUserName("sushuaihao");
		e1.setAge(BigDecimal.valueOf(18));
		e1.setCreateTime(new Date());
		ExcelExport e2 = new ExcelExport();
		e2.setId("2");
		e2.setUserName("Jerry");
		e2.setAge(BigDecimal.valueOf(20));
		e2.setCreateTime(new Date());
		ResponseUtils.responseXLSXFileToDownload(response, "导出测试");
		EasyExcel.write(response.getOutputStream(), ExcelExport.class).sheet("模板").doWrite(ListUtil.of(e1, e2));
	}


	@PostMapping("/upload")
	public String easyExcelUpload(MultipartFile file) throws IOException {
		List<ExcelExport> objects = EasyExcel.read(file.getInputStream()).sheet().doReadSync();
		return JSONUtil.toJsonStr(objects);
	}

	@Data
	@ExcelIgnoreUnannotated
	private static class ExcelExport {
		private String id;
		@ExcelProperty("用户名称")
		private String userName;
		@ExcelProperty("年龄")
		private BigDecimal age;
		@ExcelProperty("创建时间")
		private Date createTime;
	}
}
