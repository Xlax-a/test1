<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="com.xlax.Calc" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>行李计算器</title>
</head>
<body>
<img src="标题.png">
<h1>请输入旅客的信息</h1>
<p>
<form action="" method="post" target="_top" name="table">
    座舱类型：
    <select name="a">
        <option value="a1">豪华头等舱</option>
        <option value="a2">头等舱</option>
        <option value="a3">公务舱</option>
        <option value="a4">悦享经济舱</option>
        <option value="a5">超级经济舱</option>
        <option value="a6">经济舱</option>
    </select><br>
    旅客类型：
    <select name="b">
        <option value="b1">成人</option>
        <option value="b2">儿童</option>
        <option value="b3">婴儿</option>
    </select><br>
    VIP卡类型：
    <select name="c">
        <option value="c1">无</option>
        <option value="c2">凤凰知音终生白金卡</option>
        <option value="c3">凤凰知音白金卡</option>
        <option value="c4">凤凰知音金卡</option>
        <option value="c5">凤凰知音银卡</option>
        <option value="c6">星空联盟金卡</option>
    </select><br>
    航班类型：
    <select name="d">
        <option value="d1">区域一</option>
        <option value="d2">区域二</option>
        <option value="d3">区域三</option>
        <option value="d4">区域四</option>
        <option value="d5">区域五</option>
    </select><br>
    一般行李：
    <input type="text" name="normal">格式：尺寸（长宽高之和cm） 重量（kg）<br>
    特殊行李：
    <input type="text" name="special">格式：类型（数字） 重量（kg）<br>
    <input type="submit" value="确定" onclick="<%
    Calc.calcPrice(request.getParameter("a"),
        request.getParameter("b"),
        request.getParameter("c"),
        request.getParameter("d"),
        request.getParameter("normal"),
        request.getParameter("special"));
    %>">
    </form>
</p>
<p>
    行李总价为：<%=Calc.getPrice()%>
