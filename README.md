# WEBTest
WEB端自动化
一、使用java+webdrver+testng框架，支持firefox、chrome、ie浏览器
二、使用PO分层原理，将页面元素和界面操作分开保存，页面变化只需更改单个元素即可
三、使用log4j记录测试日志，并自动生成html测试报告
四、部署在jenkins上自动构建任务，开展测试


框架分成三部分：
1.常用工具类：driver启动类及元素查找、常用api二次封装、常用工具类（监听器、随机数、断言等等）
2.脚本管理:页面元素类、页面操作及逻辑处理
3.用例管理：针对单个测试点的数据驱动用例、针对流程测试的用例（使用testng.xml控制用例执行）

