package Tools.TestNg;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import TestData.GlobalData;
import Tools.ScreenShot.ScreenShot;
import Tools.Tool.MyDate;
import Tools.Tool.RandomNum;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestResultListener extends TestListenerAdapter {
	private String reportPath;
	static String path = System.getProperties().getProperty("user.dir");
	private static Logger logger = Logger.getLogger(TestResultListener.class);
	@Override
	public void onStart(ITestContext context) {
		File htmlReportDir = new File(path+"/test-output");
		if (!htmlReportDir.exists()) {
			htmlReportDir.mkdirs();
		}
		String reportName = "GuCang"+ MyDate.format(MyDate.time8)+".html";
		reportPath = htmlReportDir+"/"+reportName;
		File report = new File(htmlReportDir,reportName);
		if(report.exists()){
			try {
				report.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		StringBuilder my = new StringBuilder(
		"<html>\n"
		+"<head>\n"
		+"\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n"
		+"\t\t<title >自动化测试报告</title>\n"
		+"\t\t<link href=\"js/reportng.css\" rel=\"stylesheet\" type=\"text/css\" />\n"
		+"\t\t<script type=\"text/javascript\" src=\"js/reportng.js\"></script>\n"
		+"</head>\n"
		+"<body style=\"background:#F0FFFF\">\n"
		+"\t\t<div id=\"top\" align=\"center\">\n"
		+"\t\t\t<br>\n"
		+"\t\t\t<p style=\"font-weight:bold;font-size:32px;font-family:宋体标题;\">谷 仓 测 试 报 告</p>\n"
		+"\t\t\t<br>\n"
		+"\t\t\t<br>\n"
		+"\t\t\t<table width=\"95%\" height=\"200\" border=\"1\" align=\"center\" cellspacing=\"0\" rules=\"all\" style=\"font-family:楷体;table-layout:fixed;font-size:20px;\" width=\"500px\">\n"
		+"\t\t\t\t<thead>\n"
		+"\t\t\t\t\t<tr height=\"50\">\n"
		+"\t\t\t\t\t\t<th>测试时间</th>\n"
		+"\t\t\t\t\t\t<th>"+ MyDate.format(MyDate.DEFAULT_DATE_FORMAT)+"</th>\n"
		+"\t\t\t\t\t\t<th>测试版本</th>\n"
		+"\t\t\t\t\t\t<th colspan=\"2\">"+ GlobalData.version+"</th>\n"
		+"\t\t\t\t\t</tr>\n"
		+"\t\t\t\t\t<tr height=\"50\">\n"
		+"\t\t\t\t\t\t<th  WIDTH=\"150px\" >用例名称</th>\n"
		+"\t\t\t\t\t\t<th  WIDTH=\"300px\" >测试步骤</th>\n"
		+"\t\t\t\t\t\t<th  WIDTH=\"500px\" >日志详情</th>\n"
		+"\t\t\t\t\t\t<th  WIDTH=\"200px\" >截图展示</th>\n"
		+"\t\t\t\t\t\t<th  WIDTH=\"100px\" >测试结果</th>\n"
		+"\t\t\t\t\t</tr>\n"
		+"\t\t\t\t</thead>\n"
		+"\t\t\t\t<tbody style=\"font-family:楷体;table-layout:fixed;font-size:16px\" align=\"center\" >\n"
		);
		String res = my.toString();
		logger.info(context.getName() + " Start");
		try {
			Files.write((Paths.get(reportPath)), res.getBytes("utf-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//如果report.html已记录该class下的mothod失败结果，则再重新记录
		//检查html是否已经写入了该mothod失败结果
		boolean iswrite=new ReadHtml().gethtmltext(reportPath, String.valueOf(result.getMethod().getRealClass()), result.getMethod().getMethodName());
		if(iswrite){
			// 自动截图
			String picname=ScreenShot.screenShots(1);
			StringBuilder my = new StringBuilder(
					"\t\t\t\t\t<tr height=\"120\">\n"
			);
			my.append("\t\t\t\t\t<td style=\"word-wrap:break-word;\">"+result.getMethod().getRealClass()+"</td>\n");
			my.append("\t\t\t\t\t<td style=\"word-wrap:break-word;\">"+result.getMethod().getMethodName()+"</td>\n");
			my.append("\t\t\t\t\t<td style=\"word-wrap:break-word;\">\n");
			long id= new RandomNum().getNumRandom(5);
			my.append("\t\t\t\t\t\t<a align=\"left\" href=\"javascript:toggleElement('exception-"+id+"', 'block')\" title=\"Click to expand/collapse\"><b><font color=\"red\">"+result.getMethod().getMethodName()+"已执行失败，原因：</font></b></a>\n");
			my.append("\t\t\t\t\t\t\t<br>\n");
			String msgerr0=this.geterror(result);
			my.append("\t\t\t\t\t\t\t<div align=\"left\" class=\"stackTrace\" id=\"exception-"+id+"\" ><small>"+ msgerr0 + "</small> \n");
			my.append("\t\t\t\t\t\t\t</div>\n");
			my.append("\t\t\t\t\t\t</p>\n");
			my.append("\t\t\t\t\t</td>\n");
			my.append("\t\t\t\t\t<td><a href=\"./screenshot/"+picname+"\" target=\"_blank\">\n" +
					"\t\t\t\t\t\t\t\t<img src=\"./screenshot/"+picname+"\" height=\"110\" weight=\"90\"/></a>\n" +
					"\t\t\t\t\t</td>\n");
			my.append("\t\t\t\t\t<td><font color=\"red\">Fail</font></td>\n" );
			my.append("\t\t\t\t</tr>\n");
			String msg = my.toString();
			try {
				Files.write((Paths.get(reportPath)),msg.getBytes("utf-8"), StandardOpenOption.APPEND);
			} catch (IOException e) {
				e.printStackTrace();
			}
			logger.info(result.getMethod().getMethodName() + " Failure");
		}else {
			logger.info(result.getMethod().getMethodName()+"失败日志已记录！");
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// 自动截图
		String picname=ScreenShot.screenShots(1);
		StringBuilder my = new StringBuilder(
				"\t\t\t\t\t<tr height=\"120\">\n"
		);
		my.append("\t\t\t\t\t<td style=\"word-wrap:break-word;\">"+result.getMethod().getRealClass()+"</td>\n");
		my.append("\t\t\t\t\t<td style=\"word-wrap:break-word;\">"+result.getMethod().getMethodName()+"</td>\n");
		my.append("\t\t\t\t\t<td style=\"word-wrap:break-word;\">\n");
		long id= new RandomNum().getNumRandom(5);
		my.append("\t\t\t\t\t\t<a align=\"left\" href=\"javascript:toggleElement('exception-"+id+"', 'block')\" title=\"Click to expand/collapse\"><b><font color=\"GoldenRod\">"+result.getMethod().getMethodName()+"未执行跳过，原因：</font></b></a>\n");
		my.append("\t\t\t\t\t\t\t<br>\n");
		String msgerr1=this.geterror(result);
		my.append("\t\t\t\t\t\t\t<div align=\"left\" class=\"stackTrace\" id=\"exception-"+id+"\" ><small>"+msgerr1+ "</small> \n");
		my.append("\t\t\t\t\t\t\t</div>\n");
		my.append("\t\t\t\t\t\t</p>\n");
		my.append("\t\t\t\t\t</td>\n");
		my.append("\t\t\t\t\t<td><a href=\"./screenshot/"+picname+"\" target=\"_blank\">\n" +
				"\t\t\t\t\t\t\t\t<img src=\"./screenshot/"+picname+"\" height=\"110\" weight=\"90\"/></a>\n" +
				"\t\t\t\t\t</td>\n" );
		my.append("\t\t\t\t\t<td><font color=\"GoldenRod\">Skipped</font></td>\n" );
		my.append("\t\t\t\t</tr>\n");
		String msg = my.toString();
		try {
			Files.write((Paths.get(reportPath)),msg.getBytes("utf-8"), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info(result.getMethod().getMethodName() + "Skipped");
	}

	@Override

	public void onTestSuccess(ITestResult result) {
		// 自动截图
		String picname=ScreenShot.screenShots(1);
		StringBuilder my = new StringBuilder("\t\t\t\t\t<tr height=\"120\">\n");
		my.append("\t\t\t\t\t\t<td style=\"word-wrap:break-word;\">"+result.getMethod().getRealClass()+"</td>\n");
		my.append("\t\t\t\t\t\t<td style=\"word-wrap:break-word;\">" + result.getMethod().getMethodName()+"</td>\n");
		long id= new RandomNum().getNumRandom(5);
		my.append("\t\t\t\t\t\t<td style=\"word-wrap:break-word;\">\n" +
				"\t\t\t\t\t\t<a align=\"left\" href=\"javascript:toggleElement('exception-"+id+"', 'block')\" title=\"Click to expand/collapse\">" +
				"<b><font color=\"LimeGreen\">"+result.getMethod().getMethodName()+"已执行通过，结果：</font></b></a>\n" +
				"\t\t\t\t\t\t\t<br>\n" +
				"\t\t\t\t\t\t\t<div align=\"left\" class=\"stackTrace\" id=\"exception-"+id+"\" ><small>"+result.getMethod().getMethodName()+ " Success"+"</small> \n" +
				"\t\t\t\t\t\t\t</div>\n" +
				"\t\t\t\t\t\t</p>\n" +
				"\t\t\t\t\t\t</td>\n");
		my.append("\t\t\t\t\t<td><a href=\"./screenshot/"+picname+"\" target=\"_blank\">" +
				"\t\t\t\t\t\t\t\t<img src=\"./screenshot/"+picname+"\" height=\"110\" weight=\"90\"/></a>" +
				"\t\t\t\t\t</td>\n" );
		my.append("\t\t\t\t\t\t<td><font color=\"LimeGreen\">Pass</font></td>\n" +
				"\t\t\t\t\t</tr>\n");
		String msg = my.toString();
		try {
			Files.write((Paths.get(reportPath)),msg.getBytes("utf-8"), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info(result.getMethod().getMethodName() + " Success");
	}

	@Override
	public void onFinish(ITestContext context) {
		StringBuilder my=new StringBuilder("\t" );
			my.append("\t\t\t\t</tbody>\n" +
					"\t\t\t</table>\n" +
					"\t\t\t<br>\n" +
					"\t\t\t<br><a href=\"#top\" style=\"font-size:18px;\">返回顶部</a>\n" +
					"\t</div>\n" +
					"</body>\n" +
					"</html>");
		String msg = my.toString();
		try {
			Files.write((Paths.get(reportPath)),msg.getBytes("utf-8"), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private  String geterror(ITestResult result){
		StringBuilder sb=new StringBuilder();
		Throwable throwable = result.getThrowable();
		sb.append(throwable.toString()).append("\r\n");
		StackTraceElement[] ste = throwable.getStackTrace();
		if(ste != null)
			{
				for (int i = 0; i < ste.length; i++)
				{
					sb.append(ste[i].toString());
					sb.append("\r\n");
				}
			}
		return sb.toString();
	}

}