</p>
<p>
    注解：<br>
    区域一：美洲（除美国/加拿大外）/加勒比海地区与欧洲/非洲/中东/亚洲/西南太平洋之间的航线；<br>
    区域二：欧洲/中东与非洲/亚洲/西南太平洋之间的航线；<br>
    &emsp;&emsp;日本与西南太平洋之间的航线；<br>
    &emsp;&emsp;日本/西南太平洋与亚洲（不含日本及西南太平洋）/非洲之间航线；<br>
    区域三：加拿大与美洲（除美国/加拿大外）/加勒比海地区/欧洲/非洲/中东/亚洲/西南太平洋之间航线；<br>
    区域四：美国（含夏威夷）与美洲（除美国外）/加勒比海地区/欧洲/非洲/中东/亚洲/西南太平洋之间航线；<br>
    区域五：非洲与亚洲（除日本外）之间航线；<br>
    &emsp;&emsp;欧洲与中东之间航线；亚洲（除日本）内航线；<br>
    &emsp;&emsp;美洲（除美国/加拿大）及加勒比海地区内航线；<br>
    &emsp;&emsp;上述未列明的航线；<br>
    一般行李：空格间隔分别输入每个一般行李的尺寸和重量；<br>
    一般行李尺寸：（60--203）重量：（2--32）<br>
    特殊行李：空格间隔分别输入每一个特殊行李的类型和重量；<br>
    特殊行李类型：<br>
    &emsp;&emsp;1.免费：（无限制）<br>
    &emsp;&emsp;&emsp;&emsp;电动轮椅/电动代步工具/手动轮椅；<br>
    &emsp;&emsp;&emsp;&emsp;机械假肢及专用小型气瓶；<br>
    &emsp;&emsp;&emsp;&emsp;心脏起搏器或其他植入人体的装置；<br>
    &emsp;&emsp;&emsp;&emsp;便携式氧气浓缩机；<br>
    &emsp;&emsp;&emsp;&emsp;持续正压呼吸机；<br>
    &emsp;&emsp;&emsp;&emsp;其他内含锂电池的辅助设备等；<br>
    &emsp;&emsp;&emsp;&emsp;折叠式婴儿车/摇篮/婴儿汽车安全座椅；<br>
    &emsp;&emsp;&emsp;&emsp;导盲犬/助听犬/精神抚慰犬；<br>
    &emsp;&emsp;&emsp;&emsp;骨灰；<br>
    &emsp;&emsp;2.常规：（2--32）<br>
    &emsp;&emsp;&emsp;&emsp;高尔夫球包；<br>
    &emsp;&emsp;&emsp;&emsp;保龄球；<br>
    &emsp;&emsp;&emsp;&emsp;滑翔伞/降落伞；<br>
    &emsp;&emsp;&emsp;&emsp;滑雪/滑水用具（不包括雪橇/水撬）；<br>
    &emsp;&emsp;&emsp;&emsp;轮滑/滑板用具；<br>
    &emsp;&emsp;&emsp;&emsp;潜水用具；<br>
    &emsp;&emsp;&emsp;&emsp;射箭用具；<br>
    &emsp;&emsp;&emsp;&emsp;曲棍球用具；<br>
    &emsp;&emsp;&emsp;&emsp;冰球用具；<br>
    &emsp;&emsp;&emsp;&emsp;网球用具；<br>
    &emsp;&emsp;&emsp;&emsp;登山用具；<br>
    &emsp;&emsp;&emsp;&emsp;自行车；<br>
    &emsp;&emsp;&emsp;&emsp;睡袋；<br>
    &emsp;&emsp;&emsp;&emsp;背包；<br>
    &emsp;&emsp;&emsp;&emsp;野营用具；<br>
    &emsp;&emsp;&emsp;&emsp;渔具；<br>
    &emsp;&emsp;&emsp;&emsp;乐器；<br>
    &emsp;&emsp;&emsp;&emsp;辅助设备（非残疾、伤、病旅客托运）；<br>
    &emsp;&emsp;&emsp;&emsp;可折叠婴儿床/可折叠婴儿车/婴儿摇篮/婴儿汽车安全座椅（非婴儿旅客托运）；<br>
    &emsp;&emsp;3.运动1：（2--45）<br>
    &emsp;&emsp;&emsp;&emsp;皮划艇/独木舟；<br>
    &emsp;&emsp;&emsp;&emsp;悬挂式滑翔运动用具；<br>
    &emsp;&emsp;&emsp;&emsp;雪橇/水撬；<br>
    &emsp;&emsp;&emsp;&emsp;冲浪板；<br>
    &emsp;&emsp;&emsp;&emsp;风帆冲浪用具；<br>
    &emsp;&emsp;&emsp;&emsp;橡皮艇/船；<br>
    &emsp;&emsp;4.运动2：（2--45）<br>
    &emsp;&emsp;&emsp;&emsp;撑杆；<br>
    &emsp;&emsp;&emsp;&emsp;标枪；<br>
    &emsp;&emsp;&emsp;&emsp;单独包装的划船用具/浆；<br>
    &emsp;&emsp;&emsp;&emsp;骑马用具；<br>
    &emsp;&emsp;5.其他1：（2--32）<br>
    &emsp;&emsp;&emsp;&emsp;小型电器或仪器；<br>
    &emsp;&emsp;&emsp;&emsp;媒体设备；<br>
    &emsp;&emsp;6.其他2：（2--32）<br>
    &emsp;&emsp;&emsp;&emsp;可作为行李运输的枪支；<br>
    &emsp;&emsp;7.其他3：（2--5）<br>
    &emsp;&emsp;&emsp;&emsp;可作为行李运输的子弹；<br>
    &emsp;&emsp;8.其他4：（2--32）<br>
    &emsp;&emsp;&emsp;&emsp;小动物（仅限家庭驯养的猫、狗）；<br>
    &emsp;&emsp;&emsp;&emsp;注：每个容器的总重量（包括其中的小动物及水与食物的重量）；<br>
</p>
</body>
</html>

